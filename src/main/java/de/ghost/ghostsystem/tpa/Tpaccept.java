package de.ghost.ghostsystem.tpa;

import jdk.vm.ci.meta.PlatformKind;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;

public class Tpaccept implements CommandExecutor {

    TpQueue tpQueue = TpQueue.INSTANCE;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            TpRequest tpRequest = tpQueue.TELEPORT_REQUESTS.get(player);
            if (tpRequest == null) {player.sendMessage(ChatColor.GOLD + "Du hast keine Teleportations Anfragen!"); return true;}
            if (!tpRequest.isReversed) {
                tpQueue.PREVIOUS_LOCATIONS.put(tpRequest.TpRequest, tpRequest.TpRequest.getLocation());
                tpRequest.TpRequest.teleport(player);
                tpQueue.TELEPORT_REQUESTS.remove(player);
            return true;
            } else if (tpRequest.isReversed) {
                    tpQueue.PREVIOUS_LOCATIONS.put(player, player.getLocation());
                    player.teleport(tpRequest.TpRequest);
                    tpQueue.TELEPORT_REQUESTS.remove(player);
                    return true;

            }
        }
        return false;
    }
}

