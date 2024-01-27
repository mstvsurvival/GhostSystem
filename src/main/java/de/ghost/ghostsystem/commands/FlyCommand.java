package de.ghost.ghostsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ghostsys.fly")) {
                if (args.length == 0) {
                    if (p.getAllowFlight()) {
                        p.setAllowFlight(false);
                        p.setFlying(false);
                        p.sendMessage("§a[§cGhostSystem§a] Der Fly Mode wurde §cDeaktiviert");
                    } else {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.sendMessage("§a[§cGhostSystem§a] Der Fly Mode wurde §cAktiviert");
                    }
                } else {
                    if (args.length == 1) {
                        if (p.hasPermission("ghostsys.fly.other")) {
                            Player target = Bukkit.getPlayer(args[0]);
                            if (target != null) {
                                if (target.getAllowFlight()) {
                                    target.setAllowFlight(false);
                                    target.setFlying(false);
                                    target.sendMessage("§a[§cGhostSystem§a] Der Fly Mode wurde §cDeaktiviert");
                                    p.sendMessage("§a[§cGhostSystem§a] Du hast den Fly Mode vom Spieler §cDeaktiviert");
                                } else {
                                    target.setAllowFlight(true);
                                    target.setFlying(true);
                                    target.sendMessage("§a[§cGhostSystem§a] Dein Fly Mode wurde §cAktiviert");
                                    p.sendMessage("§a[§cGhostSystem§a] Du hast den Fly Mode von dem Spieler §cAktiviert");
                                }
                            } else {
                                p.sendMessage("§a[§cGhostSystem§a] Dieser Spieler ist nicht Online");
                            }
                        } else {
                            p.sendMessage("§a[§cGhostSystem§a] Usage: /fly <player>");
                        }
                    } else {
                        p.sendMessage("§a[§cGhostSystem§a] Dazu hast du keine Rechte");
                    }
                }
            }
            }
        return false;
    }
}
