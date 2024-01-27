package de.ghost.ghostsystem.commands;


import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                if (p.hasPermission("ghostsys.heal")) {
                    p.setHealth(20);
                    p.setFoodLevel(20);
                    p.setFireTicks(0);
                    p.sendMessage("§a[§cGhostSystem§a] Du wurdest geheilt.");
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP , 5, 5);
                }else {
                    p.sendMessage("§a[§cGhostSystem§a] Dazu hast du keine Rechte");
                }
            } else {
                if (args.length == 1) {
                    if (p.hasPermission("ghostsys.heal.other")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.setHealth(20);
                            target.setFoodLevel(20);
                            target.setFireTicks(0);
                            p.sendMessage("§[§cGhostSystem§a] Du hast den angegebenen Spieler geheilt.");
                            target.sendMessage("§a[§cGhostSystem§a] Du wurdest von einem Spieler geheilt.");
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP , 5, 5);
                        } else {
                            p.sendMessage("§a[§cGhostSystem§a] Der Spieler ist nicht Online");
                        }
                    } else {
                        p.sendMessage("§a[§cGhostSystem§a] Dazu hast du keine Rechte");
                    }
                } else {
                    p.sendMessage("§a[§cGhostSystem§a] Usage: /heal <player>");
                }
            }
        }
        return false;
    }
}
