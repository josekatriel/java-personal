package me.josekat.supermarket.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTarget implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            if(args.length == 0){
                p.sendMessage("You fart so hard and dead");
                p.setHealth(0.0);
            } else {
                String playerName = args[0];
                Player target = Bukkit.getServer().getPlayerExact(playerName);
                if(target == null){
                    p.sendMessage("Can't find this player!");
                } else {
                    p.sendMessage("You successfully to make " + target.getDisplayName() + " fart!");
                    target.sendMessage("You forces to farted by " + p.getDisplayName() + "!");
                    target.setHealth(0.0);
                }
            }
        }

        return false;
    }
}
