package io.github.tda0909.ChargeSigns;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.block.Sign;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.YamlConfiguration;

public final class ChargeSigns extends JavaPlugin{

	private final CSVault VaultPerms = new CSVault(this);
	private ChargeSigns plugin;
	
	
	@Override
	public void onEnable(){
		
		//Show that Plug-In has Loaded
		getLogger().info("[ChargeSigns] Plug-In Enabled");
		
		//Check if Config Exists, Create one if not
		saveDefaultConfig();
		
		//Function in CSVault.java to Hook into Vault Permissions
		CSVault.VaultPerms();
		
		//Function in CSVault.java to Hook into Vault Economy
		CSVault.VaultEcon();
		
		//Command Handlers in CSCommands.java
		getCommand("chargesigns").setExecutor(new CSCommands(this));
		
		//Register Block Listener
		getServer().getPluginManager().registerEvents(new CSBlockListener(this),  this);
		
    }
 
    @Override
    public void onDisable() {
    	getLogger().info("[ChargeSigns] Plug-In Disabled");
    }
    //Sign sign;
    
    
    //public ChargeSignsBlockListener(ChargeSigns instance) {
    	
    //	this.plugin = instance;
    //}
    
    

    	
   
}
    

