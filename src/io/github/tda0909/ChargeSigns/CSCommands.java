package io.github.tda0909.ChargeSigns;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;


public class CSCommands implements CommandExecutor {

	public ChargeSigns plugin;
	// Sets Instance
	public CSCommands(ChargeSigns instance) {
		this.plugin = instance;
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
		    	
		    	// ChargeSigns Version - Shows Current PlugIn Version
		    	if(args.length == 1){
		    		
		    		if (args[0].equalsIgnoreCase("version")){
		    			//String pdf = PluginDescriptionFile.getDescription();
		    			//PluginDescriptionFile pdf = this.getDescription();
		    			//String ver = ChargeSigns.pdf.getVersion();
		    			//sender.sendMessage("Charge Signs " + ver);
		    			return true;
		    		}
		    		
		    		else if (args[0].equalsIgnoreCase("reload")){
		    			//PluginDescriptionFile pdf = plugin.getVersion();
		    			//String pdf = plugin.getVersion();
		    			sender.sendMessage("Reload Not Yet Implemented");
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
		    	
		    	// If Wrong Number of Arguments
		    	if(args.length > 1)
		    		sender.sendMessage("Invalid Command Arguments");
		    	
		    	
		    	
		    }
		    
		    
			return false;
	}
	
	
	
	
	
}
