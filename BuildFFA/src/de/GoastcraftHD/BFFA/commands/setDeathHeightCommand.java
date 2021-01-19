package de.GoastcraftHD.BFFA.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.GoastcraftHD.BFFA.main.Main;

public class setDeathHeightCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		
		Player player = (Player) sender;
		
		if (!player.hasPermission("BFFA.setDeathHeight")) {
			player.sendMessage("§cDu hast dazu keine Rechte!");
			return false;
		}
		
		Main.getPlugin().getConfig().set("DeathHeight", player.getLocation().getBlockY());
		Main.getPlugin().saveConfig();
		
		return false;
	}
	
}
