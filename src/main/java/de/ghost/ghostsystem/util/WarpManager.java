package de.ghost.ghostsystem.util;

import de.ghost.ghostsystem.Ghostsystem;
import org.bukkit.Location;

public class WarpManager {

    public static Location getWarp(String name) {
        return Ghostsystem.getCfg().getConfiguration().getLocation(name);
    }

    public static void createWarp(String name, Location location) {
        Ghostsystem.getCfg().set(name, location);
        Ghostsystem.getCfg().save();
    }

    public static void deleteWarp(String name) {
        Ghostsystem.getCfg().set(name , null);
        Ghostsystem.getCfg().save();

    }
}
