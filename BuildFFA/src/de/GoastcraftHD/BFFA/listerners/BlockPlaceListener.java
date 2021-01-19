package de.GoastcraftHD.BFFA.listerners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import de.GoastcraftHD.BFFA.main.Main;

public class BlockPlaceListener implements Listener {

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		
		if (!(event.getPlayer() instanceof Player))
			return;
		
		if (event.getPlayer().getLocation().getBlockY() >  Main.getPlugin().getConfig().getInt("PvPHeight")) {
			event.setCancelled(true);
		}
	}
}
