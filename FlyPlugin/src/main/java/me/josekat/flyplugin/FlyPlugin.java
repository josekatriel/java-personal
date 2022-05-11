package me.josekat.flyplugin;

import me.josekat.flyplugin.commands.FlyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlyPlugin extends JavaPlugin{

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("fly").setExecutor(new FlyCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
