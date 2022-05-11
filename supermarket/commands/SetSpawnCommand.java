package me.josekat.supermarket.commands;

import me.josekat.supermarket.SuperMarket;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final SuperMarket plugin;

    public SetSpawnCommand(SuperMarket plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){
            Location location = p.getLocation();

            // save each value loc xyz and world name
            plugin.getConfig().set("spawn", location);
            plugin.saveConfig();
            p.sendMessage("Spawn location set!");
        }
        return true;
    }
}
