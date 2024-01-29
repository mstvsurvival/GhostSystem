package de.ghost.ghostsystem.Listerners;

import de.ghost.ghostsystem.Ghostsystem;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.DARK_GRAY + "[+] " + ChatColor.YELLOW + player.getName());
        Ghostsystem.getInstance().sendDiscord(event.getPlayer().getName() + " hat den Server betreten");
    }


    @EventHandler
    public void onLeft(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.DARK_GRAY + "[-] " + ChatColor.YELLOW + player.getName());
        Ghostsystem.getInstance().sendDiscord(event.getPlayer().getName() + " hat den Server verlassen");
    }
}
