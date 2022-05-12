package me.josekat.customconfig.commands;

import me.josekat.customconfig.files.CustomConfigFile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Message implements CommandExecutor {

    String customfile = CustomConfigFile.get().getString("Message");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player player){
            player.sendMessage(customfile);
        }

        return true;
    }
}
