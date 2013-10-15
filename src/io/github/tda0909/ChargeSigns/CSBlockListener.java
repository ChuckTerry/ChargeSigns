package io.github.tda0909.ChargeSigns;

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

public class CSBlockListener implements Listener {

	private ChargeSigns plugin;
	
	//Set Instance
	public CSBlockListener(ChargeSigns instance) {
		this.plugin = instance;
	}
	
	
	//Lockette Method (Probably ReWrite for Multiple Methods)
    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    public void Lockette(SignChangeEvent event){
    	
    	Player p = event.getPlayer();
    	double money = (ChargeSigns.economy.getBalance(p.getName()));
    	
    	//Lockette [Private] Sign
    	if(event.getLine(0).equalsIgnoreCase("[Private]")){
    				double cost = this.plugin.getConfig().getDouble("Lockette.Private.Cost");
    				if(money < cost){
    					p.sendMessage("That sign cost " + cost + ", You only have: " + money);
    					event.setCancelled(true);
    					event.getBlock().breakNaturally();
        			} else{
        				ChargeSigns.economy.withdrawPlayer(event.getPlayer().getName(), cost);
        				p.sendMessage("You were charged " + cost + " to place that sign.");
        			}
    	} else{return;}
    	
    	//Lockette [More Users] Sign
    	if(event.getLine(0).equalsIgnoreCase("[More Users]")){
    				double cost = this.plugin.getConfig().getDouble("Lockette.Private.MoreUsers");
    				if(money < cost){
    					p.sendMessage("That sign cost " + cost + ", You only have: " + money);
    					event.setCancelled(true);
    					event.getBlock().breakNaturally();
        			} else{
        				ChargeSigns.economy.withdrawPlayer(event.getPlayer().getName(), cost);
        				p.sendMessage("You were charged " + cost + " to place that sign.");
        			}
    	} else{return;}
    	    	
    	return;	
    	
    }
    /*
    //NEWAREA
	//Lockette Method (Probably ReWrite for Multiple Methods)
    @EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
    public void LocketteTest(BlockPlaceEvent event){
    	
    	Player p = event.getPlayer();
    	double money = (ChargeSigns.economy.getBalance(p.getName()));
    	int type = (ChargeSigns.block.getTypeId());
    	
    	if (type == Material.WALL_SIGN.getId()) {
    	
    	//Lockette [Private] Sign
    	if(event.getLine(0).equalsIgnoreCase("[Private]")){
    				double cost = this.plugin.getConfig().getDouble("Lockette.Private.Cost");
    				if(money < cost){
    					p.sendMessage("That sign cost " + cost + ", You only have: " + money);
    					event.setCancelled(true);
    					event.getBlock().breakNaturally();
        			} else{
        				ChargeSigns.economy.withdrawPlayer(event.getPlayer().getName(), cost);
        				p.sendMessage("You were charged " + cost + " to place that sign.");
        			}
    	} else{return;}
    	
    	//Lockette [More Users] Sign
    	if(event.getLine(0).equalsIgnoreCase("[More Users]")){
    				double cost = this.plugin.getConfig().getDouble("Lockette.Private.MoreUsers");
    				if(money < cost){
    					p.sendMessage("That sign cost " + cost + ", You only have: " + money);
    					event.setCancelled(true);
    					event.getBlock().breakNaturally();
        			} else{
        				ChargeSigns.economy.withdrawPlayer(event.getPlayer().getName(), cost);
        				p.sendMessage("You were charged " + cost + " to place that sign.");
        			}
    	} else{return;}
    	    	
    	return;	
    	
    }*/
    
    
    
}























