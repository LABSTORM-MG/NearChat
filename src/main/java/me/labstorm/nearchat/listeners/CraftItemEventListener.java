package me.labstorm.nearchat.listeners;

import me.labstorm.nearchat.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftItemEventListener implements Listener {
    @EventHandler
    public void oncraftItemEvent(CraftItemEvent e) {
        for (ItemStack itemStack : e.getInventory().getMatrix()) {
            try {
                if (itemStack.getItemMeta().getPersistentDataContainer().getKeys().contains(Utils.MEGAPHONE)) {
                    e.setCancelled(true);
                }
            } catch (NullPointerException ignore) { }
        }
    }

}
