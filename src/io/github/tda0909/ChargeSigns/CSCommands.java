package io.github.tda0909.ChargeSigns;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CSCommands implements CommandExecutor {

	private final ChargeSigns plugin;
//	
	public CSCommands(ChargeSigns plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		    if (cmd.getName().equalsIgnoreCase("chargesigns")) {
		    	
		    	if (!(sender instanceof Player)) {
		    	//Player player = (Player) sender;
				sender.sendMessage("Console, Command Run Confirmed");
				
		    	} else {
		    		sender.sendMessage("Player, Command Run Confirmed");
		    	return true;
		    	}
		    }
			return false;
		    
	}
}
