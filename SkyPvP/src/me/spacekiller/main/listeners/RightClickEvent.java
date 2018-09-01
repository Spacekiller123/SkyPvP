package me.spacekiller.main.listeners;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.spacekiller.main.SkyPvP;

public class RightClickEvent implements Listener {

	SkyPvP plugin;
	
	HashMap<Player, Long> schuhList = new HashMap<Player, Long>();
	HashMap<Player, Long> brustList = new HashMap<Player, Long>();
	HashMap<Player, Long> helmList = new HashMap<Player, Long>();
	HashMap<Player, Long> hoseList = new HashMap<Player, Long>();
	HashMap<Player, Long> schwertList = new HashMap<Player, Long>();
	HashMap<Player, Long> axtList = new HashMap<Player, Long>();
	HashMap<Player, Long> sonstList = new HashMap<Player, Long>();
	
	HashMap<Integer, Material> itemSetBoots = new HashMap<Integer, Material>();
	HashMap<Integer, Material> itemSetChest= new HashMap<Integer, Material>();
	HashMap<Integer, Material> itemSetHelm = new HashMap<Integer, Material>();
	HashMap<Integer, Material> itemSetLegs = new HashMap<Integer, Material>();
	HashMap<Integer, Material> itemSetAxe = new HashMap<Integer, Material>();
	HashMap<Integer, Material> itemSetSword = new HashMap<Integer, Material>();
	HashMap<Integer, ItemStack> itemSetMisc = new HashMap<Integer, ItemStack>();
	
	public RightClickEvent(SkyPvP plugin) {
		this.plugin = plugin;
		setItems();
	}

