package me.spowney.antinetherdupe;

import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityListener;

public class AntiNetherDupeEntityListener extends EntityListener{
	
public static AntiNetherDupe plugin;
	
	public AntiNetherDupeEntityListener(AntiNetherDupe instance) {
        plugin = instance;
	}
	
	public void onEntityInteract(EntityInteractEvent e)
	{
		if(e.getBlock().getTypeId() == 58)
		{
			e.setCancelled(true);
		}
	}

}
