package de.ghost.ghostsystem.tpa;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class TpView implements CommandExecutor {

    // Grab singleton instance
    TpQueue tpQueue = TpQueue.INSTANCE;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            TpRequest tpRequest = tpQueue.TELEPORT_REQUESTS.get(player);
            if (tpRequest == null) {
                player.sendMessage(ChatColor.GOLD + "You have no teleport request, sorry!");
                return true;
            }
            String tpRequesteeName = ChatColor.LIGHT_PURPLE + tpRequest.TpRequest.getName();
            if (!tpRequest.isReversed) {
                player.sendMessage(ChatColor.GOLD + "Current Request: " + tpRequesteeName + ChatColor.GOLD + " has requested to teleport to you! use /tpaccept to accept!");
                return true;
            } else if (tpRequest.isReversed) {
                player.sendMessage(ChatColor.GOLD + "Current Request: " + tpRequesteeName + ChatColor.GOLD + " has requested you teleport to them! use /tpaccept to accept!");
                return true;
            }
        }
        return false;
    }
}
