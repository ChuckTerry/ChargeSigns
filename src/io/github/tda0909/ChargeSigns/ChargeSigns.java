package io.github.tda0909.ChargeSigns;


import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
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
	public FileConfiguration config;

	
	@Override
	public void onEnable(){
		
		// Check for Vault, Disable ChargeSigns if not Found
		if (!CSVault.VaultEcon()){
			log.severe(String.format("Vault is Required for [ChargeSigns] to Function!  Plug-In Disabled", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
            return;}
		
		// Show that Plug-In has Loaded
		getLogger().info("Plug-In Enabled");
		
		// Check if Config Exists, Create one if not
		saveDefaultConfig();
		
		//Method to Hook into Vault Permissions
		VaultPerms();		
		
		// Function in CSVault.java to Hook into Vault Economy
		CSVault.VaultEcon();
		
		// Command Handlers in CSCommands.java
		//getCommand("chargesigns").setExecutor(new CSCommands(this));
		
		// Register Block Listener
		getServer().getPluginManager().registerEvents(new CSCustomListener(this), this);			
    }

	
	
    @Override
    public void onDisable() {
    	getLogger().info("[ChargeSigns] Plug-In Disabled");
    }   	
   
    
    // Method Called onEnable() to Hook into Vault Permissions
	public boolean VaultPerms() {
		
		RegisteredServiceProvider<Permission> permissionProvider = Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
		if (permissionProvider != null) {
			permission = (Permission)permissionProvider.getProvider();
			log.info("[ChargeSigns] Hooked into Vault Permissons " + permission.getName());
		}
		return permission != null;
	}
    
	
	
	// Handles All /ChargeSigns Command
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		    if (cmd.getName().equalsIgnoreCase("chargesigns")) {
		    	
		    	
		    	// Base Command to Show Plug-In is Active
		    	if(args.length == 0){
		    		if (!(sender instanceof Player)) {
		    			sender.sendMessage("Console, Command Run Confirmed");
		    			return true;
		    			} else {
		    				sender.sendMessage("Player, Command Run Confirmed");
		    				return true;
		    				}
		    		}
		    	
		    	
		    	if(args.length == 1){
		    		
		    		// Returns the Version Number Listed in the Plugin.yml
		    		if (args[0].equalsIgnoreCase("version")){
		    			sender.sendMessage(ChatColor.GOLD+"Charge Signs "+ChatColor.GREEN+this.getDescription().getVersion());
		    			return true;
		    		}
		    		
		    		//Reloads Configuration
		    		else if (args[0].equalsIgnoreCase("reload")){		    					    			
		    			reloadConfig();
		    			sender.sendMessage(ChatColor.GOLD+"Configuration Reloaded");
		    			return true;
		    			
		    		} 
		    		
		    		else if (args[0].equalsIgnoreCase("cost")){
		    			sender.sendMessage("Cost Not Yet Implemented");
		    			
		    		
		    			return true;
		    		}
		    		
		    		else if (args[0].equalsIgnoreCase("add")){
		    			sender.sendMessage("Add Not Yet Implemented");
		    			return true;
		    		}
		    		
		    		else if (args[0].equalsIgnoreCase("modify")){
		    			sender.sendMessage("Modify Not Yet Implemented");
		    			return true;
		    		}
		    		
		    		else if (args[0].equalsIgnoreCase("remove")){
		    			sender.sendMessage("Remove Not Yet Implemented");
		    			return true;
		    		}
		    		
		    		else if (args[0].equalsIgnoreCase("exempt")){
		    			sender.sendMessage("Exempt Not Yet Implemented");
		    			return true;
		    		}
		    		
		    		else if (args[0].equalsIgnoreCase("norefund")){
		    			sender.sendMessage("NoRefund Not Yet Implemented");
		    			return true;
		    		}
		    		
		    		else {
		    				sender.sendMessage("Invalid Command Arguments");
		    				return true;
		    		}
		    		
		    	}
		    	
		    	// Place Holder
		    	if(args.length == 2)
		    		sender.sendMessage("Invalid Command Arguments");

		    	
		    	// If Wrong Number of Arguments
		    	if(args.length > 2)
		    		sender.sendMessage("Invalid Command Arguments");
		    	
		    	
		    	
		    }
		    
		    
			return false;
	}
    
    
}
    

