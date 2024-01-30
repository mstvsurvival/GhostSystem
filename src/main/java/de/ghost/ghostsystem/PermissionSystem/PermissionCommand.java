package de.ghost.ghostsystem.PermissionSystem;

import de.ghost.ghostsystem.Ghostsystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

public class PermissionCommand implements CommandExecutor {

    private Ghostsystem plugin;

    public PermissionCommand(Ghostsystem plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender  sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player) {


            // /permission <add/remove> <Spieler> <Permission>

            if (args.length == 1) {
                String perm = args[0];
                if (p.hasPermission(perm)) {
                    p.sendMessage(Ghostsystem.prefix + " §aDu hast die Permission" + perm);
                } else {
                    p.sendMessage(Ghostsystem.prefix + " §cDu hast keine Permissions");
                }
            }

            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("remove")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    String permission = args[2];
                    if (target != null) {

                        boolean done = setPermission(args[0], target, permission);

                        if (done) {
                            p.sendMessage(Ghostsystem.prefix + "§aAktion Ausgeführt");
                        } else {
                            p.sendMessage(Ghostsystem.prefix + "§cEs gab einen Fehler");
                        }

                    } else {
                        p.sendMessage(Ghostsystem.prefix + " §cUsage: /permission <add/remove> <player> <permission>");
                    }
                } else {
                    p.sendMessage(Ghostsystem.prefix + " §cUsage: /permission <add/remove> <player> <permission>");
                }
            }
        } else {
            p.sendMessage(Ghostsystem.prefix + " §cUsage: /permission <add/remove> <player> <permission>");
        }
        return true;
    }

    public boolean setPermission(String type, Player target, String permissionName) {
        if (type.equalsIgnoreCase("add")) {

            PermissionAttachment attachment = target.addAttachment(plugin);
            attachment.setPermission(permissionName, true);

            return true;
        }
        if (type.equalsIgnoreCase("remove")) {

            PermissionAttachment attachment = target.addAttachment(plugin);
            attachment.unsetPermission(permissionName);

            return true;
        }
        return false;
    }
}
