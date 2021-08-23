package it.plugandcree.inventoryblocks.blocks;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import it.plugandcree.inventoryblocks.InventoryBlocks;
import it.plugandcree.inventoryblocks.config.CustomConfig;

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
			CustomConfig conf = InventoryBlocks.getInstance().getMainConfig();

			p.sendTitle(conf.getRawString("inventory-full.title"), conf.getRawString("inventory-full.subtitle"),
					conf.getInt("inventory-full.fadein"), conf.getInt("inventory-full.stay"),
					conf.getInt("inventory-full.fadeout"));
		}
	}

}
