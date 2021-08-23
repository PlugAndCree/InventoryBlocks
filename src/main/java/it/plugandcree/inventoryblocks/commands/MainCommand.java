package it.plugandcree.inventoryblocks.commands;

import java.util.List;

import org.bukkit.command.CommandSender;

import com.spigot.libraries.commands.Command;

import net.md_5.bungee.api.ChatColor;


public class MainCommand extends Command {

	public MainCommand() {
		super("inventoryblocks");
		
		registerSubcommand(new Help());
		registerSubcommand(new Reload());
	}

	@Override
	public boolean execute(CommandSender sender, org.bukkit.command.Command cmd, List<String> args) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lINVENTORY BLOCKS &7plugin made by &aPlug_And_Cree"));
		if(sender.hasPermission("inventoryblocks.help"))
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Type &a/inventoryblocks help &7for more info"));
		return false;
	}


}
