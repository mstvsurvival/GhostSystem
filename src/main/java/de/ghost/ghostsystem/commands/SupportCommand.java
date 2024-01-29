package de.ghost.ghostsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SupportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            p.sendMessage("§a[§cGhostSystem§a] §cDu musst ein Spieler sein um diesen Command ausführen zu können");
        } else {
            if (args.length == 0) {
                p.sendMessage("§a[§cGhostSystem§a] Bitte Warte...! Ein Supporter meldet sich bald bei dir");

                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (players.hasPermission("ghostsys.supporter")) {
                        players.sendMessage("§a[§cGhostSystem§a] Der Spieler §c" + p.getName() + " §amöchte Support haben");
                    }
                }

            } else {
                p.sendMessage("§a[§cGhostSystem§a] §cUsage: /support");
            }
        }
        return false;
    }
}
