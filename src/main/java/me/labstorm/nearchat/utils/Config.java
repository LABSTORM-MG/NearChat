package me.labstorm.nearchat.utils;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

import static org.bukkit.configuration.file.YamlConfiguration.loadConfiguration;

public class Config {

    private final File file;
    private final YamlConfiguration config;

    public Config() {
        File dir = new File("./plugins/NearChat/");

        if (!dir.exists()) {
            dir.mkdirs();
        }

        this.file = new File(dir, "config.yml");
        boolean newConfigWasCreated = false;
        if (!file.exists()) {
            try {
                file.createNewFile();
                newConfigWasCreated = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.config = loadConfiguration(file);
        if (newConfigWasCreated) {
            generateConfig();
        }
        save();
    }

    private void generateConfig() {
        config.options()
              .header("format --> style of the chat message\n" +
                              "       --> use <name> for name of sender and <message> for the message\n" +
                              "       --> important surround with ' even if it isn't is like that by default\n" +
                              "distance --> distance in blocks a Player can write to others\n" +
                              "distance_with_item --> distance in blocks a Player can write to others when holding the item that extends their speaking range\n" +
                              "item.name --> name of the item that extends their speaking range\n" +
                              "item.description --> the description of the item that extends their speaking range\n" +
                              "ingredients --> ingredients for crafting recipe of the item that extends the speaking range\n" +
                              "            --> just change the part after \"type:\" according to this list https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html\n" +
                              "texturepack.enable --> enables or disables the custom resource pack\n" +
                              "texturepack.url --> the url where the resource pack is going to be downloaded from\n" +
                              "                --> [brief explanation of how to create custom texturepack]\n" +
                              "                --> needs to be an instant download link (the download starts automatically when you open the link without any other steps)\n" +
                              "                --> important surround with ' even if it isn't is like that by default\n" +
                              "texturepack.filename --> name of the file after download\n");

        config.set("format", "<<name>> <message>");
        config.set("distance", 10);
        config.set("distance_with_item", 30);

        config.set("item.name", "Megaphone");
        config.set("item.description", "Enables you to talk to players within 30 blocks.");

        config.set("ingredients.top_left", new ItemStack(Material.AIR));
        config.set("ingredients.top_center", new ItemStack(Material.IRON_INGOT));
        config.set("ingredients.top_right", new ItemStack(Material.AIR));
        config.set("ingredients.middle_left", new ItemStack(Material.IRON_INGOT));
        config.set("ingredients.middle_center", new ItemStack(Material.NAUTILUS_SHELL));
        config.set("ingredients.middle_right", new ItemStack(Material.IRON_INGOT));
        config.set("ingredients.bottom_left", new ItemStack(Material.AIR));
        config.set("ingredients.bottom_center", new ItemStack(Material.REDSTONE));
        config.set("ingredients.bottom_right", new ItemStack(Material.AIR));

        config.set("texturepack.enable", true);
        config.set("texturepack.url",
                   "https://drive.google.com/uc?export=download&id=1mUa_4H2dq3c7ehVfwqZ7neAkD5k6kyJl");
        config.set("texturepack.filename", "MegaphoneTexturePack.zip");
    }

    public YamlConfiguration getConfig() {
        return config;
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}