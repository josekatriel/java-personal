package me.josekat.supermarket.commands;

import me.josekat.supermarket.SuperMarket;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandConf implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String food = SuperMarket.getPlugin().getConfig().getString("Food");
        Player p = (Player) sender;
        p.sendMessage(food);
        return false;
    }
}
