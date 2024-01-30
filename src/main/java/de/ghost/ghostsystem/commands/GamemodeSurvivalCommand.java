package de.ghost.ghostsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeSurvivalCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ghostsys.gm1")) {
                if (args.length == 0) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                    p.sendMessage("§a[§cGhostSystem§a] Dein Gamemode wurde auf Survival gesetzt");
                } else {
                    if (args.length == 1) {
                        if (p.hasPermission("ghostsys.gm1.other")) {
                            Player target = Bukkit.getPlayer(args[0]);
                            target.setGameMode(GameMode.SURVIVAL);
                            target.sendMessage("§a[§cGhostSystem§a] Dein Gamemode wurde auf Survival gesetzt");
                            p.sendMessage("§a[§cGhostSystem§a] Du hast den Spieler in Survival gesetzt");
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                        }
                    } else {
                        p.sendMessage("§a[§cGhostSystem§a] Usage: /gm <0,1,3>  <player>");
                    }
                }
            } else {
                p.sendMessage("§a[§cGhostSystem§a] Usage: Dazu hast du keine Rechte");
            }
        }
        return false;
    }
}
