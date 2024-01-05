package de.ghost.ghostsystem.warp;

import de.ghost.ghostsystem.Ghostsystem;
import org.bukkit.Location;

public class WarpManager {


    public static Location getWarp(String name){
        return Ghostsystem.getCfg().getConfiguration().getLocation(name);
    }


    public static Location createWarp(String name , Location location){
        Ghostsystem.getCfg().set(name, location);
        Ghostsystem.getCfg().save();
        return Ghostsystem.getCfg().getConfiguration().getLocation(name);

    }
    public static void deleteWarp(String name) {
        Ghostsystem.getCfg().set(name, null);
        Ghostsystem.getCfg().save();
        Ghostsystem.getCfg().getConfiguration().getLocation(name);
    }

}

