package io.github.tda0909.ChargeSigns;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.YamlConfiguration;

public final class ChargeSigns extends JavaPlugin{

	private final CSVault VaultPerms = new CSVault(this);
	
	@Override
	public void onEnable(){
		getLogger().info("[ChargeSigns] Plug-In Enabled");
		
		CSVault.VaultPerms();
		//VaultEcon();
		
		getCommand("chargesigns").setExecutor(new CSCommands(this));
		
    }
 
    @Override
    public void onDisable() {
    	getLogger().info("[ChargeSigns] Plug-In Disabled");
    }
    
    
    @EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
    public void Lockette(SignChangeEvent event){
    	
    	if(event.getLine(0).equalsIgnoreCase("[Private]"))
    		
    	
    	
    	return;	
    	
   
    }
    
}
