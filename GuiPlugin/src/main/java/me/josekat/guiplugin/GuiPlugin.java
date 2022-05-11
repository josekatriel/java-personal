package me.josekat.guiplugin;

import me.josekat.guiplugin.commands.GuiCommand;
import me.josekat.guiplugin.events.ClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class GuiPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("gui").setExecutor(new GuiCommand());
        getServer().getPluginManager().registerEvents(new ClickEvent(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
