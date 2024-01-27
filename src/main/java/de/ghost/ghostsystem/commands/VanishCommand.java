package de.ghost.ghostsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {

    ArrayList <String> vanish = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ghostsys.vanish")) {
                if (args.length == 0) {
                    if (vanish.contains(p.getName())) {
                        vanish.remove(p.getName());
                        p.sendMessage("§a[§cGhostSystem§a] Der Vanish wurde §cDeaktiviert");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.showPlayer(p);
                        }
                    } else {
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.hidePlayer(p);
                        }
                        vanish.add(p.getDisplayName());
                        p.sendMessage("§a[§cGhostSystem§a] Der Vanish wurde §cAktiviert");
                    }
                } else {
                    if (p.hasPermission("ghostsys.vanish.other")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            if (vanish.contains(target.getName())) {
                                vanish.remove(target.getName());
                                target.sendMessage("§a[§cGhostSystem§a] Der Vanish wurde §cDeaktiviert");
                                p.sendMessage("Du hast den Vanish des Spielers §cDeaktiviert");
                                for (Player all : Bukkit.getOnlinePlayers()) {
                                    all.showPlayer(target);
                                }
                            } else {
                                for (Player all : Bukkit.getOnlinePlayers()) {
                                    all.hidePlayer(target);
                                }
                                vanish.add(target.getDisplayName());
                                target.sendMessage("§a[§cGhostSystem§a] Der Vanish wurde §cAktiviert");
                                p.sendMessage("Du hast den Vanish des Spielers §cAktiviert");
                            }
                        } else {
                            p.sendMessage("§a[§cGhostSystem§a] Dieser Spieler ist nicht Online");
                        }
                    } else {
                        p.sendMessage("§a[§cGhostSystem§a] Usage: /vanish <player>");
                    }
                }
            } else {
                p.sendMessage("§a[§cGhostSystem§a] Dazu hast du keine Rechte");
            }
        }
        return false;
    }
}
