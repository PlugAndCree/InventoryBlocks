package it.plugandcree.inventoryblocks;

import org.bukkit.plugin.java.JavaPlugin;

import it.plugandcree.inventoryblocks.blocks.BlockBreak;

public class InventoryBlocks extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new BlockBreak(), this);
	}
	
}
