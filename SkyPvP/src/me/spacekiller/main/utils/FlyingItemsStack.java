package me.spacekiller.main.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class FlyingItemsStack {

	private ArmorStand armorstand;
	private Location location;
	private String text = null;
	private Boolean h = false;
	private ItemStack itemstack;
	private double height = -1.3;
	private long time = 0;

	public FlyingItemsStack() {

	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setItemStack(ItemStack itemstack) {
		this.itemstack = itemstack;
	}

	public void setHeight(double height) {

	}
	
	public void setTime(int t) {
		time = System.currentTimeMillis() + t * 1000;
	}


	public void remove() {
		this.location = null;
		this.armorstand.remove();
		if (this.armorstand.getPassenger() != null) {
			this.armorstand.getPassenger().remove();

		}
		this.armorstand = null;
		this.h = false;
		this.height = 0;
		this.text = null;
		this.itemstack = null;
	}

	public void teleport(Location location) {
		if (this.location != null) {
			armorstand.teleport(location);
			this.location = location;
		}
	}

	public void spawn() {
		armorstand = (ArmorStand) this.location.getWorld().spawn(this.location, ArmorStand.class);
		armorstand.setGravity(false);
		armorstand.setVisible(false);
		Item i = this.location.getWorld().dropItem(this.getLocation(), this.itemstack);
		i.setPickupDelay(300);
		if (this.text != null) {
			i.setCustomName(this.text);
			i.setCustomNameVisible(true);
		}
		armorstand.setPassenger(i);
	}

	public Location getLocation() {
		return this.location;
	}

	public ItemStack getItemStack() {
		return this.itemstack;
	}

	public double getHeight() {
		return this.height;
	}

	public String getText() {
		return this.text;
	}
	
	public long getTime() {
		return time;
	}

}