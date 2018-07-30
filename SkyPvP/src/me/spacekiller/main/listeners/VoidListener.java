package me.spacekiller.main.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;

import me.spacekiller.main.SkyPvP;

public class VoidListener implements Listener {

	SkyPvP plugin;

	public VoidListener(SkyPvP plugin) {
		this.plugin = plugin;
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
	public void onPlayerFall(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if ((player.getLocation().getY() <= 0.0D)
				&& (player.getWorld().getName().equalsIgnoreCase(plugin.getConfig().getString("WorldName")))) {
			player.setHealth(20.0D);
			player.setFallDistance(0.0F);
			World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("WorldName"));
			double x = plugin.getConfig().getDouble("spawn.x");
			double y = plugin.getConfig().getDouble("spawn.y");
			double z = plugin.getConfig().getDouble("spawn.z");
			double fy = plugin.getConfig().getDouble("spawn.yaw");
			player.teleport(new Location(w, x, y, z,(float) fy, 0));
			player.teleport(player.getWorld().getSpawnLocation());
			player.setExp(0.0F);
			player.setLevel(0);
			player.setFoodLevel(20);
			player.getInventory().clear();
			player.getInventory().setArmorContents(null);
			player.getActivePotionEffects().clear();
			removeArmor(player);
			removeEffect(player);
		}
	}
	
	public void removeArmor(Player p) {
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
	}

	public void removeEffect(Player p) {
		for (PotionEffect effect : p.getActivePotionEffects())
			p.removePotionEffect(effect.getType());
	}

}
