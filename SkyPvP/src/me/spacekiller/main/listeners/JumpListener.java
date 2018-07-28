package me.spacekiller.main.listeners;

import java.util.ArrayList;

import org.bukkit.GameMode;
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
	
	ArrayList<Player> fly = new ArrayList<Player>();

	SkyPvP plugin;
	
	boolean jumped = false;
	
	public JumpListener(SkyPvP plugin) {
		this.plugin = plugin;
	}
	
	
	@EventHandler
	public void onJump(PlayerMoveEvent e) {
		if(e.getPlayer().getGameMode() != GameMode.CREATIVE && !e.getPlayer().isOnGround() && !jumped){
			e.getPlayer().setAllowFlight(true);
			fly.add(e.getPlayer());
		}else if(e.getPlayer().isOnGround()) {
			jumped = false;
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
		if(p.getGameMode() != GameMode.CREATIVE && fly.contains(p) && !jumped){
			e.setCancelled(true);
			p.setAllowFlight(false);
			p.setFlying(false);
			p.setVelocity(p.getLocation().getDirection().multiply(0.5D).setY(0.5D));
			p.setFallDistance(0.0F);
			p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERDRAGON_FLAP, (float) 1.0, -5.0F);
			fly.remove(p.getPlayer());
			jumped = true;
		}
	}
	
}