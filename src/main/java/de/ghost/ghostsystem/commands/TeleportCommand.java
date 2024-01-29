package de.ghost.ghostsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§a[§cGhostSystem§a] §cDu musst ein Spieler sein");
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("ghostsys.teleport")) {
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null) {

                        if (p != target) {


                            p.teleport(target);
                            p.sendMessage("§aDu hast dich zum Spieler §c" + target.getName() + "§ateleportiert");
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                        } else {
                            p.sendMessage("§cDu kannst dich nicht zu dir selber Teleportieren");
                        }
                    }else {
                        p.sendMessage("§aDer Spieler §c" + args[0] + " §aist nicht Online");
                    }
                } else {
                    p.sendMessage("§cUsage: /teleport <spieler>");
                }
            }
            return false;
        }
        return false;
    }
            }

