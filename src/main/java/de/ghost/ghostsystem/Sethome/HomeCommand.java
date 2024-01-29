package de.ghost.ghostsystem.Sethome;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.List;

public class HomeCommand implements CommandExecutor {

    @SuppressWarnings("unused")
    File file = new File("plugins/ghostsystem" , "homes.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if (args.length == 1) {

            String world = cfg.getString(p.getName() + "." + args[0] + ".world");
            double x = cfg.getDouble(p.getName() + "." + args[0] + "x");
            double y = cfg.getDouble(p.getName() + "." + args[0] + ".y");
            double z = cfg.getDouble(p.getName() + "." + args[0] + ".z");
            double yaw = cfg.getDouble(p.getName() + "." + args[0] + ".yaw");
            double pitsch = cfg.getDouble(p.getName() + "." + args[0] + ".pitsch");

            Location location = new Location(Bukkit.getWorld(world), x, y, z);
            location.setPitch((float) pitsch);
            location.setYaw((float) yaw);
            p.teleport(location);
            p.sendMessage("§a[§cGhostSystem§a] §aDu hast dich zu deinem Home§c" + args[0] + " §ateleportiert");
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP , 5, 5);

        } else {
            p.sendMessage("§a[§cGhostSystem§a] §cUsage: /home <name>");
        }

        return false;
    }
}
