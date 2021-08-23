package it.plugandcree.inventoryblocks.blocks;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import it.plugandcree.inventoryblocks.InventoryBlocks;
import net.md_5.bungee.api.ChatColor;

public class BlockBreak implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();

		if (!p.hasPermission("inventoryblocks.use"))
			return;

		if (e.isCancelled())
			return;

		if (!(p.getGameMode() == GameMode.SURVIVAL))
			return;

		e.setDropItems(false);

		e.getBlock().getDrops(p.getInventory().getItemInMainHand()).forEach(p.getInventory()::addItem);

		if (p.getInventory().firstEmpty() == -1) {
			p.sendTitle(
					ChatColor.translateAlternateColorCodes('&',
							InventoryBlocks.getInstance().getConfig().getString("inventory-full.title")),
					ChatColor.translateAlternateColorCodes('&',
							InventoryBlocks.getInstance().getConfig().getString("inventory-full.subtitle")),
					InventoryBlocks.getInstance().getConfig().getInt("inventory-full.fadein"),
					InventoryBlocks.getInstance().getConfig().getInt("inventory-full.stay"),
					InventoryBlocks.getInstance().getConfig().getInt("inventory-full.fadeout"));
		}
	}

}
