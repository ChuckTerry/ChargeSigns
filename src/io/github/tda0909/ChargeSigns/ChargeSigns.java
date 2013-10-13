package io.github.tda0909.ChargeSigns;

import org.bukkit.plugin.java.JavaPlugin;

public final class ChargeSigns extends JavaPlugin{

	@Override
	public void onEnable(){
		
		getLogger().info("[ChargeSigns] Plug-In Enabled");
		
		getCommand("chargesigns").setExecutor(new CSCommands(this));
		
    }
 
    @Override
    public void onDisable() {
    	getLogger().info("[ChargeSigns] Plug-In Disabled");
    }
}
