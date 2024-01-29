package de.ghost.ghostsystem.Economy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class EconomySystem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("§a[§cGhostSystem§a] Dein Money: " + getMoney(player.getName()));
        }

        if (args.length < 3) {
            if (args.length == 2 && args[0].equalsIgnoreCase("add")) {
                player.sendMessage("Usage: /money <add/set/take/pay> <player> <amount>");
            }
            return true;
        }

        String targetPlayerName = args[1];
        Player targetPlayer = player.getServer().getPlayer(targetPlayerName);

        if (targetPlayer == null || !targetPlayer.isOnline()) {
            player.sendMessage("§a[§cGhostSystem§a] §cDieser Spieler ist nicht Online.");
            return true;
        }

        int amount;

        try {
            amount = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            player.sendMessage("§a[§cGhostSystem§a] §cFalsche Angabe.");
            return true;
        }

        if (args[0].equalsIgnoreCase("set")) {
            setMoney(targetPlayerName, amount);
            player.sendMessage("§a[§cGhostSystem§a] Money vom Spieler§c " + targetPlayerName + " §aauf§c " + amount + " §agesetzt.");
        } else if (args[0].equalsIgnoreCase("add")) {
            addMoney(targetPlayerName, amount);
            player.sendMessage("§a[§cGhostSystem§a]§c" + amount + " §awurde dem Spieler§c " + targetPlayerName + "§ahinzugefügt.");
        } else if (args[0].equalsIgnoreCase("take")) {
            takeMoney(targetPlayerName, amount);
            player.sendMessage("§a[§cGhostSystem§a] Du hast " + amount + " von dem Spieler " + targetPlayerName + "bekommen.");
        } else if (args[0].equalsIgnoreCase("pay")) {
            payMoney(player, targetPlayer, amount);
        } else {
            player.sendMessage("§a[§cGhostSystem§a] §cUsage: /money <set/add/take/pay> <player> <amount>");
        }

        return true;
    }

    private File getMoneyFile(String Money) {
        return new File("plugins/ghostsystem", "money.yml");
    }

    private FileConfiguration getMoneyConfig(String money) {
        File file = getMoneyFile(money);
        return YamlConfiguration.loadConfiguration(file);
    }

    private void saveMoneyConfig(String money, FileConfiguration config) {
        File file =getMoneyFile(money);
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException("§a[§cGhostSystem§a] Fehlheschlagen vom speichern der .yml von " + money, e);
        }
    }

    private Integer getMoney(String name) {
        File file = new File("plugins/ghostsystem", "money.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int money = cfg.getInt(name + ".money");
        return money;
    }

    private void setMoney(String name, int amount) {
        File file = new File("plugins/ghostsystem", "money.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        cfg.set(name + ".money", amount);
        try {
            cfg.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addMoney(String name, int amount) {
        File file = new File("plugins/ghostsystem", "money.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int money = cfg.getInt(name + ".money");
        money=money+amount;
        cfg.set(name + ".money", money);
        try {
            cfg.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void takeMoney(String playerName, int amount) {
        int currentMoney = getMoney(playerName);
        setMoney(playerName, Math.max(0, currentMoney - amount));
    }

    private void payMoney(Player sender, Player receiver, int amount) {
        String senderName = sender.getName();
        String receiverName = receiver.getName();

        if (getMoney(senderName) < amount) {
            sender.sendMessage("§a[§cGhostSystem§a] §cNicht genug Money");
            return;
        }

        takeMoney(senderName, amount);
        addMoney(receiverName, amount);

        sender.sendMessage("§a[§cGhostSystem§a] Du hast§c  " + amount + " §aan§c " + receiverName + " gesendet.");
        receiver.sendMessage("§a[§cGhostSystem§a]§c " + senderName + " §ahat dir§c " + amount + " gesendet.");
    }
}
