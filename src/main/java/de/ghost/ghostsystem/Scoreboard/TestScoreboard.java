package de.ghost.ghostsystem.Scoreboard;

import de.ghost.ghostsystem.Ghostsystem;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.*;

public class TestScoreboard extends ScoreboardBuilder{

    public TestScoreboard(Player player) {
        super(player, ChatColor.RED.toString() + ChatColor.BOLD + "  GhostBuild  ");
    }

    @Override
    public void createScoreboard() {
        setScore(ChatColor.GREEN + "Online", 7);
        setScore(ChatColor.DARK_BLUE.toString(), 6);
        setScore(ChatColor.GREEN + "twitch.tv/minecrafttvsurvival", 5);
        setScore(ChatColor.AQUA.toString(), 4);
        setScore(ChatColor.GREEN + "discord.ghostbuild.eu", 3);
        setScore(ChatColor.RED.toString(), 2);
        setScore(ChatColor.GREEN + "web.ghostbuild.de", 1);
        setScore(ChatColor.GRAY.toString(), 0);
    }

    @Override
    public void update() {

    }

}
