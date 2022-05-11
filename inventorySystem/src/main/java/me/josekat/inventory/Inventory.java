package me.josekat.inventory;

import me.josekat.inventory.commands.MenuCommand;
import me.josekat.inventory.listeners.MenuListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Inventory extends JavaPlugin{

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new MenuListener(),this);
        getCommand("menu").setExecutor(new MenuCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
