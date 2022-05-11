package me.josekat.supermarket;

import me.josekat.supermarket.commands.*;
import me.josekat.supermarket.listeners.XPBottleBreakListener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class SuperMarket extends JavaPlugin{

    private static SuperMarket plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(),this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("god").setExecutor(new GodSender());
        getCommand("setconf").setExecutor(new CommandConf());
        getCommand("repeat").setExecutor(new CommandArg());
        getCommand("fart").setExecutor(new CommandTarget());
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        plugin = this;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("printMessageFromConfig")){
            Player p = (Player) sender;
            String food = getConfig().getString("Food");
            int number = getConfig().getInt("Number");
            boolean Boolean = getConfig().getBoolean("Boolean");
            String thirdItem = getConfig().getStringList("FoodList").get(0);
            p.sendMessage(food);
        }
        return true;
    }


    public static SuperMarket getPlugin() {

        return plugin;
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic


    }
}
