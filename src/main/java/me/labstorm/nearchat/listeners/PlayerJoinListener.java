package me.labstorm.nearchat.listeners;

import me.labstorm.nearchat.Main;
import me.labstorm.nearchat.utils.Utils;
import org.apache.commons.io.FileUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        YamlConfiguration config = Main.getConfiguration();
        if (!Main.getConfiguration().getBoolean("texturepack.enable")) {
            return;
        }

        try {
            final URL url = new URL(config.getString("texturepack.url"));
            final File file = new File("./plugins/NearChat/MegaphoneTexturePack.zip");
            FileUtils.copyURLToFile(url, file);
            e.getPlayer().setResourcePack(url.toString(), Utils.createSha1(file));
        } catch (NoSuchAlgorithmException | IOException ex) {
            ex.printStackTrace();
        }
    }

}
