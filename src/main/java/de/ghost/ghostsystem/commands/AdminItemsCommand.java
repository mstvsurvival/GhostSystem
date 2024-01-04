package de.ghost.ghostsystem.commands;

import de.ghost.ghostsystem.Ghostsystem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class AdminItemsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player)sender;
            Inventory inventory = Bukkit.createInventory(null,  9);
            ItemStack itemStack = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setUnbreakable(true);
            meta.setDisplayName("§cOP-Schwert");
            meta.addEnchant(Enchantment.DAMAGE_ALL, 100 , true);
            meta.addEnchant(Enchantment.FIRE_ASPECT, 100 , true);
            meta.addEnchant(Enchantment.MENDING, 100 , true);
            meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 100 , true);
            itemStack.setItemMeta(meta);
            ItemStack itemStack2 = new ItemStack(Material.BOW);
            ItemMeta meta2 = itemStack2.getItemMeta();
            meta2.setUnbreakable(true);
            meta2.setDisplayName("§cOP-Bogen");
            meta2.addEnchant(Enchantment.ARROW_FIRE, 100 , true);
            meta2.addEnchant(Enchantment.ARROW_KNOCKBACK, 100 , true);
            meta2.addEnchant(Enchantment.MENDING, 100 , true);
            meta2.addEnchant(Enchantment.ARROW_INFINITE, 100 , true);
            itemStack2.setItemMeta(meta2);
            inventory.setItem(0 , itemStack);
            inventory.setItem(1 , itemStack2);
            player.openInventory(inventory);
        }else {
            sender.sendMessage(Ghostsystem.getPrefix() + "Du musst ein Spieler sein!");
        }
        return false;
    }
}
