package me.spacekiller.main.utils;

import org.bukkit.Location;

public class ItemObject {
	
	private Location loc;

	private int item;
	
	public ItemObject(Location l, int i) {
		loc = l;
		item = i;
	}
	
	public void setItem(int i) {
		item = i;
	}
	
	public void setLocation(Location l) {
		loc = l;
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public int getItem() {
		return item;
	}
	
	public String getWorldName() {
		return loc.getWorld().getName();
	}
	
}
