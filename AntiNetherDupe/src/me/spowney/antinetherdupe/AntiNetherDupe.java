package me.spowney.antinetherdupe;

import java.util.logging.Logger;


import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiNetherDupe extends JavaPlugin{
	
	private final AntiNetherDupePlayerListener playerListener = new AntiNetherDupePlayerListener(this);

	@Override
	public void onEnable() {
		
		PluginManager plman = s.getPluginManager();
		
		plman.registerEvent(Event.Type.PLAYER_TELEPORT, playerListener, Event.Priority.Normal, this);
		
		
	}
	
	@Override
	public void onDisable() {

		
	}
	
	
	Logger l = Logger.getLogger("Minecraft");
	Server s = Bukkit.getServer();	

}
