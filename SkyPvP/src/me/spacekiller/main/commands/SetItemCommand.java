package me.spacekiller.main.commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.spacekiller.main.SkyPvP;
import me.spacekiller.main.utils.FlyingItemsMat;
import me.spacekiller.main.utils.FlyingItemsStack;
import me.spacekiller.main.utils.ItemObject;

public class SetItemCommand implements CommandExecutor {
	SkyPvP plugin;
	
	ArrayList<ItemObject> itemLoc = new ArrayList<ItemObject>();

	//HashMap<Integer, Location> itemLoc = new HashMap<Integer, Location>();
	
	public static File ItemConfig = new File("plugins/SkyPvP/", "ItemConfig.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(ItemConfig);
	
	HashMap<Integer, Material> itemSetBoots = new HashMap<Integer, Material>();
	HashMap<Integer, Material> itemSetChest= new HashMap<Integer, Material>();
	HashMap<Integer, Material> itemSetHelm = new HashMap<Integer, Material>();
	HashMap<Integer, Material> itemSetLegs = new HashMap<Integer, Material>();
	HashMap<Integer, Material> itemSetAxe = new HashMap<Integer, Material>();
	HashMap<Integer, Material> itemSetSword = new HashMap<Integer, Material>();
	HashMap<Integer, ItemStack> itemSetMisc = new HashMap<Integer, ItemStack>();

	private boolean stop = false;
	
	public SetItemCommand(SkyPvP plugin) {
		this.plugin = plugin;
		startTimer();
		startItemSpawn();
		setItems();
		initate();
	}
	
	public void initate() {
		for(String key : cfg.getKeys(true)) {
			Location loc;
			int item;
			if(key.endsWith("world")) {
				loc = new Location(Bukkit.getWorld(cfg.getString(key + ".name")), cfg.getDouble(key + ".x"), cfg.getDouble(key + ".y"), cfg.getDouble(key + ".z"));
				item = cfg.getInt(key + ".item");
				ItemObject ini = new ItemObject(loc, item);
				itemLoc.add(ini);
			}
		}
	}

	public void setItems() {
		itemSetBoots.put(0, Material.LEATHER_BOOTS);
		itemSetBoots.put(1, Material.CHAINMAIL_BOOTS);
		itemSetBoots.put(2, Material.GOLD_BOOTS);
		itemSetBoots.put(3, Material.IRON_BOOTS);
		itemSetBoots.put(4, Material.DIAMOND_BOOTS);
		
		itemSetChest.put(0, Material.LEATHER_CHESTPLATE);
		itemSetChest.put(1, Material.CHAINMAIL_CHESTPLATE);
		itemSetChest.put(2, Material.GOLD_CHESTPLATE);
		itemSetChest.put(3, Material.IRON_CHESTPLATE);
		itemSetChest.put(4, Material.DIAMOND_CHESTPLATE);
		
		itemSetHelm.put(0, Material.LEATHER_HELMET);
		itemSetHelm.put(1, Material.CHAINMAIL_HELMET);
		itemSetHelm.put(2, Material.GOLD_HELMET);
		itemSetHelm.put(3, Material.IRON_HELMET);
		itemSetHelm.put(4, Material.DIAMOND_HELMET);
		
		itemSetLegs.put(0, Material.LEATHER_LEGGINGS);
		itemSetLegs.put(1, Material.CHAINMAIL_LEGGINGS);
		itemSetLegs.put(2, Material.GOLD_LEGGINGS);
		itemSetLegs.put(3, Material.IRON_LEGGINGS);
		itemSetLegs.put(4, Material.DIAMOND_LEGGINGS);
		
		itemSetSword.put(0, Material.WOOD_SWORD);
		itemSetSword.put(1, Material.STONE_SWORD);
		itemSetSword.put(2, Material.GOLD_SWORD);
		itemSetSword.put(3, Material.IRON_SWORD);
		itemSetSword.put(4, Material.DIAMOND_SWORD);
		
		itemSetAxe.put(0, Material.WOOD_AXE);
		itemSetAxe.put(1, Material.STONE_AXE);
		itemSetAxe.put(2, Material.GOLD_AXE);
		itemSetAxe.put(3, Material.IRON_AXE);
		itemSetAxe.put(4, Material.DIAMOND_AXE);
		
		itemSetMisc.put(0, new ItemStack(Material.FISHING_ROD, 1));
		itemSetMisc.put(1, new ItemStack(Material.POTION, 1, (short) 1));
		itemSetMisc.put(2, new ItemStack(Material.POTION, 1, (short) 8193));
		itemSetMisc.put(3, new ItemStack(Material.POTION, 1, (short) 8194));
		itemSetMisc.put(4, new ItemStack(Material.POTION, 1, (short) 8197));
		itemSetMisc.put(5, new ItemStack(Material.POTION, 1, (short) 8204));

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if (cmd.getName().equalsIgnoreCase("setitem") && sender.hasPermission("server.setitem")) {
			Player p = (Player) sender;
			if (args.length == 1 && StringUtils.isNumeric(args[0])) {
				if(Integer.parseInt(args[0]) <= 6) {
					System.out.println("test");
					Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() - 1, p.getLocation().getZ());
					ItemObject item = new ItemObject(loc, Integer.parseInt(args[0]));
					cfg.set(itemLoc.size() + ".world.name", item.getWorldName());
					cfg.set(itemLoc.size() + ".world.x", item.getLocation().getX());
					cfg.set(itemLoc.size() + ".world.y", item.getLocation().getY());
					cfg.set(itemLoc.size() + ".world.z", item.getLocation().getZ());
					cfg.set(itemLoc.size() + ".world.item", item.getItem());
					itemLoc.add(item);
					try {
						cfg.save(ItemConfig);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					p.sendMessage("/setitem <num>");
				}
			}	
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("list")) {
					if (!itemLoc.isEmpty()) {
						for (int i = 0; i < itemLoc.size(); i++) {
							p.sendMessage(i + ";" + itemLoc.get(i).getLocation().getX() + ", " + itemLoc.get(i).getLocation().getY()+ ", " + itemLoc.get(i).getLocation().getZ());
						}

					} else {
						p.sendMessage("0;0");
					}

				}
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("test")) {
					for (Entity e : Bukkit.getWorld(plugin.getConfig().getString("WorldName")).getEntities()) {
						if (e instanceof ArmorStand) {
							e.remove();
						}
					}
				}
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("start")) {
					stop = false;
				}
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("stop")) {
					stop = true;
				}
			}

		}
		return false;
	}

	private void startItemSpawn() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			int z = 0;
			int y = 0;
			int x = 0;
			int w = 0;
			int v = 0;
			int u = 0;
			int t = 0;
			public void run() {
				if (!itemLoc.isEmpty() && !stop) {
					for(int i = 0; i < itemLoc.size(); i++) {
						FlyingItemsMat mat = new FlyingItemsMat();
						Location loc = itemLoc.get(i).getLocation();
						mat.setLocation(loc);
						if(itemLoc.get(i).getItem() == 0) {
							if(z >= itemSetBoots.size()) {
								z = 0;
							}
							mat.setMaterial(itemSetBoots.get(z));
							z++;
							mat.setText("§lSchuhe");
							mat.setTime(20);
							mat.spawn();
						}else if(itemLoc.get(i).getItem() == 1) {
							if(y >= itemSetChest.size()) {
								y = 0;
							}
							mat.setMaterial(itemSetChest.get(y));
							y++;
							mat.setText("§lBrustplatte");
							mat.setTime(20);
							mat.spawn();
						}else if(itemLoc.get(i).getItem() == 2) {
							if(x >= itemSetHelm.size()) {
								x = 0;
							}
							mat.setMaterial(itemSetHelm.get(x));
							x++;
							mat.setText("§lHelm");
							mat.setTime(20);
							mat.spawn();
						}else if(itemLoc.get(i).getItem() == 3) {
							if(w >= itemSetLegs.size()) {
								w = 0;
							}
							mat.setMaterial(itemSetLegs.get(w));
							w++;
							mat.setText("§lHose");
							mat.setTime(20);
							mat.spawn();
						}else if(itemLoc.get(i).getItem() == 4) {
							if(v >= itemSetSword.size()) {
								v = 0;
							}
							mat.setMaterial(itemSetSword.get(v));
							v++;
							mat.setText("§lSchwert");
							mat.setTime(20);
							mat.spawn();
						}else if(itemLoc.get(i).getItem() == 5) {
							if(u >= itemSetAxe.size()) {
								u = 0;
							}
							mat.setMaterial(itemSetAxe.get(u));
							u++;
							mat.setText("§lAxt");
							mat.setTime(20);
							mat.spawn();
						}else if(itemLoc.get(i).getItem() == 6) {
							if(t >= itemSetMisc.size()) {
								t = 0;
							}
							FlyingItemsStack stack = new FlyingItemsStack();
							Location loc2 = itemLoc.get(i).getLocation();
							stack.setLocation(loc);
							stack.setItemStack(itemSetMisc.get(t));
							t++;
							stack.setText("§lSonstiges");
							stack.setTime(20);
							stack.spawn();
						}
					}
				}
			}
		}, 60L, 20L);
	}

	private void startTimer() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				for (Entity e : Bukkit.getWorld(plugin.getConfig().getString("WorldName")).getEntities()) {
					if (e instanceof ArmorStand) {
						e.remove();
						
					}
					if (e instanceof Item) {
						if(e != null && e.getCustomName() != null) {
							if(e.getCustomName().equalsIgnoreCase("§lSchuhe") || 
									e.getCustomName().equalsIgnoreCase("§lBrustplatte") ||
									e.getCustomName().equalsIgnoreCase("§lHelm") ||
									e.getCustomName().equalsIgnoreCase("§lHose") ||
									e.getCustomName().equalsIgnoreCase("§lSchwert") ||
									e.getCustomName().equalsIgnoreCase("§lAxt") || 
									e.getCustomName().equalsIgnoreCase("§lSonstiges")) {
								e.remove();
							}
						}
					}
				}
		
			}
		}, 60L, 20L);
	}
}
