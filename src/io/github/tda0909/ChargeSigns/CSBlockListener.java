package io.github.tda0909.ChargeSigns;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.Bukkit;




public class CSBlockListener implements Listener {

	private ChargeSigns plugin;
	
	Sign sign;
	
	public CSBlockListener(ChargeSigns instance){
		this.plugin = instance;
	}
	
    @EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
    public void Lockette(SignChangeEvent event){
    	
    	if(event.getLine(0).equalsIgnoreCase("[Private]"))
    			Bukkit.getLogger().info("[Private] Sign Placed");
    		
    	
    	
    	return;	
    }
}
