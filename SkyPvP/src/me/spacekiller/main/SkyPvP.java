package me.spacekiller.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.spacekiller.main.commands.SetItemCommand;
import me.spacekiller.main.commands.SetSkyPvPSpawnCommand;
import me.spacekiller.main.commands.SkyPvPCommand;
import me.spacekiller.main.commands.UmwandelnCommand;
import me.spacekiller.main.listeners.DeathListener;
import me.spacekiller.main.listeners.JumpListener;
import me.spacekiller.main.listeners.RightClickEvent;
import me.spacekiller.main.listeners.VillagerListener;
import me.spacekiller.main.listeners.VoidListener;
import me.spacekiller.main.utils.FlyingItemsMat;


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
		getCommand("setitem").setExecutor(new SetItemCommand(this));
		getCommand("setskypvpspawn").setExecutor(new SetSkyPvPSpawnCommand(this));
		getCommand("skypvp").setExecutor(new SkyPvPCommand(this));
		getCommand("umwandeln").setExecutor(new UmwandelnCommand(this));
	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new DeathListener(this), this);
		pm.registerEvents(new JumpListener(this), this);
		pm.registerEvents(new VoidListener(this), this);
		pm.registerEvents(new RightClickEvent(this), this);
		//pm.registerEvents(new VillagerListener(this), this);
	}

	private void startTimer() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
		
			}
		}, 60L, 20L);
	}

	public void loadConfig() {
		cfg = getConfig();
		if (!cfg.contains("SpawnSelect")) {
			cfg.addDefault("SpawnSelect", "§8§l[§9§lSkyPvP§8§l] §7SkyPvP Spawn gesetzt");
		}
		if (!cfg.contains("NoPermission")) {
			cfg.addDefault("NoPermission", "§8§l[§9§lSkyPvP§8§l] §7Du hast leider keine Rechte diesen Befehl auszuführen!");
		}
		if (!cfg.contains("Prefix")) {
			cfg.addDefault("Prefix", "§8§l[§9§lSkyPvP§8§l] §7");
		}
		cfg.options().copyDefaults(true);
		saveConfig();
	}
	
	
}
