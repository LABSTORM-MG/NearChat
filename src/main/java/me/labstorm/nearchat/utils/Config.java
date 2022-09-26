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
              .header("EXPLANATION TEXT (res: https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html)");
        config.set("format", "<<name>> <message>");
        config.set("distance", 10);
        config.set("distance_with_item", 30);

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
        config.set("texturepack.url", "https://drive.google.com/uc?export=download&id=1RGg5ncfMjHaaWD3RC7v0zdhSzBv21obx");

        config.set("item.name", "Megaphone");
        config.set("item.description", "Enables you to talk to players within 30 blocks.");
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