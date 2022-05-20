package me.josekat.quartermaster.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIManager {

    private static Inventory askGUI;

    public static void openAskGUI(Player p){
        askGUI = Bukkit.createInventory(p,9, ChatColor.DARK_AQUA + "Locked Detected. Lock Chest?");
        // Yes
        ItemStack yes = new ItemStack(Material.LIME_STAINED_GLASS_PANE,1);
        ItemMeta yesMeta = yes.getItemMeta();
        yesMeta.setDisplayName(ChatColor.GREEN + "Yes");
        yes.setItemMeta(yesMeta);
        // No
        ItemStack no = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
        ItemMeta noMeta = no.getItemMeta();
        noMeta.setDisplayName(ChatColor.RED + "No");
        no.setItemMeta(noMeta);
        // Glass Pane
        ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName(" ");
        glass.setItemMeta(glassMeta);

        askGUI.setItem(3,yes);
        askGUI.setItem(5,no);
        for (int i = 0;i < 9;i++){
            if(askGUI.getItem(i) == null){
                askGUI.setItem(i, glass);
            }
        }

        p.openInventory(askGUI);
    }
}
