package de.GoastcraftHD.BFFA.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.GoastcraftHD.BFFA.commands.setDeathHeightCommand;
import de.GoastcraftHD.BFFA.commands.setPvpHeightCommand;
import de.GoastcraftHD.BFFA.commands.setSpawnCommand;
import de.GoastcraftHD.BFFA.listerners.BlockPlaceListener;
import de.GoastcraftHD.BFFA.listerners.JoinListener;
import de.GoastcraftHD.BFFA.listerners.PlayerMoveListener;
import de.GoastcraftHD.BFFA.listerners.PvpListener;

public class Main extends JavaPlugin {

	private static Main plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		
		getCommand("setPvPHeight").setExecutor(new setPvpHeightCommand());
		getCommand("setDeathHeight").setExecutor(new setDeathHeightCommand());
		getCommand("setSpawnPoint").setExecutor(new setSpawnCommand());
		
		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), this);
		Bukkit.getPluginManager().registerEvents(new PvpListener(), this);
		Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(), this);
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
}