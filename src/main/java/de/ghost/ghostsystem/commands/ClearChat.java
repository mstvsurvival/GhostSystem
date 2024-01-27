package de.ghost.ghostsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ghostsys.clearchat")) {
                for (int i = 0;i<100; i++) {
                    Bukkit.broadcastMessage("  ");
                }
                Bukkit.broadcastMessage("§a[§cGhostSystem§a] Der Chat wurde gecleart");
            } else {
                p.sendMessage("§a[§cGhostSystem§a] Usage: /clearchat");
            }
        }
        return false;
    }
}
