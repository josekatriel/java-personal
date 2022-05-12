package me.josekat.customconfig.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfigFile {

    private static File file;
    private static FileConfiguration customFile;

    // Find or Generate custom file yaml
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("CustomConfig").getDataFolder(),"superconfig.yml");

        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){

            }

        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }
    // get custom file
    public static FileConfiguration get() {
        return customFile;
    }
    // save custom file
    public static void save() {
        try {
            customFile.save(file);
        } catch (IOException e){
            System.out.println("Couldn't save file!");
        }
    }
    // reload file
    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
        System.out.println("Reload config file!");
    }
}
