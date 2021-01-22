package me.koba1.burnempire;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class timer implements Listener {

    private Main m = Main.getPlugin(Main.class);

    public void timer() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player onlinePlayers : m.getServer().getOnlinePlayers()) {
                    int multipliertime2 = files.getMultipliers().getInt("Multipliers." + onlinePlayers.getName() + ".MultiplierTime");

                    if (multipliertime2 == 0) {
                        files.getMultipliers().set("Multipliers." + onlinePlayers.getName() + ".Multiplier", 0);
                        files.getMultipliers().set("Multipliers." + onlinePlayers.getName() + ".MultiplierTime", 0);
                        files.saveMultipliers();
                    }
                    if (multipliertime2 > 0) {
                        files.getMultipliers().set("Multipliers." + onlinePlayers.getName() + ".MultiplierTime", multipliertime2 - 1);
                        files.saveMultipliers();
                    }
                }
            }
        }.runTaskTimer(m, 0,20L);

        new BukkitRunnable() {
            @Override
            public void run () {
                boolean maintenance = m.getConfig().getBoolean("Maintenance." + "Maintenance");
                if (maintenance == true) {
                    m.getServer().broadcastMessage("§8[§bKarbantartás§8] §bKarbantartás jelenleg be van kapcsolva");
                } else {
                    // owww
                }
            }
        }.runTaskTimer(m, 0,6000L);
    }
}
