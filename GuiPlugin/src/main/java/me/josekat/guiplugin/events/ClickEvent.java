package me.josekat.guiplugin.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickEvent implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase("Custom GUI")){

            switch (e.getCurrentItem().getType()){
                case TNT:
                    player.closeInventory();
                    player.setHealth(0.0);
                    player.sendMessage("You just commit suicide!");
                    break;
                case BREAD:
                    player.closeInventory();
                    player.setFoodLevel(20);
                    player.sendMessage("You just eat bread from Heaven");
                    break;
                case IRON_SWORD:
                    player.closeInventory();
                    player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
                    player.sendMessage("This is high quality sword!");
                    break;
            }

            e.setCancelled(true);
        }


    }
}
