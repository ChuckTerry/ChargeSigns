package io.github.tda0909.ChargeSigns;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.logging.Level;
import java.util.logging.Logger;


public class CSVault {
	
	private static final Logger Log = null;
	public ChargeSigns plugin;
	public static Logger log = Logger.getLogger("Minecraft");
	public static Economy econ = null;
	public static Permission perm = null;
	
	
	public CSVault(ChargeSigns instance) {
		plugin = instance;
	}
	
	//Function Initialized OnEnable to Check for & Hook into Vault Permissions
	public static boolean VaultPerms() {
		
		RegisteredServiceProvider<Permission> permissionProvider = Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
		if (permissionProvider != null) {
			perm = (Permission)permissionProvider.getProvider();
			log.info("[ChargeSigns] Hooked into Vault Permissons " + perm.getName());
		}
		return perm != null;
	}
	
	
	//Function Initialized OnEnable to Check for & Hook into Vault Economy
	public static boolean VaultEcon() {

	    if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) {
	            return false;
	    }
	    RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
	    if (rsp == null) {
	        return false;
	    }
	    econ = rsp.getProvider();
	    log.info("[ChargeSigns] Hooked into Vault Economy " + econ.getName());
	    return econ != null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
