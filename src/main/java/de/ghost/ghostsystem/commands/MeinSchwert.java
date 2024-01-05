package de.ghost.ghostsystem.commands;

import de.ghost.ghostsystem.Ghostsystem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MeinSchwert implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player player = (Player)commandSender;
            commandSender.sendMessage(Ghostsystem.getPrefix()+ "Du hast dir das TestItem gegeben!");
            int amount;
            ItemStack stack = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta meta = stack.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Mein " + ChatColor.RED + "Item");
            ArrayList<String> lore = new ArrayList<>();
            lore.add(" ");
            lore.add(ChatColor.GRAY + "Das ist §amein Item!");
            lore.add(ChatColor.GRAY + ">> Wie macht man sowas?!");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.KNOCKBACK , 3 , true);
            stack.setItemMeta(meta);
            player.getInventory().addItem(stack);
        }else {
            commandSender.sendMessage(Ghostsystem.getPrefix() + "§cDu musst ein Spieler sein!");
        }

        return false;
    }
}
