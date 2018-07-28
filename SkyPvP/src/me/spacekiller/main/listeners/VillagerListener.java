package me.spacekiller.main.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.spacekiller.main.SkyPvP;

public class VillagerListener implements Listener {
	
	Inventory inv = Bukkit.createInventory(null, 45,"§a§lEXP Shop");
	
	Inventory woodInv = Bukkit.createInventory(null, 45,"§2§lHolz- und Lederausrüstung");
	Inventory chainInv = Bukkit.createInventory(null, 45,"§7§lKettenausrüstung");
	Inventory ironInv = Bukkit.createInventory(null, 45,"§8§lEisenausrüstung");
	Inventory goldInv = Bukkit.createInventory(null, 45,"§6§lGoldausrüstungp");
	Inventory diamondInv = Bukkit.createInventory(null, 45,"§b§lDiamantenausrüstung");
	Inventory foodInv = Bukkit.createInventory(null, 45,"§c§lEssen");
	Inventory potionsInv = Bukkit.createInventory(null, 45,"§9§lTränke");
	Inventory enchantmentInv = Bukkit.createInventory(null, 45,"§5§lVerzauberungen");
	
	ArrayList<String> woodList = new ArrayList<String>();
	ArrayList<String> chainList = new ArrayList<String>();
	ArrayList<String> ironList = new ArrayList<String>();
	ArrayList<String> goldList = new ArrayList<String>();
	ArrayList<String> diamondList = new ArrayList<String>();
	ArrayList<String> foodList = new ArrayList<String>();
	ArrayList<String> potionsList = new ArrayList<String>();
	ArrayList<String> enchantmentList = new ArrayList<String>();
	
	ItemStack wood = new ItemStack(Material.LEATHER_CHESTPLATE);
	ItemStack chain = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
	ItemStack iron = new ItemStack(Material.IRON_CHESTPLATE);
	ItemStack gold = new ItemStack(Material.GOLD_CHESTPLATE);
	ItemStack diamond = new ItemStack(Material.DIAMOND_CHESTPLATE);
	ItemStack food = new ItemStack(Material.APPLE);
	ItemStack potions = new ItemStack(Material.POTION);
	ItemStack enchantment = new ItemStack(Material.ENCHANTED_BOOK);
	
	SkyPvP plugin;
	
	private boolean initated = false;
	
	public VillagerListener(SkyPvP plugin) {
		this.plugin = plugin;
	}
	
	public void initateInventory() {
		
		ItemMeta woodMeta = wood.getItemMeta();
		woodMeta.setDisplayName("§2§lHolz- und Lederausrüstung");
		woodList.add("§f§lKlicken um das Menu zu öffnen.");
		woodMeta.setLore(woodList);
		wood.setItemMeta(woodMeta);
		inv.setItem(10, wood);
		
		ItemMeta chainMeta = chain.getItemMeta();
		chainMeta.setDisplayName("§7§lKettenausrüstung");
		chainList.add("§f§lKlicken um das Menu zu öffnen.");
		chainMeta.setLore(chainList);
		chain.setItemMeta(chainMeta);
		inv.setItem(12, chain);
		
		ItemMeta ironMeta = iron.getItemMeta();
		ironMeta.setDisplayName("§8§lEisenausrüstung");
		ironList.add("§f§lKlicken um das Menu zu öffnen.");
		ironMeta.setLore(ironList);
		iron.setItemMeta(ironMeta);
		inv.setItem(14, iron);
		
		ItemMeta goldMeta = gold.getItemMeta();
		goldMeta.setDisplayName("§6§lGoldausrüstung");
		goldList.add("§f§lKlicken um das Menu zu öffnen.");
		goldMeta.setLore(goldList);
		gold.setItemMeta(goldMeta);
		inv.setItem(16, gold);
		
		ItemMeta diamondMeta = diamond.getItemMeta();
		diamondMeta.setDisplayName("§b§lDiamantenausrüstung");
		diamondList.add("§f§lKlicken um das Menu zu öffnen.");
		diamondMeta.setLore(diamondList);
		diamond.setItemMeta(diamondMeta);
		inv.setItem(28, diamond);
		
		ItemMeta foodMeta = food.getItemMeta();
		foodMeta.setDisplayName("§c§lEssen");
		foodList.add("§f§lKlicken um das Menu zu öffnen.");
		foodMeta.setLore(foodList);
		food.setItemMeta(foodMeta);
		inv.setItem(30, food);
		
		ItemMeta potionsMeta = potions.getItemMeta();
		potionsMeta.setDisplayName("§9§lTränke");
		potionsList.add("§f§lKlicken um das Menu zu öffnen.");
		potionsMeta.setLore(potionsList);
		potions.setItemMeta(potionsMeta);
		inv.setItem(32, potions);
		
		ItemMeta enchantmentMeta = enchantment.getItemMeta();
		enchantmentMeta.setDisplayName("§5§lVerzauberungen");
		enchantmentList.add("§f§lKlicken um das Menu zu öffnen.");
		enchantmentMeta.setLore(enchantmentList);
		enchantment.setItemMeta(enchantmentMeta);
		inv.setItem(34, enchantment);
	}
	
	@EventHandler
	public void onClickVillager(PlayerInteractEntityEvent e) {
		if(!initated) {
			initateInventory();
			initated = true;
		}
		if(e.getRightClicked().getType() == EntityType.VILLAGER) {
			e.setCancelled(true);
			e.getPlayer().openInventory(inv);
		}
	}
	
	@EventHandler
	public void onGuiClick(InventoryClickEvent e) {
		if(e.getWhoClicked() instanceof Player) {
			if(e.getInventory().equals(inv)) {
				if(e.getCurrentItem().equals(wood)) {
					e.getWhoClicked().openInventory(woodInv);
				}else if(e.getCurrentItem().equals(wood)) {
					e.getWhoClicked().openInventory(woodInv);
				}else if(e.getCurrentItem().equals(chain)) {
					e.getWhoClicked().openInventory(chainInv);
				}else if(e.getCurrentItem().equals(iron)) {
					e.getWhoClicked().openInventory(ironInv);
				}else if(e.getCurrentItem().equals(gold)) {
					e.getWhoClicked().openInventory(goldInv);
				}else if(e.getCurrentItem().equals(diamond)) {
					e.getWhoClicked().openInventory(diamondInv);
				}else if(e.getCurrentItem().equals(food)) {
					e.getWhoClicked().openInventory(foodInv);
				}else if(e.getCurrentItem().equals(potions)) {
					e.getWhoClicked().openInventory(potionsInv);
				}else if(e.getCurrentItem().equals(enchantment)) {
					e.getWhoClicked().openInventory(enchantmentInv);
				}
				e.setCancelled(true);
			}
		}
	}
 
}
