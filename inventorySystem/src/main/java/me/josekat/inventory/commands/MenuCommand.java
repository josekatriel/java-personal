package me.josekat.inventory.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        Inventory inventory = Bukkit.createInventory(p,9, ChatColor.RED + "Custom Inventory");

        // Create item
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD,1);
        // get the meta
        ItemMeta itemMeta = item.getItemMeta();
        // change the meta
        itemMeta.setDisplayName(ChatColor.GREEN + "Click Me");
        // set the meta to item
        item.setItemMeta(itemMeta);
        // adding item to inventory
        inventory.addItem(item);

        ItemStack flower = new ItemStack(Material.POPPY, 8);
        ItemMeta flowerMeta = flower.getItemMeta();
        flowerMeta.setDisplayName(ChatColor.AQUA + "Water Flower");

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "This is the coolest");
        lore.add(ChatColor.WHITE + "flower ever!");
        flowerMeta.setLore(lore);
        flowerMeta.addEnchant(Enchantment.DAMAGE_ALL, 10,true);

        flower.setItemMeta(flowerMeta);

        // setting item to spesific slot in inventory
        inventory.setItem(3,flower);

        p.openInventory(inventory);

        return true;
    }
}