	public void setItems() {
		itemSetBoots.put(0, Material.LEATHER_BOOTS);
		itemSetBoots.put(1, Material.LEATHER_BOOTS);
		itemSetBoots.put(2, Material.LEATHER_BOOTS);
		itemSetBoots.put(3, Material.CHAINMAIL_BOOTS);
		itemSetBoots.put(4, Material.CHAINMAIL_BOOTS);
		itemSetBoots.put(5, Material.CHAINMAIL_BOOTS);
		itemSetBoots.put(6, Material.GOLD_BOOTS);
		itemSetBoots.put(7, Material.GOLD_BOOTS);
		itemSetBoots.put(8, Material.GOLD_BOOTS);
		itemSetBoots.put(9, Material.IRON_BOOTS);
		itemSetBoots.put(10, Material.IRON_BOOTS);
		itemSetBoots.put(11, Material.IRON_BOOTS);
		itemSetBoots.put(12, Material.DIAMOND_BOOTS);
		
		itemSetChest.put(0, Material.LEATHER_CHESTPLATE);
		itemSetChest.put(1, Material.LEATHER_CHESTPLATE);
		itemSetChest.put(2, Material.LEATHER_CHESTPLATE);
		itemSetChest.put(3, Material.CHAINMAIL_CHESTPLATE);
		itemSetChest.put(4, Material.CHAINMAIL_CHESTPLATE);
		itemSetChest.put(5, Material.CHAINMAIL_CHESTPLATE);
		itemSetChest.put(6, Material.GOLD_CHESTPLATE);
		itemSetChest.put(7, Material.GOLD_CHESTPLATE);
		itemSetChest.put(8, Material.GOLD_CHESTPLATE);
		itemSetChest.put(9, Material.IRON_CHESTPLATE);
		itemSetChest.put(10, Material.IRON_CHESTPLATE);
		itemSetChest.put(11, Material.IRON_CHESTPLATE);
		itemSetChest.put(12, Material.DIAMOND_CHESTPLATE);
		
		itemSetHelm.put(0, Material.LEATHER_HELMET);
		itemSetHelm.put(1, Material.LEATHER_HELMET);
		itemSetHelm.put(2, Material.LEATHER_HELMET);
		itemSetHelm.put(3, Material.CHAINMAIL_HELMET);
		itemSetHelm.put(4, Material.CHAINMAIL_HELMET);
		itemSetHelm.put(5, Material.CHAINMAIL_HELMET);
		itemSetHelm.put(6, Material.GOLD_HELMET);
		itemSetHelm.put(7, Material.GOLD_HELMET);
		itemSetHelm.put(8, Material.GOLD_HELMET);
		itemSetHelm.put(9, Material.IRON_HELMET);
		itemSetHelm.put(10, Material.IRON_HELMET);
		itemSetHelm.put(11, Material.GOLD_HELMET);
		itemSetHelm.put(12, Material.DIAMOND_HELMET);
		
		itemSetLegs.put(0, Material.LEATHER_LEGGINGS);
		itemSetLegs.put(1, Material.LEATHER_LEGGINGS);
		itemSetLegs.put(2, Material.LEATHER_LEGGINGS);
		itemSetLegs.put(3, Material.CHAINMAIL_LEGGINGS);
		itemSetLegs.put(4, Material.CHAINMAIL_LEGGINGS);
		itemSetLegs.put(5, Material.CHAINMAIL_LEGGINGS);
		itemSetLegs.put(6, Material.GOLD_LEGGINGS);
		itemSetLegs.put(7, Material.GOLD_LEGGINGS);
		itemSetLegs.put(8, Material.GOLD_LEGGINGS);
		itemSetLegs.put(9, Material.IRON_LEGGINGS);
		itemSetLegs.put(10, Material.IRON_LEGGINGS);
		itemSetLegs.put(11, Material.IRON_LEGGINGS);
		itemSetLegs.put(12, Material.DIAMOND_LEGGINGS);
		
		itemSetSword.put(0, Material.WOOD_SWORD);
		itemSetSword.put(1, Material.WOOD_SWORD);
		itemSetSword.put(2, Material.WOOD_SWORD);
		itemSetSword.put(3, Material.STONE_SWORD);
		itemSetSword.put(4, Material.STONE_SWORD);
		itemSetSword.put(5, Material.STONE_SWORD);
		itemSetSword.put(6, Material.GOLD_SWORD);
		itemSetSword.put(7, Material.GOLD_SWORD);
		itemSetSword.put(8, Material.GOLD_SWORD);
		itemSetSword.put(9, Material.IRON_SWORD);
		itemSetSword.put(10, Material.IRON_SWORD);
		itemSetSword.put(11, Material.IRON_SWORD);
		itemSetSword.put(12, Material.DIAMOND_SWORD);
		
		itemSetAxe.put(0, Material.WOOD_AXE);
		itemSetAxe.put(1, Material.WOOD_AXE);
		itemSetAxe.put(2, Material.WOOD_AXE);
		itemSetAxe.put(3, Material.STONE_AXE);
		itemSetAxe.put(4, Material.STONE_AXE);
		itemSetAxe.put(5, Material.STONE_AXE);
		itemSetAxe.put(6, Material.GOLD_AXE);
		itemSetAxe.put(7, Material.GOLD_AXE);
		itemSetAxe.put(8, Material.GOLD_AXE);
		itemSetAxe.put(9, Material.IRON_AXE);
		itemSetAxe.put(10, Material.IRON_AXE);
		itemSetAxe.put(11, Material.IRON_AXE);
		itemSetAxe.put(12, Material.DIAMOND_AXE);
		
		itemSetMisc.put(0, new ItemStack(Material.FISHING_ROD, 1));
		itemSetMisc.put(1, new ItemStack(Material.POTION, 1, (short) 1));
		itemSetMisc.put(2, new ItemStack(Material.POTION, 1, (short) 8193));
		itemSetMisc.put(3, new ItemStack(Material.POTION, 1, (short) 8194));
		itemSetMisc.put(4, new ItemStack(Material.POTION, 1, (short) 8197));
		itemSetMisc.put(5, new ItemStack(Material.POTION, 1, (short) 8204));

		/*
		if(p.hasPermission("skypvp.smaradg")) {
			int temp = new Random().nextInt(2);
			r += temp;
		}else if(p.hasPermission("skypvp.saphir")) {
			int temp = new Random().nextInt(3);
			r += temp;
		}else if(p.hasPermission("skypvp.rubin")) {
			int temp = new Random().nextInt(4);
			r += temp;
		}
		*/
	}
	
