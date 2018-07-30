package me.spacekiller.main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.spacekiller.main.commands.SetSkyPvPSpawnCommand;
import me.spacekiller.main.commands.SkyPvPCommand;
import me.spacekiller.main.listeners.JumpListener;
import me.spacekiller.main.listeners.VillagerListener;
import me.spacekiller.main.listeners.VoidListener;


public class SkyPvP extends JavaPlugin {
	
	private FileConfiguration cfg;

	public void onEnable() {
		System.out.println("[]=============================[]");
		System.out.println("|       Skypvp Aktiviert!       |");
		System.out.println("|        by Spacekiller!        |");
		System.out.println("[]=============================[]");

		loadConfig();
		registerCommands();
		registerEvents();
		startTimer();
		saveDefaultConfig();
	}

	public void registerCommands() {
		getCommand("setskypvpspawn").setExecutor(new SetSkyPvPSpawnCommand(this));
		getCommand("skypvp").setExecutor(new SkyPvPCommand(this));
	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new JumpListener(this), this);
		pm.registerEvents(new VoidListener(this), this);
		pm.registerEvents(new VillagerListener(this), this);
	}

	private void startTimer() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			public void run() {
				for (Player players : Bukkit.getOnlinePlayers()) {
					
				}
		
			}
		}, 60L, 60L);
	}

	public void loadConfig() {
		saveConfig();
	}
	
	
}
