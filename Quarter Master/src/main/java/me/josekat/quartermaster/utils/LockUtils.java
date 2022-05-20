package me.josekat.quartermaster.utils;

import me.josekat.quartermaster.QuarterMaster;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Date;
import java.util.UUID;

public class LockUtils {

    public static void createNewLock(Player p, Block block){

        // Document representing the new lock
        Document lock = new Document("uuid", p.getUniqueId().toString())
                .append("type","chest")
                .append("location", new Document("x", block.getX()).append("y", block.getY()).append("z", block.getZ()))
                .append("creation-date", new Date());
        QuarterMaster.getDatabaseCollection().insertOne(lock);
        System.out.println("New Lock Created!");
        QuarterMaster.locks_being_created.remove(p);

        p.closeInventory();
    }

    public static boolean isCurrentlyLocked(Block block){
        int x = block.getX();
        int y = block.getY();
        int z = block.getZ();
        Document filter =  new Document("location", new Document("x",x).append("y",y).append("z",z));

        if(QuarterMaster.getDatabaseCollection().countDocuments(filter) == 1){
            return true;
        }
        return false;
    }

    public static Player getWhoLocked(Block block){
        int x = block.getX();
        int y = block.getY();
        int z = block.getZ();
        Document filter =  new Document("location", new Document("x",x).append("y",y).append("z",z));

        String uuidString = QuarterMaster.getDatabaseCollection().find(filter).first().getString("uuid");
        UUID uuid = UUID.fromString(uuidString);

        return Bukkit.getPlayer(uuid);
    }

}
