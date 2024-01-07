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
    private static Ghostsystem instance;
    @Override
    public void onEnable() {
        instance = this;
        getCommand("meinschwert").setExecutor(new MeinSchwert());
        getCommand("adminitems").setExecutor(new AdminItemsCommand());
        getCommand("warp").setExecutor(new WarpCommand());

        cfg = new Config("warps.yml" , getDataFolder());
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ConnectionListeners(), this);
        pluginManager.registerEvents(new BlockListeners(), this);
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

    public static Ghostsystem getInstance() {
        return instance;
    }
}


