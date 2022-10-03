package me.labstorm.nearchat.listeners;

import me.labstorm.nearchat.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class CraftItemEventListener implements Listener {
    @EventHandler
    public void onCraftItemEvent(CraftItemEvent e) {
        for (ItemStack itemStack : e.getInventory().getMatrix()) {
            try {
                if (Objects.requireNonNull(itemStack.getItemMeta())
                           .getPersistentDataContainer().getKeys().contains(Utils.MEGAPHONE)) {
                    e.setCancelled(true);
                }
            } catch (NullPointerException ignore) {
            }
        }
    }

}
