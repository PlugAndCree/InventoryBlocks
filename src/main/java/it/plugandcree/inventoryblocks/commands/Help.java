package it.plugandcree.inventoryblocks.commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.spigot.libraries.commands.Command;

import it.plugandcree.inventoryblocks.InventoryBlocks;
import it.plugandcree.inventoryblocks.config.CustomConfig;

public class Help extends Command {

	public Help() {
		super("help", "inventoryblocks.help", InventoryBlocks.getInstance().getMainConfig().noPerm());
	}

	@Override
	public boolean execute(CommandSender sender, org.bukkit.command.Command cmd, List<String> args) {
		CustomConfig lang = InventoryBlocks.getInstance().getMainConfig();
		
		sender.sendMessage(lang.getString("messages.help"));
		sender.sendMessage(ChatColor.GRAY + "Version: " + InventoryBlocks.getInstance().getDescription().getVersion());
		sender.sendMessage(String.format(lang.getRawString("messages.help-format"), "/inventoryblocks", "Show the credits"));
		sender.sendMessage(String.format(lang.getRawString("messages.help-format"), "/inventoryblocks help", "Show this menu"));
		sender.sendMessage(String.format(lang.getRawString("messages.help-format"), "/inventoryblocks reload", "Reload the plugin"));
		
		return true;
	}
}
