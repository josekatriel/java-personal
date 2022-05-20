package me.josekat.quartermaster.listeners;

import me.josekat.quartermaster.QuarterMaster;
import me.josekat.quartermaster.utils.LockUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListeners implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_AQUA + "Locked Detected. Lock Chest?")){
            e.setCancelled(true);
            if (e.getCurrentItem().getType().equals(null)){
                return;
            }
            if (e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS_PANE)){
                p.sendMessage("Creating a new lock...");
                LockUtils.createNewLock(p, QuarterMaster.locks_being_created.get(p));

                // Create a new lock
            } else if (e.getCurrentItem().getType().equals(Material.BLACK_STAINED_GLASS_PANE)) {
                p.closeInventory();
            }

        }
    }

}
