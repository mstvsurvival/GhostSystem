package de.ghost.ghostsystem.sethome;

import de.ghost.ghostsystem.Ghostsystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        FileConfiguration configuration = Ghostsystem.getPlugin(Ghostsystem.class).getConfig();

        if (configuration.contains(((Player) sender).getUniqueId().toString())){
            ((Player) sender).teleport(configuration.getLocation(((Player) sender).getUniqueId().toString()));
        }else {
            sender.sendMessage("$cDu musst als erstes einen Home setzen!");
        }

        return false;
    }
}
