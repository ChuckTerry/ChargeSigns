package io.github.tda0909.ChargeSigns;

import org.bukkit.ChatColor;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import java.lang.String;

public class CSCustomListener implements Listener {

	private ChargeSigns plugin;
	
	//Set Instance
	public CSCustomListener(ChargeSigns instance) {
		this.plugin = instance;
	}
	
	
    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    public void DynamicListener(SignChangeEvent event){
    	
    	Player p = event.getPlayer();
    	double money = (ChargeSigns.economy.getBalance(p.getName())); 
    	boolean exempt = true;
    	String Line0 = (event.getLine(0).toLowerCase());
    	String Line1 = (event.getLine(1).toLowerCase());
    	String Line2 = (event.getLine(2).toLowerCase());
    	String Line3 = (event.getLine(3).toLowerCase());
    	    	
    	// Check for Exempt Permission
    	if(exempt = ChargeSigns.permission.has(p, "chargesigns.exempt")){    		
    	}else{

    	
    	// Check if Line0 Exists in the Config
    	if(this.plugin.getConfig().contains("Signs." + Line0 + ".Cost")){
    		double cost = this.plugin.getConfig().getDouble("Signs." + Line0 + ".Cost");
    		if(money < cost){
    			p.sendMessage(ChatColor.GOLD+"That sign cost "+ChatColor.GREEN+cost+ChatColor.GOLD+", You only have: "+ChatColor.GREEN+money);
    			event.setCancelled(true);
    			event.getBlock().breakNaturally();
    		}else{	
    			ChargeSigns.economy.withdrawPlayer(event.getPlayer().getName(), cost);
				p.sendMessage(ChatColor.GOLD+"You were charged "+ChatColor.GREEN+cost+ChatColor.GOLD+" to place that sign.");
    		}   	
    	} else{
    	
    		
    		//Check if Line1 Exists in the Config
    		if(this.plugin.getConfig().contains("Signs." + Line1 + ".Cost")){
        		double cost = this.plugin.getConfig().getDouble("Signs." + Line1 + ".Cost");
        		if(money < cost){
        			p.sendMessage(ChatColor.GOLD+"That sign cost "+ChatColor.GREEN+cost+ChatColor.GOLD+", You only have: "+ChatColor.GREEN+money);
        			event.setCancelled(true);
        			event.getBlock().breakNaturally();
        		}else{	
        			ChargeSigns.economy.withdrawPlayer(event.getPlayer().getName(), cost);
    				p.sendMessage(ChatColor.GOLD+"You were charged "+ChatColor.GREEN+cost+ChatColor.GOLD+" to place that sign.");
        		}   	
        	} else{	
        		
        		
        		//Check if Line2 Exists in the Config
        		if(this.plugin.getConfig().contains("Signs." + Line2 + ".Cost")){
            		double cost = this.plugin.getConfig().getDouble("Signs." + Line2 + ".Cost");
            		if(money < cost){
            			p.sendMessage(ChatColor.GOLD+"That sign cost "+ChatColor.GREEN+cost+ChatColor.GOLD+", You only have: "+ChatColor.GREEN+money);
            			event.setCancelled(true);
            			event.getBlock().breakNaturally();
            		}else{	
            			ChargeSigns.economy.withdrawPlayer(event.getPlayer().getName(), cost);
        				p.sendMessage(ChatColor.GOLD+"You were charged "+ChatColor.GREEN+cost+ChatColor.GOLD+" to place that sign.");
            		}   	
            	} else{
            		
            		
            		//Check if Line3 Exists in the Config
            		if(this.plugin.getConfig().contains("Signs." + Line3 + ".Cost")){
                		double cost = this.plugin.getConfig().getDouble("Signs." + Line3 + ".Cost");
                		if(money < cost){
                			p.sendMessage(ChatColor.GOLD+"That sign cost "+ChatColor.GREEN+cost+ChatColor.GOLD+", You only have: "+ChatColor.GREEN+money);
                			event.setCancelled(true);
                			event.getBlock().breakNaturally();
                		}else{	
                			ChargeSigns.economy.withdrawPlayer(event.getPlayer().getName(), cost);
            				p.sendMessage(ChatColor.GOLD+"You were charged "+ChatColor.GREEN+cost+ChatColor.GOLD+" to place that sign.");
                		}   	
                	} else{	return;}
            	}
            	}
        	}	
    	}
    	return;	    	
    }	
}








































