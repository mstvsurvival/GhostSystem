package de.ghost.ghostsystem.tpa;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.Location;

public class TpQueue {
    public static final TpQueue INSTANCE = new TpQueue();
    private TpQueue() {
        // Exists only to defeat instantiation.
    }
    public static final HashMap<Player, TpRequest> TELEPORT_REQUESTS = new HashMap<Player, TpRequest>();
    public final HashMap<Player, Location> PREVIOUS_LOCATIONS = new HashMap<Player, Location>();
}
