package it.plugandcree.inventoryblocks;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import it.plugandcree.inventoryblocks.blocks.BlockBreak;
import it.plugandcree.inventoryblocks.commands.MainCommand;
import it.plugandcree.inventoryblocks.config.CustomConfig;

public class InventoryBlocks extends JavaPlugin {
	
	private static InventoryBlocks instance;
	private CustomConfig mainConfig;
	
	@Override
	public void onEnable() {
		instance = this;
		
		getServer().getPluginManager().registerEvents(new BlockBreak(), this);
	
		reloadConfig();
		
		new MainCommand().register(this);
	}

	public static InventoryBlocks getInstance() {
		return instance;
	}
	
	public void reloadConfig() {
		setMainConfig(createConfigFile("config.yml"));
	}
		
	public CustomConfig getMainConfig() {
		return mainConfig;
	}

	public void setMainConfig(CustomConfig mainConfig) {
		this.mainConfig = mainConfig;
	}

	private CustomConfig createConfigFile(String name) {
		File fc = new File(getDataFolder(), name);
		if (!fc.exists()) {
			fc.getParentFile().mkdirs();
			saveResource(name, false);
		}

		CustomConfig configFile = new CustomConfig();
		try {
			configFile.load(fc);
			return configFile;
		} catch (IOException | InvalidConfigurationException e) {
			throw new RuntimeException(e);
		}
	}
	
}
