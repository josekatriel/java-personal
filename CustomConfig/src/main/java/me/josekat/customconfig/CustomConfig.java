package me.josekat.customconfig;

import me.josekat.customconfig.commands.Message;
import me.josekat.customconfig.commands.Reload;
import me.josekat.customconfig.files.CustomConfigFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomConfig extends JavaPlugin {

    @Override
    public void onEnable() {
        // Setup Default config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Custom Config file
        CustomConfigFile.setup();
        CustomConfigFile.get().addDefault("Message","This is the default message!");
        CustomConfigFile.get().options().copyDefaults(true);
        CustomConfigFile.save();

        getCommand("sms").setExecutor(new Message());
        getCommand("preload").setExecutor(new Reload());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
