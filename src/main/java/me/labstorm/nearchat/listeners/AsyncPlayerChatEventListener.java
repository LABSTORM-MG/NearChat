package me.labstorm.nearchat.listeners;

import me.labstorm.nearchat.Main;
import me.labstorm.nearchat.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Objects;

public class AsyncPlayerChatEventListener implements Listener {

    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent e) {
        Player sender = e.getPlayer();
        YamlConfiguration config = Main.getConfiguration();
        int distance = -1;
        try {
            if (Objects.requireNonNull(sender.getInventory().getItemInMainHand().getItemMeta())
                       .getPersistentDataContainer()
                       .getKeys()
                       .contains(Utils.MEGAPHONE)) {
                distance = config.getInt("distance_with_item");
            }
        } catch (NullPointerException ignore) {
        }
        try {
            if (Objects.requireNonNull(sender.getInventory().getItemInOffHand().getItemMeta())
                       .getPersistentDataContainer()
                       .getKeys()
                       .contains(Utils.MEGAPHONE)) {
                distance = config.getInt("distance_with_item");
            }
        } catch (NullPointerException ignore) {
        }
        if (distance == -1) {
            distance = config.getInt("distance");
        }
        String msg = String.format(Utils.getFormat(), sender.getDisplayName(), e.getMessage());
        Bukkit.getConsoleSender().sendMessage(msg);
        for (Player receiver : Bukkit.getOnlinePlayers()) {
            if (receiver.getWorld().equals(sender.getWorld()) && receiver.getLocation()
                                                                         .distance(sender.getLocation()) <= distance) {
                receiver.sendMessage(msg);
            }
        }
        e.setCancelled(true);
    }
}
