package de.GoastcraftHD.BFFA.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.GoastcraftHD.BFFA.main.Main;

public class setSpawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		
		Player player = (Player) sender;
		
		if (!player.hasPermission("BFFA.setSpawn")) {
			player.sendMessage("§cDu hast dazu keine Rechte!");
			return false;
		}
		
		Main.getPlugin().getConfig().set("SpawnPoint.world", player.getLocation().getWorld().getName());
		Main.getPlugin().getConfig().set("SpawnPoint.x", player.getLocation().getBlockX());
		Main.getPlugin().getConfig().set("SpawnPoint.y", player.getLocation().getBlockY());
		Main.getPlugin().getConfig().set("SpawnPoint.z", player.getLocation().getBlockZ());
		Main.getPlugin().getConfig().set("SpawnPoint.yaw", player.getLocation().getYaw());
		Main.getPlugin().getConfig().set("SpawnPoint.pitch", player.getLocation().getPitch());
		Main.getPlugin().saveConfig();
		
		return false;
	}
}
