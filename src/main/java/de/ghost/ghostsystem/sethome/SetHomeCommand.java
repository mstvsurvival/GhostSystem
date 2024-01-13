package de.ghost.ghostsystem.sethome;

import de.ghost.ghostsystem.Ghostsystem;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        Location location = ((Player) sender).getLocation();

        FileConfiguration configuration = Ghostsystem.getPlugin(Ghostsystem.class).getConfig();

        configuration.set(((Player) sender).getUniqueId().toString() , location);
        Ghostsystem.getPlugin(Ghostsystem.class).saveConfig();
        return false;
    }
}

