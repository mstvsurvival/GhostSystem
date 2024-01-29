package de.ghost.ghostsystem.Sethome;

import de.ghost.ghostsystem.Ghostsystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SethomeCommand implements CommandExecutor {

    @SuppressWarnings("unused")
    private Ghostsystem plugin;
    File file = new File("plugins/ghostsystem" , "homes.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            p.sendMessage("§a[§cGhostSystem§a] §cDu musst ein Spieler sein");
        } else {
            if (args.length == 1) {

                if (cfg.isSet(p.getName() + "." + args[0] + ".world")) {


                    String world = p.getWorld().getName();
                    double x = p.getLocation().getX();
                    double y = p.getLocation().getY();
                    double z = p.getLocation().getZ();
                    double yaw = p.getLocation().getYaw();
                    double pitch = p.getLocation().getPitch();

                    cfg.set(p.getName() + "." + args[0] + ".world", world);
                    cfg.set(p.getName() + "." + args[0] + ".x", x);
                    cfg.set(p.getName() + "." + args[0] + ".y", y);
                    cfg.set(p.getName() + "." + args[0] + ".z", z);
                    cfg.set(p.getName() + "." + args[0] + ".yaw", yaw);
                    cfg.set(p.getName() + "." + args[0] + ".pitch", pitch);

                    try {
                        cfg.save(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    p.sendMessage("§a[§cGhostSystem§a] §aDas Home§c " + args[0] + " §awurde gesetzt");
                } else {
                    p.sendMessage("§a[§cGhostSystem§a] §a Das Home§c " + args[0] + " §aexistiert schon");
                }
            } else {
                p.sendMessage("§a[§cGhostSystem§a] §cUsage: /sethome <name>");
            }
        }
        return false;
    }
}
