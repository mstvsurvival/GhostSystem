package de.ghost.ghostsystem.Listerners;

import de.ghost.ghostsystem.Ghostsystem;
import de.ghost.ghostsystem.util.ScoreboardUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Listener implements org.bukkit.event.Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.getPlayer().getInventory().clear();

        e.getPlayer().setScoreboard(ScoreboardUtils.getBaseScoreboard(e.getPlayer()));

    }
    @EventHandler
    public void onDamage(EntityDamageEvent e){


        if (!(e.getEntity() instanceof Player)){
            return;
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                Player p = (Player) e.getEntity();
                p.getScoreboard().getTeam("leben").setPrefix("§a" + Math.round(p.getHealth() * 100) /100);
            }
        }.runTaskLater(Ghostsystem.getInstance() , 1);
    }
    @EventHandler
    public void onDamage(EntityRegainHealthEvent e){


        if (!(e.getEntity() instanceof Player)){
            return;
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                Player p = (Player) e.getEntity();
                p.getScoreboard().getTeam("leben").setPrefix("§a" + Math.round(p.getHealth() * 100) /100);
            }
        }.runTaskLater(Ghostsystem.getInstance() , 1);
    }
}
