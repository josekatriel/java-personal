package me.josekat.quartermaster.listeners;

import me.josekat.quartermaster.utils.LockUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class OpenChestListener implements Listener {

    @EventHandler
    public void openChestListener(PlayerInteractEvent e){
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            Block b = e.getClickedBlock();
            if (b.getType().equals(Material.CHEST)){

                // Check to see if anyone has locked this chest
                if (LockUtils.isCurrentlyLocked(b)){
                    if(LockUtils.getWhoLocked(b) == e.getPlayer()){
                        e.getPlayer().sendMessage("You own this chest");
                    } else if(!(LockUtils.getWhoLocked(b) == e.getPlayer())){
                        e.setCancelled(true);
                        e.getPlayer().sendMessage(ChatColor.RED + "This chest is locked by " + LockUtils.getWhoLocked(b).getName());
                    }
                }

            }
        }
    }
}
