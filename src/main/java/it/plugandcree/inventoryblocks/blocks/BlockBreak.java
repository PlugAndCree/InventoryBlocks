package it.plugandcree.inventoryblocks.blocks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if (!e.getPlayer().hasPermission("inventoryblocks.use"))
			return;

		Player p = e.getPlayer();

		e.setDropItems(false);

		e.getBlock().getDrops(p.getInventory().getItemInMainHand()).forEach(p.getInventory()::addItem);
	}

}
