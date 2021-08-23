package it.plugandcree.inventoryblocks.commands;

import java.util.List;

import org.bukkit.command.CommandSender;

import com.spigot.libraries.commands.Command;

import it.plugandcree.inventoryblocks.InventoryBlocks;
import it.plugandcree.inventoryblocks.config.CustomConfig;

public class Reload extends Command {
	
	public Reload() {
		super("reload", "inventoryblocks.reload", InventoryBlocks.getInstance().getMainConfig().noPerm());
	}

	@Override
	public boolean execute(CommandSender sender, org.bukkit.command.Command cmd, List<String> args) {
		CustomConfig lang = InventoryBlocks.getInstance().getMainConfig();
		
		InventoryBlocks.getInstance().reloadConfig();
		sender.sendMessage(lang.getString("messages.reload-complete"));
		return true;
	}
}