	@EventHandler
	public void onRightClick(PlayerInteractAtEntityEvent e) {
		Player p = e.getPlayer();
		if (e.getRightClicked().getType().equals(EntityType.ARMOR_STAND)) {
			e.setCancelled(true);
			if(e.getRightClicked().getPassenger().getCustomName().equalsIgnoreCase("§lSchuhe")) {
				if(schuhList.containsKey(p)) {
					if(schuhList.get(p) > System.currentTimeMillis()) {
						long now = System.currentTimeMillis();
						long diff = schuhList.get(p) - now;
						int seconds = (int) (diff / 1000L);
						p.sendMessage(plugin.getConfig().getString("Prefix") + "Du kannst erst in " + seconds + " Sekunden wieder Schuhe bekommen");
					}else {
						int r = new Random().nextInt(itemSetBoots.size());
						if(p.hasPermission("skypvp.smaradg")) {
							int temp = new Random().nextInt(2);
							r += temp;
							p.sendMessage("Smaradg: " + (r - temp) + "; " + temp);
						}else if(p.hasPermission("skypvp.saphir")) {
							int temp = new Random().nextInt(3);
							r += temp;
							p.sendMessage("Saphir: " + (r - temp) + "; " + temp);
						}else if(p.hasPermission("skypvp.rubin")) {
							int temp = new Random().nextInt(4);
							r += temp;
							p.sendMessage("Rubin: " + (r - temp) + "; " + temp);
						}
						if(r >= itemSetBoots.size()) {
							r = itemSetBoots.size() - 1;
						}
						p.getInventory().addItem(new ItemStack(itemSetBoots.get(r)));
						schuhList.remove(p);
						schuhList.put(p, System.currentTimeMillis() + 30000);
					}
				}else {
					int r = new Random().nextInt(itemSetBoots.size());
					if(p.hasPermission("skypvp.smaradg")) {
						int temp = new Random().nextInt(2);
						r += temp;
						p.sendMessage("Smaradg: " + (r - temp) + "; " + temp);
					}else if(p.hasPermission("skypvp.saphir")) {
						int temp = new Random().nextInt(3);
						r += temp;
						p.sendMessage("Saphir: " + (r - temp) + "; " + temp);
					}else if(p.hasPermission("skypvp.rubin")) {
						int temp = new Random().nextInt(4);
						r += temp;
						p.sendMessage("Rubin: " + (r - temp) + "; " + temp);
					}
					if(r >= itemSetBoots.size()) {
						r = itemSetBoots.size() - 1;
					}
					p.getInventory().addItem(new ItemStack(itemSetBoots.get(r)));
					schuhList.put(p, System.currentTimeMillis() + 30000);
				}
			}
			if(e.getRightClicked().getPassenger().getCustomName().equalsIgnoreCase("§lBrustplatte")) {
				if(brustList.containsKey(p)) {
					if(brustList.get(p) > System.currentTimeMillis()) {
						long now = System.currentTimeMillis();
						long diff = brustList.get(p) - now;
						int seconds = (int) (diff / 1000L);
						p.sendMessage(plugin.getConfig().getString("Prefix") + "Du kannst erst in " + seconds + " Sekunden wieder eine Brustplatte bekommen");
					}else {
						int r = new Random().nextInt(itemSetChest.size());
						if(p.hasPermission("skypvp.smaradg")) {
							int temp = new Random().nextInt(2);
							r += temp;
							p.sendMessage("Smaradg: " + (r - temp) + "; " + temp);
						}else if(p.hasPermission("skypvp.saphir")) {
							int temp = new Random().nextInt(3);
							r += temp;
							p.sendMessage("Saphir: " + (r - temp) + "; " + temp);
						}else if(p.hasPermission("skypvp.rubin")) {
							int temp = new Random().nextInt(4);
							r += temp;
							p.sendMessage("Rubin: " + (r - temp) + "; " + temp);
						}
						if(r >= itemSetChest.size()) {
							r = itemSetChest.size() - 1;
						}
						p.getInventory().addItem(new ItemStack(itemSetChest.get(r)));
						brustList.remove(p);
						brustList.put(p, System.currentTimeMillis() + 30000);
					}
				}else {
					int r = new Random().nextInt(itemSetChest.size());
					if(p.hasPermission("skypvp.smaradg")) {
						int temp = new Random().nextInt(2);
						r += temp;
						p.sendMessage("Smaradg: " + (r - temp) + "; " + temp);
					}else if(p.hasPermission("skypvp.saphir")) {
						int temp = new Random().nextInt(3);
						r += temp;
						p.sendMessage("Saphir: " + (r - temp) + "; " + temp);
					}else if(p.hasPermission("skypvp.rubin")) {
						int temp = new Random().nextInt(4);
						r += temp;
						p.sendMessage("Rubin: " + (r - temp) + "; " + temp);
					}
					if(r >= itemSetChest.size()) {
						r = itemSetChest.size() - 1;
					}
					p.getInventory().addItem(new ItemStack(itemSetChest.get(r)));
					brustList.put(p, System.currentTimeMillis() + 30000);
				}
			}
			if(e.getRightClicked().getPassenger().getCustomName().equalsIgnoreCase("§lHelm")) {
				if(helmList.containsKey(p)) {
					if(helmList.get(p) > System.currentTimeMillis()) {
						long now = System.currentTimeMillis();
						long diff = helmList.get(p) - now;
						int seconds = (int) (diff / 1000L);
						p.sendMessage(plugin.getConfig().getString("Prefix") + "Du kannst erst in " + seconds + " Sekunden wieder einen Helm bekommen");
					}else {
						int r = new Random().nextInt(itemSetHelm.size());
						if(p.hasPermission("skypvp.smaradg")) {
							int temp = new Random().nextInt(2);
							r += temp;
							p.sendMessage("Smaradg: " + (r - temp) + "; " + temp);
						}else if(p.hasPermission("skypvp.saphir")) {
							int temp = new Random().nextInt(3);
							r += temp;
							p.sendMessage("Saphir: " + (r - temp) + "; " + temp);
						}else if(p.hasPermission("skypvp.rubin")) {
							int temp = new Random().nextInt(4);
							r += temp;
							p.sendMessage("Rubin: " + (r - temp) + "; " + temp);
						}
						if(r >= itemSetHelm.size()) {
							r = itemSetHelm.size() - 1;
						}
						p.getInventory().addItem(new ItemStack(itemSetHelm.get(r)));
						helmList.remove(p);
						helmList.put(p, System.currentTimeMillis() + 30000);
					}
				}else {
					int r = new Random().nextInt(itemSetHelm.size());
					if(p.hasPermission("skypvp.smaradg")) {
						int temp = new Random().nextInt(2);
						r += temp;
						p.sendMessage("Smaradg: " + (r - temp) + "; " + temp);
					}else if(p.hasPermission("skypvp.saphir")) {
						int temp = new Random().nextInt(3);
						r += temp;
						p.sendMessage("Saphir: " + (r - temp) + "; " + temp);
					}else if(p.hasPermission("skypvp.rubin")) {
						int temp = new Random().nextInt(4);
						r += temp;
						p.sendMessage("Rubin: " + (r - temp) + "; " + temp);
					}
					if(r >= itemSetHelm.size()) {
						r = itemSetHelm.size() - 1;
					}
					p.getInventory().addItem(new ItemStack(itemSetHelm.get(r)));
					helmList.put(p, System.currentTimeMillis() + 30000);
				}
			}
			if(e.getRightClicked().getPassenger().getCustomName().equalsIgnoreCase("§lHose")) {
				if(hoseList.containsKey(p)) {
					if(hoseList.get(p) > System.currentTimeMillis()) {
						long now = System.currentTimeMillis();
						long diff = hoseList.get(p) - now;
						int seconds = (int) (diff / 1000L);
						p.sendMessage(plugin.getConfig().getString("Prefix") + "Du kannst erst in " + seconds + " Sekunden wieder eine Hose bekommen");
					}else {
						int r = new Random().nextInt(itemSetLegs.size());
						if(p.hasPermission("skypvp.smaradg")) {
							int temp = new Random().nextInt(2);
							r += temp;
							p.sendMessage("Smaradg: " + (r - temp) + "; " + temp);
						}else if(p.hasPermission("skypvp.saphir")) {
							int temp = new Random().nextInt(3);
							r += temp;
							p.sendMessage("Saphir: " + (r - temp) + "; " + temp);
						}else if(p.hasPermission("skypvp.rubin")) {
							int temp = new Random().nextInt(4);
							r += temp;
							p.sendMessage("Rubin: " + (r - temp) + "; " + temp);
						}
						if(r >= itemSetLegs.size()) {
							r = itemSetLegs.size() - 1;
						}
						p.getInventory().addItem(new ItemStack(itemSetLegs.get(r)));
						hoseList.remove(p);
						hoseList.put(p, System.currentTimeMillis() + 30000);
					}
				}else {
					int r = new Random().nextInt(itemSetLegs.size());
					if(p.hasPermission("skypvp.smaradg")) {
						int temp = new Random().nextInt(2);
						r += temp;
						p.sendMessage("Smaradg: " + (r - temp) + "; " + temp);
					}else if(p.hasPermission("skypvp.saphir")) {
						int temp = new Random().nextInt(3);
						r += temp;
						p.sendMessage("Saphir: " + (r - temp) + "; " + temp);
					}else if(p.hasPermission("skypvp.rubin")) {
						int temp = new Random().nextInt(4);
						r += temp;
						p.sendMessage("Rubin: " + (r - temp) + "; " + temp);
					}
					if(r >= itemSetLegs.size()) {
						r = itemSetLegs.size() - 1;
					}
					p.getInventory().addItem(new ItemStack(itemSetLegs.get(r)));
					hoseList.put(p, System.currentTimeMillis() + 30000);
				}
			}
			if(e.getRightClicked().getPassenger().getCustomName().equalsIgnoreCase("§lSchwert")) {
				if(schwertList.containsKey(p)) {
					if(schwertList.get(p) > System.currentTimeMillis()) {
						long now = System.currentTimeMillis();
						long diff = schwertList.get(p) - now;
						int seconds = (int) (diff / 1000L);
						p.sendMessage(plugin.getConfig().getString("Prefix") + "Du kannst erst in " + seconds + " Sekunden wieder ein Schwert bekommen");
					}else {
						int r = new Random().nextInt(itemSetSword.size());
						if(p.hasPermission("skypvp.smaradg")) {
							int temp = new Random().nextInt(2);
							r += temp;
							p.sendMessage("Smaradg: " + (r - temp) + "; " + temp);
						}else if(p.hasPermission("skypvp.saphir")) {
							int temp = new Random().nextInt(3);
							r += temp;
							p.sendMessage("Saphir: " + (r - temp) + "; " + temp);
						}else if(p.hasPermission("skypvp.rubin")) {
							int temp = new Random().nextInt(4);
							r += temp;
							p.sendMessage("Rubin: " + (r - temp) + "; " + temp);
						}
						if(r >= itemSetSword.size()) {
							r = itemSetSword.size() - 1;
						}
						p.getInventory().addItem(new ItemStack(itemSetSword.get(r)));
						schwertList.remove(p);
						schwertList.put(p, System.currentTimeMillis() + 30000);
					}
				}else {
					int r = new Random().nextInt(itemSetSword.size());
					if(p.hasPermission("skypvp.smaradg")) {
						int temp = new Random().nextInt(2);
						r += temp;
						p.sendMessage("Smaradg: " + (r - temp) + "; " + temp);
					}else if(p.hasPermission("skypvp.saphir")) {
						int temp = new Random().nextInt(3);
						r += temp;
						p.sendMessage("Saphir: " + (r - temp) + "; " + temp);
					}else if(p.hasPermission("skypvp.rubin")) {
						int temp = new Random().nextInt(4);
						r += temp;
						p.sendMessage("Rubin: " + (r - temp) + "; " + temp);
					}
					if(r >= itemSetSword.size()) {
						r = itemSetSword.size() - 1;
					}
					p.getInventory().addItem(new ItemStack(itemSetSword.get(r)));
					schwertList.put(p, System.currentTimeMillis() + 30000);
				}
			}
			if(e.getRightClicked().getPassenger().getCustomName().equalsIgnoreCase("§lAxt")) {
				if(axtList.containsKey(p)) {
					if(axtList.get(p) > System.currentTimeMillis()) {
						long now = System.currentTimeMillis();
						long diff = axtList.get(p) - now;
						int seconds = (int) (diff / 1000L);
						p.sendMessage(plugin.getConfig().getString("Prefix") + "Du kannst erst in " + seconds + " Sekunden wieder eine Axt bekommen");
					}else {
						int r = new Random().nextInt(itemSetAxe.size());
						if(p.hasPermission("skypvp.smaradg")) {
							int temp = new Random().nextInt(2);
							r += temp;
							p.sendMessage("Smaradg: " + (r - temp) + "; " + temp);
						}else if(p.hasPermission("skypvp.saphir")) {
							int temp = new Random().nextInt(3);
							r += temp;
							p.sendMessage("Saphir: " + (r - temp) + "; " + temp);
						}else if(p.hasPermission("skypvp.rubin")) {
							int temp = new Random().nextInt(4);
							r += temp;
							p.sendMessage("Rubin: " + (r - temp) + "; " + temp);
						}
						if(r >= itemSetAxe.size()) {
							r = itemSetAxe.size() - 1;
						}
						p.getInventory().addItem(new ItemStack(itemSetAxe.get(r)));
						axtList.remove(p);
						axtList.put(p, System.currentTimeMillis() + 30000);
					}
				}else {
					int r = new Random().nextInt(itemSetAxe.size());
					if(p.hasPermission("skypvp.smaradg")) {
						int temp = new Random().nextInt(2);
						r += temp;
						p.sendMessage("Smaradg: " + (r - temp) + "; " + temp);
					}else if(p.hasPermission("skypvp.saphir")) {
						int temp = new Random().nextInt(3);
						r += temp;
						p.sendMessage("Saphir: " + (r - temp) + "; " + temp);
					}else if(p.hasPermission("skypvp.rubin")) {
						int temp = new Random().nextInt(4);
						r += temp;
						p.sendMessage("Rubin: " + (r - temp) + "; " + temp);
					}
					if(r >= itemSetAxe.size()) {
						r = itemSetAxe.size() - 1;
					}
					p.getInventory().addItem(new ItemStack(itemSetAxe.get(r)));
					axtList.put(p, System.currentTimeMillis() + 30000);
				}
			}
			if(e.getRightClicked().getPassenger().getCustomName().equalsIgnoreCase("§lSonstiges")) {
				if(sonstList.containsKey(p)) {
					if(sonstList.get(p) > System.currentTimeMillis()) {
						long now = System.currentTimeMillis();
						long diff = sonstList.get(p) - now;
						int seconds = (int) (diff / 1000L);
						p.sendMessage(plugin.getConfig().getString("Prefix") + "Du kannst erst in " + seconds + " Sekunden wieder Sonstiges bekommen");
					}else {
						int r = new Random().nextInt(itemSetMisc.size());
						p.getInventory().addItem(new ItemStack(itemSetMisc.get(r)));
						sonstList.remove(p);
						sonstList.put(p, System.currentTimeMillis() + 30000);
					}
				}else {
					int r = new Random().nextInt(itemSetMisc.size());
					p.getInventory().addItem(new ItemStack(itemSetMisc.get(r)));
					sonstList.put(p, System.currentTimeMillis() + 30000);
				}
			}
			
		}
	}

}
