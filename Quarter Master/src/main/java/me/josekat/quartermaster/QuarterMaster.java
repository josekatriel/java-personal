package me.josekat.quartermaster;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import me.josekat.quartermaster.commands.LockCommand;
import me.josekat.quartermaster.listeners.MenuListeners;
import me.josekat.quartermaster.listeners.OpenChestListener;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class QuarterMaster extends JavaPlugin {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private static MongoCollection<Document> col;
    public static HashMap<Player, Block> locks_being_created = new HashMap<>();

    @Override
    public void onEnable() {
        // Connect to mongodb server
        mongoClient = MongoClients.create("mongodb+srv://josekat:josekat123@katgames.lm95w.mongodb.net/?retryWrites=true&w=majority");
        database = mongoClient.getDatabase("quartermaster");
        col = database.getCollection("locks");

        // Commands and Listener
        getCommand("lock").setExecutor(new LockCommand());
        Bukkit.getPluginManager().registerEvents(new MenuListeners(),this);
        Bukkit.getPluginManager().registerEvents(new OpenChestListener(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MongoCollection<Document> getDatabaseCollection() {
        return col;
    }

    public static void setDatabaseCollection(MongoCollection<Document> col) {
        QuarterMaster.col = col;
    }
}
