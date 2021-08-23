package it.plugandcree.inventoryblocks;

import org.bukkit.plugin.java.JavaPlugin;

import it.plugandcree.inventoryblocks.blocks.BlockBreak;

public class InventoryBlocks extends JavaPlugin {
	
	private static InventoryBlocks instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		getServer().getPluginManager().registerEvents(new BlockBreak(), this);
	}

	public static InventoryBlocks getInstance() {
		return instance;
	}
	
	
}
