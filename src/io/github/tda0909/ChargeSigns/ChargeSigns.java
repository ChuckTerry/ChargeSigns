package io.github.tda0909.ChargeSigns;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class ChargeSigns extends JavaPlugin{

	//Set Static Fields
	public ChargeSigns plugin;
	public static Economy economy = null;
	public static Economy balance = null;
	public static Block block = null;
	public static Permission permission = null;
	private static final Logger log = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable(){
		
		//Check for Vault, Disable ChargeSigns if not Found
		if (!CSVault.VaultEcon()){
			log.severe(String.format("Vault is Required for [ChargeSigns] to Function!  Plug-In Disabled", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
            return;}
		
		//Show that Plug-In has Loaded
		getLogger().info("[ChargeSigns] Plug-In Enabled");
		
		//Check if Config Exists, Create one if not
		saveDefaultConfig();
		
		//Function to Hook into Vault Permissions
		VaultPerms();		
		
		//Function in CSVault.java to Hook into Vault Economy
		CSVault.VaultEcon();
		
		//Command Handlers in CSCommands.java
		getCommand("chargesigns").setExecutor(new CSCommands(this));
		
		//Register Block Listener
		getServer().getPluginManager().registerEvents(new CSCustomListener(this), this);				
    }
 
	public static boolean VaultPerms() {
		
		RegisteredServiceProvider<Permission> permissionProvider = Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
		if (permissionProvider != null) {
			permission = (Permission)permissionProvider.getProvider();
			log.info("[ChargeSigns] Hooked into Vault Permissons " + permission.getName());
		}
		return permission != null;
	}
	
    @Override
    public void onDisable() {
    	getLogger().info("[ChargeSigns] Plug-In Disabled");
    }   	
   

    
    
    
    
    
    
}
    

