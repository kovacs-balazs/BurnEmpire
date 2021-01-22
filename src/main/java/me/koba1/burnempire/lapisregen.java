package me.koba1.burnempire;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class lapisregen implements Listener {
    private Main m = Main.getPlugin(Main.class);

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if(e.getBlock().getType() == Material.LAPIS_ORE) {
            double x = e.getBlock().getLocation().getX() * -1.0;
            //int y = e.getBlock().getLocation().getBlockY();
            double z = e.getBlock().getLocation().getZ() * -1.0;
            if(x >= 918 && x <= 928 && z >= 1569 && z <= 1578) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        e.getBlock().setType(Material.LAPIS_ORE);
                    }
                }.runTaskLater(m, 100);
            }
        }
    }
}
