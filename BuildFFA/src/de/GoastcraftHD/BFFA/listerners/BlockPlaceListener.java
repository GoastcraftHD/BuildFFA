package de.GoastcraftHD.BFFA.listerners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import de.GoastcraftHD.BFFA.main.Main;

public class BlockPlaceListener implements Listener {
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		
		if (!(event.getPlayer() instanceof Player))
			return;
		
		Player player = event.getPlayer();
		Location blockLoc = event.getBlock().getLocation();
		
		if (player.getLocation().getBlockY() >  Main.getPlugin().getConfig().getInt("PvPHeight")) {
			event.setCancelled(true);
		}
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				blockLoc.getBlock().setType(Material.AIR);
			}
		}, 60);
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		
		if (!(event.getPlayer() instanceof Player))
			return;

		event.setCancelled(true);
	}
}
