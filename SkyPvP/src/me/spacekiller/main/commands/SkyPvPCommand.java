package me.spacekiller.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import me.spacekiller.main.SkyPvP;

public class SkyPvPCommand implements CommandExecutor {

	SkyPvP plugin;
	
	public SkyPvPCommand(SkyPvP plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("skypvp")) {
			Player p = (Player) sender;
			if(p.getLocation().getBlockY() < p.getWorld().getHighestBlockYAt(p.getLocation())) {
				p.setVelocity(new Vector(0,1,0));
				World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("WorldName"));
				double x = plugin.getConfig().getDouble("spawn.x");
				double y = plugin.getConfig().getDouble("spawn.y");
				double z = plugin.getConfig().getDouble("spawn.z");
				double fy = plugin.getConfig().getDouble("spawn.yaw");
				p.teleport(new Location(w, x, y, z,(float) fy, 0));
			}else {
				p.setVelocity(new Vector(0,4,0));
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				    public void run() {
				    	World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("WorldName"));
						double x = plugin.getConfig().getDouble("spawn.x");
						double y = plugin.getConfig().getDouble("spawn.y");
						double z = plugin.getConfig().getDouble("spawn.z");
						double fy = plugin.getConfig().getDouble("spawn.yaw");
						p.teleport(new Location(w, x, y, z,(float) fy, 0));      
				    }
				}, 20L);
			}
		}
		return false;
	}

	
	
}
