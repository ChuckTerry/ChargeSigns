package io.github.tda0909.ChargeSigns;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.logging.Logger;


public class CSVault {
	
	public ChargeSigns plugin;
	private static Logger log = Logger.getLogger("Minecraft");
	private static Permission permission = null;
	
	
	/*/Function Initialized by OnEnable to Check for & Hook into Vault Permissions
	public static boolean VaultPerms() {
		
		RegisteredServiceProvider<Permission> permissionProvider = Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
		if (permissionProvider != null) {
			permission = (Permission)permissionProvider.getProvider();
			log.info("[ChargeSigns] Hooked into Vault Permissons " + permission.getName());
		}
		return permission != null;
	}*/
	
	
	//Function Initialized by OnEnable to Check for & Hook into Vault Economy
	public static boolean VaultEcon() {

	    if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) {
	            return false;
	    }
	    RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
	    if (rsp == null) {
	        return false;
	     	        
	    }
	    ChargeSigns.economy = rsp.getProvider();
	    log.info("[ChargeSigns] Hooked into Vault Economy " + ChargeSigns.economy.getName());
	    return ChargeSigns.economy != null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
