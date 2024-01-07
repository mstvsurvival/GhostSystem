package de.ghost.ghostsystem.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardUtils {

    public static Scoreboard getBaseScoreboard(Player player){
        Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = s.registerNewObjective("main" , "main" , "§aGhostBuild.de");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore("§cweb.ghostbuild.de").setScore(0);
        objective.getScore("§a").setScore(1);
        objective.getScore("§aDein Leben:").setScore(3);
        objective.getScore("§a").setScore(4);
        objective.getScore(player.isOp() ? "§cAdmin" : "§7Spieler").setScore(5);
        objective.getScore("§cDein Rang:").setScore(6);
        objective.getScore("§b").setScore(7);

        Team t = s.registerNewTeam("leben");
        t.addEntry(ChatColor.AQUA + "" + ChatColor.RED);
        objective.getScore(ChatColor.AQUA + "" + ChatColor.RED).setScore(2);

        t.setPrefix("§a" + Math.round((player.getHealth() * 100) /100));

        return s;
    }
}
