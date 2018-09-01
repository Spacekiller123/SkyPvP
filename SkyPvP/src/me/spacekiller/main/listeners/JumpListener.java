package me.spacekiller.main.listeners;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import me.spacekiller.main.SkyPvP;

public class JumpListener implements Listener {
	
	SkyPvP plugin;
	
	public JumpListener(SkyPvP plugin) {
		this.plugin = plugin;
	}
	
	
	@EventHandler
	public void onJump(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(p.getGameMode() != GameMode.CREATIVE){
			if(p.getLocation().add(0,-1,0).getBlock().getType() != Material.AIR) {
				p.setAllowFlight(true);
			}
		}
	}

	@EventHandler
	public void OnDamage(EntityDamageEvent e){
		if(e.getCause().equals(DamageCause.FALL)){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onFly(PlayerToggleFlightEvent e){
		Player p = e.getPlayer();
		if(p.getGameMode() != GameMode.CREATIVE){
			e.setCancelled(true);
			p.setAllowFlight(false);
			p.setFlying(false);
			p.setVelocity(p.getLocation().getDirection().multiply(0.5D).setY(0.5D));
			p.setFallDistance(0.0F);
			p.playSound(p.getLocation(), Sound.ENTITY_ENDERDRAGON_FLAP, 0.1F, -10F);
		}
	}
	
}
