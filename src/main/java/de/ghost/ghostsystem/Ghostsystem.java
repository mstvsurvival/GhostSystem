package de.ghost.ghostsystem;

import de.ghost.ghostsystem.Listerners.BlockListeners;
import de.ghost.ghostsystem.Listerners.ConnectionListeners;
import de.ghost.ghostsystem.commands.AdminItemsCommand;
import de.ghost.ghostsystem.commands.MeinSchwert;
import de.ghost.ghostsystem.commands.WarpCommand;
import de.ghost.ghostsystem.util.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Ghostsystem extends JavaPlugin {
    private static Config cfg;
    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("meinschwert")).setExecutor(new MeinSchwert());
        Objects.requireNonNull(getCommand("adminitems")).setExecutor(new AdminItemsCommand());
        Objects.requireNonNull(getCommand("warp")).setExecutor(new WarpCommand());

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ConnectionListeners(), this);
        pluginManager.registerEvents(new BlockListeners(), this);
        cfg = new Config("warps.yml" , getDataFolder());
    }
    public static String getPrefix(){
        return ChatColor.GRAY + "[" + ChatColor.BLUE + "Ghost" + ChatColor.GRAY + "] ";
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Config getCfg() {
        return cfg;
    }
}