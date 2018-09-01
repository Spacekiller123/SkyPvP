package me.spacekiller.main.commands;

import java.util.function.Consumer;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import me.spacekiller.main.SkyPvP;

public class UmwandelnCommand implements CommandExecutor {
	
	SkyPvP plugin;
	
	public UmwandelnCommand(SkyPvP plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("umwandeln")) {
			Player p = (Player) sender;
			ItemStack skull = new ItemStack(Material.SKULL_ITEM);
			int num = 0;
			for(int i = 0; i < p.getInventory().getSize(); i++) {
				if(p.getInventory().getItem(i) != null && p.getInventory().getItem(i).getType().equals(Material.SKULL_ITEM)) {
					num = num + p.getInventory().getItem(i).getAmount();
					p.getInventory().getItem(i).setAmount(0);
				}
			}
			for(ItemStack i : p.getInventory()) {
				
			}
			ItemStack convSkull = new ItemStack(Material.SKULL_ITEM, num);
			p.sendMessage("§7§lDu hast §f§l" + num + " §7§lKöpfe umgewandelt");
			p.getInventory().addItem(convSkull);
		}
		return false;
	}

}
