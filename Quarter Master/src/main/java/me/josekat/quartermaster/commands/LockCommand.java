package me.josekat.quartermaster.commands;

import me.josekat.quartermaster.QuarterMaster;
import me.josekat.quartermaster.utils.GUIManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LockCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){
            Block target;
            if (!(p.getTargetBlockExact(5) == null)){
                target = p.getTargetBlockExact(5);
                if (target.getType().equals(Material.CHEST)){

                    // ask user if they want lock chest
                    GUIManager.openAskGUI(p);
                    QuarterMaster.locks_being_created.put(p,target);
                }
            }
        }





        return true;
    }
}
