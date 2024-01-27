package de.ghost.ghostsystem;


import de.ghost.ghostsystem.Listerners.ConnectionListeners;
import de.ghost.ghostsystem.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Ghostsystem extends JavaPlugin {
    private static Ghostsystem instance;

    public static File file;
    public static FileConfiguration cfg;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Ghostsystem.file = new File("plugins/GhostSystem", "config.yml");
        Ghostsystem.cfg = YamlConfiguration.loadConfiguration(Ghostsystem.file);
        getCommand("meinschwert").setExecutor(new MeinSchwert());
        getCommand("adminitems").setExecutor(new AdminItemsCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("clearchat").setExecutor(new ClearChat());
        getCommand("kopf").setExecutor(new KopfCommand());
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("ec").setExecutor(new EnderchestCommand());
        getCommand("gm1").setExecutor(new GamemodeCommand());
        getCommand("gm0").setExecutor(new GamemodeSurvivalCommand());
        getCommand("gm3").setExecutor(new GamemodeSpectatorCommand());






        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ConnectionListeners(), this);
    }
    public static String getPrefix(){
        return ChatColor.GRAY + "[" + ChatColor.BLUE + "Ghost" + ChatColor.GRAY + "] ";
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



    public static Ghostsystem getInstance() {
        return instance;
    }

}


