package me.spowney.antinetherdupe;

import org.bukkit.ChatColor;
import org.bukkit.World.Environment;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerTeleportEvent;


public class AntiNetherDupePlayerListener extends PlayerListener{
	
public static AntiNetherDupe plugin;
	
	public AntiNetherDupePlayerListener(AntiNetherDupe instance) {
        plugin = instance;
	}
	
	public void onPlayerTeleport(PlayerTeleportEvent e)
	{
		if(e.getFrom().getWorld().getEnvironment() == Environment.NETHER && e.getTo().getWorld().getEnvironment() != Environment.NETHER)
		{
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.RED + "Teleporting from the nether to another world is disabled. You have been teleported to the nether portal instead");
			e.getPlayer().teleport(e.getPlayer().getWorld().getSpawnLocation());		
		}
		
		//add similar expression for the end when building with 1.0 bukkit
	}
	

}
