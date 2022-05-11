package me.josekat.flyplugin.commands;

import me.josekat.flyplugin.FlyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

    private FlyPlugin plugin;
    private final ArrayList<Player> flyPlayerList = new ArrayList<>();

    public FlyCommand(FlyPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player player){
            if(player.hasPermission("flyplugin.fly")){
                if(args.length == 0){
                    flyMethod(player);
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target == null){
                        player.sendMessage("Player is not online!");
                    } else {
                        flyMethod(target);
                    }
                }
            } else {
                player.sendMessage(ChatColor.RED + "You don't have perm to do that!");
            }
        }
        return true;
    }

    private void flyMethod(Player p){
        String prefix = ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("prefix"));
        String onMessage = ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("on-message"));
        String offMessage = ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("off-message"));
        if(flyPlayerList.contains(p)) {
            flyPlayerList.remove(p);
            p.setAllowFlight(false);
            p.sendMessage(prefix + " " + offMessage);
        } else {
            flyPlayerList.add(p);
            p.setAllowFlight(true);
            p.sendMessage(prefix + " " + onMessage);
        }
    }
}
