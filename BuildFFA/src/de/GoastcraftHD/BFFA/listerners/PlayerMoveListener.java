package de.GoastcraftHD.BFFA.listerners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import de.GoastcraftHD.BFFA.main.Main;
import de.GoastcraftHD.BFFA.utils.ItemBuilder;

public class PlayerMoveListener implements Listener {
	
	private ItemStack[] standartInv = new ItemStack[] { new ItemBuilder(Material.GOLD_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 1, false).addEnchant(Enchantment.DURABILITY, 10, true).build(),
			new ItemBuilder(Material.STICK).addEnchant(Enchantment.KNOCKBACK, 1, false).build(),
			new ItemBuilder(Material.LADDER).setAmount(3).build(),
			new ItemBuilder(Material.SANDSTONE).setAmount(64).build(),
			new ItemBuilder(Material.SANDSTONE).setAmount(64).build(),
			new ItemBuilder(Material.SANDSTONE).setAmount(64).build(),
			new ItemBuilder(Material.SANDSTONE).setAmount(64).build(),
			new ItemBuilder(Material.SANDSTONE).setAmount(64).build(),
			new ItemBuilder(Material.ENDER_PEARL).build()};
	
	@EventHandler
	public void onPlayerMove( PlayerMoveEvent event) {
		if (!(event.getPlayer() instanceof Player))
			return;
		
		Player player = event.getPlayer();
		
		if (player.getLocation().getBlockY() < Main.getPlugin().getConfig().getInt("PvPHeight")) {
			int i = 0;
			for (ItemStack item : standartInv) {
				player.getInventory().setItem(i, item);
				i++;
			}
		} else if (player.getLocation().getBlockY() > Main.getPlugin().getConfig().getInt("PvPHeight")) {
			player.getInventory().clear();
		}
		
		if (player.getLocation().getBlockY() < Main.getPlugin().getConfig().getInt("DeathHeight")) {
			Location spawn = new Location(Bukkit.getWorld(Main.getPlugin().getConfig().getString("SpawnPoint.world")),
										  Main.getPlugin().getConfig().getInt("SpawnPoint.x"),
										  Main.getPlugin().getConfig().getInt("SpawnPoint.y"),
										  Main.getPlugin().getConfig().getInt("SpawnPoint.z"),
										  Main.getPlugin().getConfig().getInt("SpawnPoint.yaw"),
										  Main.getPlugin().getConfig().getInt("SpawnPoint.pitch"));
			player.teleport(spawn);
			player.setHealth(20);
			player.setFoodLevel(20);
			player.getInventory().clear();
		}
	}
	
}
