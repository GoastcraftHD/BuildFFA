package de.GoastcraftHD.BFFA.listerners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.GoastcraftHD.BFFA.main.Main;

public class JoinListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		if (!(event.getPlayer() instanceof Player))
			return;
		
		Player player = event.getPlayer();
		
		Location spawn = new Location(Bukkit.getWorld(Main.getPlugin().getConfig().getString("SpawnPoint.world")),
				  Main.getPlugin().getConfig().getInt("SpawnPoint.x"),
				  Main.getPlugin().getConfig().getInt("SpawnPoint.y"),
				  Main.getPlugin().getConfig().getInt("SpawnPoint.z"),
				  Main.getPlugin().getConfig().getInt("SpawnPoint.yaw"),
				  Main.getPlugin().getConfig().getInt("SpawnPoint.pitch"));
		
		player.getInventory().clear();
		player.teleport(spawn);
	}
	
}
