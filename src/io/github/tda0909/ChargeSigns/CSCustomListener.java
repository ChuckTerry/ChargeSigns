package io.github.tda0909.ChargeSigns;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.Material;

public class CSCustomListener implements Listener {

	private ChargeSigns plugin;
	
	//Set Instance
	public CSCustomListener(ChargeSigns instance) {
		this.plugin = instance;
	}
	
	

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    public void Lockette(SignChangeEvent event){
    	
    	Player p = event.getPlayer();
    	//String perms = (ChargeSigns.perms)
    	//if(ChargeSigns.perms.has(p, "chargesigns.exempt")) return;
    	
    	double money = (ChargeSigns.economy.getBalance(p.getName()));
    	
    	String Line0 = (event.getLine(0));
    	String Line1 = (event.getLine(1));
    	String Line2 = (event.getLine(2));
    	String Line3 = (event.getLine(3));
    	    	
    	if(this.plugin.getConfig().contains("Signs." + Line0 + ".Cost")){
    		double cost = this.plugin.getConfig().getDouble("Signs." + Line0 + ".Cost");
    		if(money < cost){
    			p.sendMessage("That sign cost " + cost + ", You only have: " + money);
    			event.setCancelled(true);
    			event.getBlock().breakNaturally();
    		}else{	
    			ChargeSigns.economy.withdrawPlayer(event.getPlayer().getName(), cost);
				p.sendMessage("You were charged " + cost + " to place that sign.");
    		}   	
    	} else{
    	
    		if(this.plugin.getConfig().contains("Signs." + Line1 + ".Cost")){
        		double cost = this.plugin.getConfig().getDouble("Signs." + Line1 + ".Cost");
        		if(money < cost){
        			p.sendMessage("That sign cost " + cost + ", You only have: " + money);
        			event.setCancelled(true);
        			event.getBlock().breakNaturally();
        		}else{	
        			ChargeSigns.economy.withdrawPlayer(event.getPlayer().getName(), cost);
    				p.sendMessage("You were charged " + cost + " to place that sign.");
        		}   	
        	} else{	
        		
        		if(this.plugin.getConfig().contains("Signs." + Line2 + ".Cost")){
            		double cost = this.plugin.getConfig().getDouble("Signs." + Line2 + ".Cost");
            		if(money < cost){
            			p.sendMessage("That sign cost " + cost + ", You only have: " + money);
            			event.setCancelled(true);
            			event.getBlock().breakNaturally();
            		}else{	
            			ChargeSigns.economy.withdrawPlayer(event.getPlayer().getName(), cost);
        				p.sendMessage("You were charged " + cost + " to place that sign.");
            		}   	
            	} else{
            		
            		if(this.plugin.getConfig().contains("Signs." + Line3 + ".Cost")){
                		double cost = this.plugin.getConfig().getDouble("Signs." + Line3 + ".Cost");
                		if(money < cost){
                			p.sendMessage("That sign cost " + cost + ", You only have: " + money);
                			event.setCancelled(true);
                			event.getBlock().breakNaturally();
                		}else{	
                			ChargeSigns.economy.withdrawPlayer(event.getPlayer().getName(), cost);
            				p.sendMessage("You were charged " + cost + " to place that sign.");
                		}   	
                	} else{	return;}
            	}
        	}	
    	}
    	//yaml["options"].include? "some_option"
    	
    	
    	/*if(event.getLine(0).equalsIgnoreCase("[Private]")){
    				double cost = this.plugin.getConfig().getDouble("Lockette.Private.Cost");
    				if(money < cost){
    					p.sendMessage("That sign cost " + cost + ", You only have: " + money);
    					event.setCancelled(true);
    					event.getBlock().breakNaturally();
        			} else{
        				ChargeSigns.economy.withdrawPlayer(event.getPlayer().getName(), cost);
        				p.sendMessage("You were charged " + cost + " to place that sign.");
        			}
    	} else{return;}*/

    	
    	
    	
    	
    	
    	
    	return;	
    	
    }
	
}








































