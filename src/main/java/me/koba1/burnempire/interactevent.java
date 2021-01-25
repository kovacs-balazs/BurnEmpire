package me.koba1.burnempire;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class interactevent implements Listener {

    private Main m = Main.getPlugin(Main.class);
    itemstacks items = new itemstacks();
    timer timer = new timer();

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        try {
            if (e.getItem().getType() == Material.BOOK) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (e.getPlayer().getItemInHand() != null) {
                        if (e.getPlayer().getItemInHand().getType() != null) {
                            if (e.getItem().isSimilar(items.twoxmoney())) {
                                ItemStack is = e.getPlayer().getItemInHand();
                                is.setAmount(is.getAmount() - 1);

                                int multiplier = files.getMultipliers().getInt("Multipliers." + e.getPlayer().getName() + ".Multiplier");
                                int multipliertime = files.getMultipliers().getInt("Multipliers." + e.getPlayer().getName() + ".MultiplierTime");

                                files.getMultipliers().set("Multipliers." + e.getPlayer().getName() + ".Multiplier", multiplier + 2);
                                files.getMultipliers().set("Multipliers." + e.getPlayer().getName() + ".MultiplierTime", multipliertime + 1800);
                                files.saveMultipliers();

                                p.sendMessage("§7Szorzó aktiválva §a+30 percre§7!");
                            }
                        }
                    }
                }
            }
        } catch (Exception exception) {
            // owww
        }
    }
}
