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
	
	public ChargeSigns plugin;
	
	public CSVault(ChargeSigns instance) {
		plugin = instance;
	}
	
	public static Logger log = Logger.getLogger("Minecraft");
	public static Economy econ = null;
	public static Permission perm = null;
	
	public static boolean VaultPerms() {
		
		RegisteredServiceProvider<Permission> permissionProvider = Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
		if (permissionProvider != null) {
			perm = (Permission)permissionProvider.getProvider();
			log.info("[ChargeSigns] Hooked into Vault Permissons " + perm.getName());
		}
		return perm != null;
	}
	
	
	
}
