package io.github.tda0909.ChargeSigns;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.YamlConfiguration;

public final class ChargeSigns extends JavaPlugin{

	@Override
	public void onEnable(){
		
		getLogger().info("[ChargeSigns] Plug-In Enabled");
		
		getCommand("chargesigns").setExecutor(new CSCommands(this));
		
    }
 
    @Override
    public void onDisable() {
    	getLogger().info("[ChargeSigns] Plug-In Disabled");
    }
    
    
    @EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
    public void OnSignChange(SignChangeEvent event){
    	Player player = event.getPlayer();
    	
    	
    	
    }
    
    
    @EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
    public void OnBlockPlace(BlockPlaceEvent event){
    	
    }
    
}
