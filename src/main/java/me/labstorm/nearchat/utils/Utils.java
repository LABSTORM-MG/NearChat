package me.labstorm.nearchat.utils;

import me.labstorm.nearchat.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Objects;

import static me.labstorm.nearchat.Main.getInstance;

public class Utils {

    public static final NamespacedKey MEGAPHONE_RECIPE = new NamespacedKey(getInstance(), "megaphone_recipe");
    public static final NamespacedKey MEGAPHONE = new NamespacedKey(getInstance(), "megaphone");

    public static String getFormat() {
        String format = Main.getConfiguration().getString("format");
        if (format == null) {
            Bukkit.getConsoleSender()
                  .sendMessage(ChatColor.RED + "Error in config file! Delete it to restore the default settings.");
            return "<%1$s> %2$s";
        }
        format = format.replace("<name>", "%1$s");
        format = format.replace("<message>", "%2$s");
        return format;
    }

    public static void createMegaphoneRecipe() {
        ItemStack nautilus_shell = new ItemStack(Material.NAUTILUS_SHELL);
        ItemMeta itemMeta = nautilus_shell.getItemMeta();
        assert itemMeta != null;
        itemMeta.getPersistentDataContainer().set(MEGAPHONE, PersistentDataType.BYTE, (byte) 1);
        itemMeta.setCustomModelData(7290001);
        itemMeta.setDisplayName("§r" + Main.getConfiguration().getString("item.name"));
        itemMeta.setLore(Collections.singletonList(Main.getConfiguration().getString("item.description")));
        nautilus_shell.setItemMeta(itemMeta);

        YamlConfiguration config = Main.getConfiguration();
        ShapedRecipe megaphone = new ShapedRecipe(MEGAPHONE_RECIPE, nautilus_shell);
        megaphone.shape("123", "456", "789");
        megaphone.setIngredient('1', Objects.requireNonNull(config.getItemStack("ingredients.top_left")).getType());
        megaphone.setIngredient('2', Objects.requireNonNull(config.getItemStack("ingredients.top_center")).getType());
        megaphone.setIngredient('3', Objects.requireNonNull(config.getItemStack("ingredients.top_right")).getType());
        megaphone.setIngredient('4', Objects.requireNonNull(config.getItemStack("ingredients.middle_left")).getType());
        megaphone.setIngredient('5', Objects.requireNonNull(config.getItemStack("ingredients.middle_center")).getType());
        megaphone.setIngredient('6', Objects.requireNonNull(config.getItemStack("ingredients.middle_right")).getType());
        megaphone.setIngredient('7', Objects.requireNonNull(config.getItemStack("ingredients.bottom_left")).getType());
        megaphone.setIngredient('8', Objects.requireNonNull(config.getItemStack("ingredients.bottom_center")).getType());
        megaphone.setIngredient('9', Objects.requireNonNull(config.getItemStack("ingredients.bottom_right")).getType());
        Bukkit.getServer().addRecipe(megaphone);
    }

    public static byte[] createSha1(File file) throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        InputStream fis = Files.newInputStream(file.toPath());
        int n = 0;
        byte[] buffer = new byte[8192];
        while (n != -1) {
            n = fis.read(buffer);
            if (n > 0) {
                digest.update(buffer, 0, n);
            }
        }
        return digest.digest();
    }

}
