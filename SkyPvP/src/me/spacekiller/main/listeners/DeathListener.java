package me.spacekiller.main.listeners;

import org.bukkit.Material;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.spacekiller.main.SkyPvP;

public class DeathListener implements Listener {

	SkyPvP plugin;
	
	public DeathListener(SkyPvP plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if(e.getEntity().getKiller() instanceof Player) {
			if(e.getEntity().getWorld().getName().equalsIgnoreCase(plugin.getConfig().getString("WorldName"))) {
				e.getDrops().clear();
				ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner(e.getEntity().getKiller().getName());
				meta.setDisplayName(e.getEntity().getName() + "'s Kopf");
				skull.setItemMeta(meta);
				e.getEntity().getKiller().getInventory().addItem(skull);
			}

		}
	}
	
	@EventHandler
	public void onItemDrop(ItemSpawnEvent e) {
		if(e.getEntity().getWorld().getName().equalsIgnoreCase(plugin.getConfig().getString("WorldName")) && e.getEntity().getItemStack().getType() == Material.ARMOR_STAND) {
				e.getEntity().remove();
		}
	}
}
