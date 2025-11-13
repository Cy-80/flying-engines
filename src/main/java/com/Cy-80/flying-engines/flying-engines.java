package com.Cy-80.flyingengines;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class flyingengines extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("flying-engines enabled: minecarts can be accelerated and a new item, 'flying minecarts' will be created which will be able to fly.");
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent e) {
        ItemStack item = e.getItem();
        // 1.12 uses legacy enum names: WOOD_PICKAXE
        if (item != null && item.getType() == Material.WOOD_PICKAXE) {
            int incoming = e.getDamage();                      // durability hit Spigot calculated
            int reduced  = Math.max(1, (int)Math.ceil(incoming / 2.0)); // halve it
            e.setDamage(reduced);                              // apply the reduction
        }
    }
}

