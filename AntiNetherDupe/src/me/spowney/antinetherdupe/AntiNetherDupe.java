package me.spowney.antinetherdupe;

import java.util.logging.Logger;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
	
	 public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) 
	    {
	        String[] split = args;
	        
	        String commandName = command.getName().toLowerCase();
	        
	            if (sender instanceof Player) 
	            {
	                Player player = (Player) sender;
	                
	                if (commandName.equalsIgnoreCase("setnetherspawn")) 
	                {
	                	if(player.isOp() || player.hasPermission("netherspawn.set"))
	                	{
	                		if(player.getWorld().getEnvironment() == Environment.NETHER)
	                		{
	                			Block block = player.getLocation().getBlock();
	                			player.getWorld().setSpawnLocation(block.getX(), block.getY(), block.getZ());
	                			player.sendMessage(ChatColor.RED + "Nether Spawn point set");
	                			return true;
	                		}
	                		else
	                		{
	                			player.sendMessage(ChatColor.RED + "You are not in the nether");
	                			return true;
	                		}
	                		
	                	}

	                
	                	
	                }
	                
	                else if (commandName.equalsIgnoreCase("setendspawn")) 
	                {
	                	if(player.isOp() || player.hasPermission("endspawn.set"))
	                	{
	                		if(player.getWorld().getEnvironment() == Environment.THE_END)
	                		{
	                			Block block = player.getLocation().getBlock();
	                			player.getWorld().setSpawnLocation(block.getX(), block.getY(), block.getZ());
	                			player.sendMessage(ChatColor.RED + "the End Spawn point set");
	                			return true;
	                		}
	                		else
	                		{
	                			player.sendMessage(ChatColor.RED + "You are not in the end");
	                			return true;
	                		}
	                		
	                	}

	                
	                	
	                }
	                else
	                {
	                	player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
	                	return true;
	                }
	                
	                
	            }
	            return false;
	    }
	
	
	Logger l = Logger.getLogger("Minecraft");
	Server s = Bukkit.getServer();	

}
