package de.ghost.ghostsystem.commands;

import de.ghost.ghostsystem.util.WarpManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player p = (Player) sender;
        if (args.length == 1) {
            if (WarpManager.getWarp(args[0]) != null) {
                p.teleport(WarpManager.getWarp(args[0]));
                p.sendMessage("Du wurdest zu den Warp " + args[0] + " teleportiert!");
            } else {
                p.sendMessage("§cDiesen Warp gibt es nicht!");

            }
        }
        if (args[0].equalsIgnoreCase("add")) {
            if (WarpManager.getWarp(args[1]) == null) {
                WarpManager.createWarp(args[1], p.getLocation());
                p.sendMessage("Du hast den Warp " + args[1] + " erstellt!");
            } else {
                p.sendMessage("§cDiesen Warp gibt es schon!");
            }
        } else if (args[0].equalsIgnoreCase("delete")) {
            if (WarpManager.getWarp(args[1]) != null) {
                WarpManager.deleteWarp(args[1]);
                p.sendMessage("Du hast den Warp " + args[1] + " gelöscht!");
            } else {
                p.sendMessage("§cDiesen Warp gibt es nicht!");
            }

        }

        return false;
    }
}




