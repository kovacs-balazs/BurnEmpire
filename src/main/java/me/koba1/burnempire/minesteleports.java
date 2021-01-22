package me.koba1.burnempire;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class minesteleports implements Listener, CommandExecutor {

    private Main m = Main.getPlugin(Main.class);
    itemstacks items = new itemstacks();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("mines1")) {
            int min = 0;
            int max = 6;
            int random_int = (int) (Math.random() * (max - min + 1) + min);
            Inventory inv = Bukkit.createInventory(null, 3 * 9, "§5§lBányák");
            ItemStack stainedglasspane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            for(int i = 0; i < inv.getSize(); ++i) {
                inv.setItem(i, stainedglasspane);
            }
            switch (random_int) {
                case 0:
                    inv.setItem(10, items.Diablock());
                    break;
                case 1:
                    inv.setItem(10, items.Smaragdblock());
                    break;
                case 2:
                    inv.setItem(10, items.Goldblock());
                    break;
                case 3:
                    inv.setItem(10, items.Quartzblock());
                    break;
                case 4:
                    inv.setItem(10, items.Lapisore());
                    break;
                case 5:
                    inv.setItem(10, items.redstoneore());
                    break;
                case 6:
                    inv.setItem(10, items.Ironblock());
                    break;
            }
            inv.setItem(12, items.coalore());
            inv.setItem(14, items.lapisore());
            inv.setItem(16, items.lumberyard());
            p.openInventory(inv);
        }
        //
        if (cmd.getName().equalsIgnoreCase("go")) {
            if (args.length == 0) {
                sender.sendMessage("§7Választható teleportok: §bbanya§7, §bszenbanya§7, §bfatelep§7, §bpvparena§'7, §blapisbanya");
            }
            //
            //
            else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("banya") || args[0].equalsIgnoreCase("bánya")
                        || args[0].equalsIgnoreCase("pvpbanya") || args[0].equalsIgnoreCase("pvpbánya")
                        || args[0].equalsIgnoreCase("pvpmine") || args[0].equalsIgnoreCase("mine")) {
                    Bukkit.dispatchCommand(m.getServer().getConsoleSender(), "warp banya " + p.getName());
                }
                //
                else if (args[0].equalsIgnoreCase("szenbanya") || args[0].equalsIgnoreCase("szénbánya")
                        || args[0].equalsIgnoreCase("szénbanya") || args[0].equalsIgnoreCase("szenbánya")
                        || args[0].equalsIgnoreCase("coalmine") || args[0].equalsIgnoreCase("coalbanya")
                        || args[0].equalsIgnoreCase("coalbánya")) {
                    Bukkit.dispatchCommand(m.getServer().getConsoleSender(), "warp szenbanya " + p.getName());
                }
                //
                else if (args[0].equalsIgnoreCase("lapisbanya") || args[0].equalsIgnoreCase("lapismine")
                        || args[0].equalsIgnoreCase("lapisbánya")) {
                    Bukkit.dispatchCommand(m.getServer().getConsoleSender(), "warp lapisbanya " + p.getName());
                }
                //
                else if (args[0].equalsIgnoreCase("fatelep") || args[0].equalsIgnoreCase("lumberyard")) {
                    Bukkit.dispatchCommand(m.getServer().getConsoleSender(), "warp fatelep " + p.getName());
                }
                //
                else if (args[0].equalsIgnoreCase("pvparena") || args[0].equalsIgnoreCase("pvparéna")
                        ||args[0].equalsIgnoreCase("aréna") || args[0].equalsIgnoreCase("arena")) {
                    Bukkit.dispatchCommand(m.getServer().getConsoleSender(), "warp pvparena " + p.getName());
                }
            }
        }

        else if(cmd.getName().equalsIgnoreCase("pvparena")) {
            Bukkit.dispatchCommand(m.getServer().getConsoleSender(), "warp pvparena " + p.getName());
        }
        return false;
    }

    @EventHandler
    public void onInvInteract(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase("§5§lBányák")) {
            e.setCancelled(true);
            switch (e.getSlot()) {
                case 10:
                    Bukkit.dispatchCommand(m.getServer().getConsoleSender(), "warp banya " + p.getName());
                    break;
                case 12:
                    Bukkit.dispatchCommand(m.getServer().getConsoleSender(), "warp szenbanya " + p.getName());
                    break;
                case 14:
                    Bukkit.dispatchCommand(m.getServer().getConsoleSender(), "warp lapisbanya " + p.getName());
                    break;
                case 16:
                    Bukkit.dispatchCommand(m.getServer().getConsoleSender(), "warp fatelep " + p.getName());
                    break;
            }
        }
    }
}
