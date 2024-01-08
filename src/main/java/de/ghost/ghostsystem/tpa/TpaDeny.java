package de.ghost.ghostsystem.tpa;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class TpaDeny implements CommandExecutor {

    TpQueue tpQueue = TpQueue.INSTANCE;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            TpRequest tpRequest = tpQueue.TELEPORT_REQUESTS.get(player);
            if (tpRequest == null) {player.sendMessage(ChatColor.GOLD + "Du hast keine Teleportations Anfragen!"); return true;}
            tpRequest.TpRequest.sendMessage(ChatColor.GOLD + player.getName() + " Der Spieler hat deine Teleportations Anfragen blockiert!");
            tpQueue.TELEPORT_REQUESTS.remove(player);
            return true;
        }

        return false;
    }
}

