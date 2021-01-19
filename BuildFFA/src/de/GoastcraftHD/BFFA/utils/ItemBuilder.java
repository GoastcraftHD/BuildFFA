package de.GoastcraftHD.BFFA.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	
	private ItemStack item;
	private ItemMeta itemMeta;

	public ItemBuilder(Material material, short subID) {
		item = new ItemStack(material, 1, subID);
		itemMeta = item.getItemMeta();
	}
	
	public ItemBuilder(Material material) {
		this(material, (short)0);
	}
	
	public ItemBuilder setName(String name) {
		if (name != null)
			itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		else
			itemMeta.setDisplayName(" ");
		return this;
	}
	
	public ItemBuilder setLore(String... lore) {
		ArrayList<String> arrayList = new ArrayList<String>();
		if (lore != null) {
			for (String string : lore) {
				arrayList.add(ChatColor.translateAlternateColorCodes('&', string));
			}
			itemMeta.setLore(arrayList);
		} else {
			arrayList.add(" ");
			itemMeta.setLore(arrayList);
		}
		return this;
	}
	
	public ItemBuilder setLore(ArrayList<String> ArrayLore) {
		ArrayList<String> arrayList = new ArrayList<String>();
		if (ArrayLore != null) {
			for (String string : ArrayLore) {
				arrayList.add(ChatColor.translateAlternateColorCodes('&', string));
			}
			itemMeta.setLore(arrayList);
		} else {
			arrayList.add(" ");
			itemMeta.setLore(arrayList);
		}
		return this;
	}
	
	public ItemBuilder setLore(List<?> list) {
		ArrayList<String> arrayList = new ArrayList<String>();
		if (list != null) {
			for (Object object : list) {
				arrayList.add(ChatColor.translateAlternateColorCodes('&', (String) object));
			}
			itemMeta.setLore(arrayList);
		} else {
			arrayList.add(" ");
			itemMeta.setLore(arrayList);
		}
		return this;
	}
	
	public ItemBuilder setAmount(int amount) {
		item.setAmount(amount);
		return this;
	}
	
	public ItemBuilder addEnchant(Enchantment enchantment, int level, boolean overlvlcap) {
		itemMeta.addEnchant(enchantment, level, overlvlcap);
		return this;
	}
	
	public ItemStack build() {
		item.setItemMeta(itemMeta);
		return item;
	}
}