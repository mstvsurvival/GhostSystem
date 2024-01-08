package de.ghost.ghostsystem.tpa;

import org.bukkit.entity.Player;

public class TpRequest {
    public Player TpRequest;
    public boolean isReversed;

    public TpRequest (Player sender, boolean direction) {
        TpRequest = sender;
        isReversed = direction;
    }

    public TpRequest() {

    }
}
