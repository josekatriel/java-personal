package me.josekat.inventory.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player Player = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Custom Inventory")){
            if(e.getCurrentItem() == null){
                return;
            }
            if(e.getCurrentItem().getType() == Material.POPPY){
                Player.sendMessage("You clicked Poppy");
            }
        }

        //make it so that players can't move items
        e.setCancelled(true);
    }
}
