package de.GoastcraftHD.BFFA.listerners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.GoastcraftHD.BFFA.main.Main;

public class DeathListener implements Listener {

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		
		if (!(event.getEntity() instanceof Player))
			return;
		
		event.setDeathMessage("");
		
		Location spawn = new Location(Bukkit.getWorld(Main.getPlugin().getConfig().getString("SpawnPoint.world")),
				  Main.getPlugin().getConfig().getInt("SpawnPoint.x"),
				  Main.getPlugin().getConfig().getInt("SpawnPoint.y"),
				  Main.getPlugin().getConfig().getInt("SpawnPoint.z"),
				  Main.getPlugin().getConfig().getInt("SpawnPoint.yaw"),
				  Main.getPlugin().getConfig().getInt("SpawnPoint.pitch"));
		
		event.getEntity().teleport(spawn);
	}
}
