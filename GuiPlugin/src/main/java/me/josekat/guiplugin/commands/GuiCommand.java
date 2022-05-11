package me.josekat.guiplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GuiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player player){
            Inventory gui = Bukkit.createInventory(player, 9,"Custom GUI");

            ItemStack suicide = new ItemStack(Material.TNT);
            ItemStack feed = new ItemStack(Material.BREAD);
            ItemStack sword = new ItemStack(Material.IRON_SWORD);

            ItemMeta suicideMeta = suicide.getItemMeta();
            suicideMeta.setDisplayName(ChatColor.RED + "Suicide");
            ArrayList<String> suicideLore = new ArrayList<>();
            suicideLore.add(ChatColor.GOLD + "Kill yourself");
            suicideMeta.setLore(suicideLore);
            suicide.setItemMeta(suicideMeta);

            ItemMeta feedMeta = feed.getItemMeta();
            feedMeta.setDisplayName(ChatColor.YELLOW + "Feed");
            ArrayList<String> feedLore = new ArrayList<>();
            feedLore.add(ChatColor.GOLD + "Nyam nyam..");
            feedMeta.setLore(feedLore);
            feed.setItemMeta(feedMeta);

            ItemMeta swordMeta = sword.getItemMeta();
            swordMeta.setDisplayName(ChatColor.BLUE + "Cool Iron Sword");
            ArrayList<String> swordLore = new ArrayList<>();
            swordLore.add(ChatColor.GOLD + "Free sword");
            swordMeta.setLore(swordLore);
            sword.setItemMeta(swordMeta);

            ItemStack[] menu_items = {suicide, feed, sword};
            gui.setContents(menu_items);
            player.openInventory(gui);
        }

        return true;
    }
}
