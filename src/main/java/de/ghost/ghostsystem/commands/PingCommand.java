package de.ghost.ghostsystem.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Überprüfen Sie, ob der Befehl von einem Spieler ausgeführt wurde
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Dieser Befehl kann nur von Spielern verwendet werden.");
            return true;
        }

        Player player = (Player) sender;

        // Überprüfen Sie, ob der Befehl Argumente hat
        if (args.length == 0) {
            // Wenn keine Argumente vorhanden sind, senden Sie eine Ping-Nachricht an den Spieler
            player.sendMessage(ChatColor.GREEN + "Pong! Du wurdest gepingt.");
        } else {
            // Wenn Argumente vorhanden sind, versuchen Sie, den angegebenen Spieler zu pingen
            String targetPlayerName = args[0];
            Player targetPlayer = player.getServer().getPlayer(targetPlayerName);

            if (targetPlayer != null) {
                // Wenn der Spieler gefunden wurde, senden Sie ihm eine Ping-Nachricht
                targetPlayer.sendMessage(ChatColor.GREEN + "Du wurdest von " + player.getName() + " gepingt.");
                player.sendMessage(ChatColor.GREEN + "Du hast " + targetPlayer.getName() + " gepingt. Der Spieler hat " + player.getPing() + "§cms");
            } else {
                // Wenn der Spieler nicht gefunden wurde, informieren Sie den Absender
                player.sendMessage(ChatColor.RED + "Spieler '" + targetPlayerName + "' wurde nicht gefunden.");
            }
        }

        return true;
    }
}
