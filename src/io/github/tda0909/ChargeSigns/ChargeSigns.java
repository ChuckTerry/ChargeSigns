package io.github.tda0909.ChargeSigns;

import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class ChargeSigns extends JavaPlugin{

	//Set Public Fields
	public ChargeSigns plugin;
	public static Economy economy = null;
	public static Economy balance = null;
	public static Block block = null;
	public static Permission perms = null;

	
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
		getServer().getPluginManager().registerEvents(new CSBlockListener(this), this);
		getServer().getPluginManager().registerEvents(new CSCustomListener(this), this);
		
    }
 
    @Override
    public void onDisable() {
    	getLogger().info("[ChargeSigns] Plug-In Disabled");
    }   	
   
}
    

