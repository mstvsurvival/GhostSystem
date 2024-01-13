package de.ghost.ghostsystem.tpa;

import de.ghost.ghostsystem.Ghostsystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tpa implements CommandExecutor {

    TpQueue tpQueue = TpQueue.INSTANCE;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {return false;}

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Player receiver = Bukkit.getPlayerExact(args[0]);
            if (receiver == null) {return false;}
            TpQueue.TELEPORT_REQUESTS.put(receiver, new TpRequest(player, false));
            player.sendMessage(ChatColor.GREEN + "Du hast " + player.getName() + " eine Teleportations Anfrage geschickt!");
            receiver.sendMessage(ChatColor.RED + player.getName() + ChatColor.GOLD + " möchte sich zu dir Teleportieren!");
            return true;
        }
        return false;
    }
}