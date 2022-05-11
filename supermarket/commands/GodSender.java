package me.josekat.supermarket.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodSender implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("supermarket.god")) {
                if (p.isInvulnerable()) {
                    p.setInvulnerable(false);
                    p.sendMessage(ChatColor.RED + "God mode disabled");
                } else {
                    p.setInvulnerable(true);
                    p.sendMessage("God mode enabled");
                }
            }else{
                p.sendMessage("You dont have the required permission");
            }
        }


        return true;
    }
}
