package me.koba1.burnempire;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Directional;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Sign;
import org.bukkit.scheduler.BukkitRunnable;

import javax.swing.plaf.nimbus.State;

public class anvilregen implements Listener {

    private Main m = Main.getPlugin(Main.class);

    @EventHandler
    public void onEventPush(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        try {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block clicked = e.getClickedBlock();
                if (clicked.getType() == Material.ANVIL) {
                    double x = clicked.getLocation().getX() * -1.0;
                    double y = clicked.getLocation().getBlockY();
                    double z = clicked.getLocation().getZ();
                    World world = p.getWorld();

                    if (x == 658.0 && y == 4.0 && z == 170.0) {
                        Location loc = new Location(clicked.getWorld(), (-658), 1, 170);
                        loc.getBlock().setType(Material.REDSTONE_BLOCK);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                loc.getBlock().setType(Material.STONE);
                            }
                        }.runTaskLater(m, 10);
                    }
                    //
                    if(x == 660.0 && y == 4.0 && z == 168.0) {
                        Location loc = new Location(clicked.getWorld(), (-660), 4, 168);
                        loc.getBlock().setType(Material.ANVIL);
                    }
                }
            }
        } catch (Exception exception) {
            // owww
        }
    }
}
