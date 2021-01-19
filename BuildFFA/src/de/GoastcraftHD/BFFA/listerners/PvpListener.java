package de.GoastcraftHD.BFFA.listerners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import de.GoastcraftHD.BFFA.main.Main;

public class PvpListener implements Listener {

	@EventHandler
	public void onPvp(EntityDamageEvent event) {
		
		if (!(event.getEntity() instanceof Player))
			return;
		
		if (event.getEntity().getLocation().getBlockY() >  Main.getPlugin().getConfig().getInt("PvPHeight")) {
			event.setCancelled(true);
		}
		
		if (event.getCause().equals(DamageCause.FALL)) {
			event.setCancelled(true);
		}
	}
}
