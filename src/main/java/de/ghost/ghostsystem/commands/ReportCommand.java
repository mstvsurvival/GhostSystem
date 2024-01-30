package de.ghost.ghostsystem.commands;

import de.ghost.ghostsystem.Ghostsystem;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReportCommand implements CommandExecutor, TabCompleter {

    File file = new File("plugins/ghostsystem", "reports.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);


    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                for (Player onlinePlayer : player.getWorld().getPlayers()) {
                    completions.add(onlinePlayer.getName());
                }
            }
        } else if (args.length == 2) {
            completions.add("Hacking");
            completions.add("Spamming");
            completions.add("Scamming");
        }

        return completions;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            p.sendMessage(Ghostsystem.prefix + " §cDu musst ein Spieler sein");
        } else {
            if (args.length > 1) {
                Player toReport = Bukkit.getPlayer(args[0]);
                if (toReport.hasPermission("ghostsys.report.ignore")) {
                    p.sendMessage(Ghostsystem.prefix + " §cDu darfst kein Teammitglied Reporten.");
                    return false;
                }
                        if (toReport != null) {
                            if (args[1].equalsIgnoreCase("Hacking")) {
                                p.sendMessage(Ghostsystem.prefix + " §aDu hast den Spieler §c" + toReport.getName() + " §aErfolgreich §cReportet.");
                                for (Player all : Bukkit.getOnlinePlayers()) {
                                    if (all.hasPermission("ghostsys.report.notify")) {
                                        all.sendMessage(Ghostsystem.prefix + "§7[]=========§cGhostReport§7=========[]");
                                        all.sendMessage(Ghostsystem.prefix + "Der Spieler §c" + toReport.getName() + " §awurde Reportet.");
                                        all.sendMessage(Ghostsystem.prefix + "§avon: §c" + p.getName());
                                        all.sendMessage(Ghostsystem.prefix + "§aGrund: §cHacking");
                                        all.sendMessage(Ghostsystem.prefix + "§7[]=========§cGhostReport§7=========[]");
                                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                                    }
                                }
                            }
                            if (args[1].equalsIgnoreCase("Spamming")) {
                                p.sendMessage(Ghostsystem.prefix + " §aDu hast den Spieler §c" + toReport.getName() + " §aErfolgreich §cReportet.");
                                for (Player all : Bukkit.getOnlinePlayers()) {
                                    if (all.hasPermission("ghostsys.report.notify")) {
                                        all.sendMessage(Ghostsystem.prefix + "§7[]=========§cGhostReport§7=========[]");
                                        all.sendMessage(Ghostsystem.prefix + "Der Spieler §c" + toReport.getName() + " §awurde Reportet.");
                                        all.sendMessage(Ghostsystem.prefix + "§avon: §c" + p.getName());
                                        all.sendMessage(Ghostsystem.prefix + "§aGrund: §cSpamming");
                                        all.sendMessage(Ghostsystem.prefix + "§7[]=========§cGhostReport§7=========[]");
                                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                                    }
                                }
                            }
                            if (args[1].equalsIgnoreCase("Scamming")) {
                                p.sendMessage(Ghostsystem.prefix + " §aDu hast den Spieler §c" + toReport.getName() + " §aErfolgreich §cReportet.");
                                for (Player all : Bukkit.getOnlinePlayers()) {
                                    if (all.hasPermission("ghostsys.report.notify")) {
                                        all.sendMessage(Ghostsystem.prefix + "§7[]=========§cGhostReport§7=========[]");
                                        all.sendMessage(Ghostsystem.prefix + "Der Spieler §c" + toReport.getName() + " §awurde Reportet.");
                                        all.sendMessage(Ghostsystem.prefix + "§avon: §c" + p.getName());
                                        all.sendMessage(Ghostsystem.prefix + "§aGrund: §cScamming");
                                        all.sendMessage(Ghostsystem.prefix + "§7[]=========§cGhostReport§7=========[]");
                                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);
                                    }
                                }
                            }
                            try {
                                cfg.save(file);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            p.sendMessage(Ghostsystem.prefix + "§cUsage: /report <name> <grund>");
                        }
                    } else {
                        p.sendMessage(Ghostsystem.prefix + "§cUsage: /report <name> <grund>");
                    }
                }

                return false;
            }
        }



