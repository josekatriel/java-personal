package me.josekat.customconfig.commands;

import me.josekat.customconfig.CustomConfig;
import me.josekat.customconfig.files.CustomConfigFile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        player.sendMessage("Reload config done!");
        CustomConfigFile.reload();

        return true;
    }
}
