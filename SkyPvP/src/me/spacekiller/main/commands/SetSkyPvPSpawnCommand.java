package me.spacekiller.main.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.SkyPvP;

public class SetSkyPvPSpawnCommand implements CommandExecutor {

	SkyPvP plugin;
	
	public SetSkyPvPSpawnCommand(SkyPvP plugin) {
		this.plugin = plugin;
	}
	

	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("setskypvpspawn")) {
			if (player.hasPermission("Skypvp.setspawn")) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("SpawnSelect")));
				plugin.getConfig().set("WorldName",
						player.getLocation().getWorld().getName());
				plugin.getConfig().set("spawn.x",
						Integer.valueOf(player.getLocation().getBlockX()));
				plugin.getConfig().set("spawn.z",
						Integer.valueOf(player.getLocation().getBlockZ()));
				plugin.getConfig().set("spawn.y",
						Integer.valueOf(player.getLocation().getBlockY()));
				plugin.getConfig().set("spawn.yaw",
						Float.valueOf(player.getLocation().getYaw()));
				plugin.saveConfig();
				return true;
			}
			player.sendMessage(ChatColor.translateAlternateColorCodes('&',
					plugin.getConfig().getString("NoPermission")));
		}
		return false;
	}
	
}
