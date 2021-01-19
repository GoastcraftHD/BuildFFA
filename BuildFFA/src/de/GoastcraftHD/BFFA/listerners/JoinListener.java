package de.GoastcraftHD.BFFA.listerners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		if (!(event.getPlayer() instanceof Player))
			return;
		
		Player player = event.getPlayer();
		
		player.getInventory().clear();
	}
	
}
