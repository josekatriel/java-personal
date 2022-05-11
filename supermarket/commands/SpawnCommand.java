package me.josekat.supermarket.commands;

import me.josekat.supermarket.SuperMarket;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final SuperMarket plugin;

    public SpawnCommand(SuperMarket plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            Location location = plugin.getConfig().getLocation("spawn");
            if(location != null){
                p.teleport(location);
                p.sendMessage("You have teleported to spawn point.");
            } else {
                p.sendMessage("There is no spawn point set. Use /setspawn to set it.");
            }
        }

        return true;
    }
}
