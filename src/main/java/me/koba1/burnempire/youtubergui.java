package me.koba1.burnempire;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class youtubergui implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("youtuber")) {
                p.getPlayer().openInventory(inv());
            }
        }
        return false;
    }

    public ItemStack info() {
        ItemStack is = new ItemStack(Material.BOOK, 1);
        ItemMeta im = is.getItemMeta();

        im.setDisplayName("§7Mi a §4You§fTuber §7rang?");
        ArrayList lore = new ArrayList();
        lore.add("§7Jogai ugyanazok, mint a §bGlitch§7 rangnak §b+");
        lore.add("");
        lore.add("§b➡ §7Ölések után §b$750§7 kapsz");
        lore.add("§b➡ §7/fly parancs jog");
        lore.add("§b➡ §7/tp parancs jog (Telek világban)");
        lore.add("§b➡ §7/v parancs jog");
        im.setLore(lore);
        is.setItemMeta(im);

        return is;
    }

    public ItemStack howcani() {
        ItemStack is = new ItemStack(Material.BOOK, 1);
        ItemMeta im = is.getItemMeta();

        im.setDisplayName("§7Hogyan tudom megszerezni a §4You§fTuber §7rangot?");
        ArrayList lore = new ArrayList();
        lore.add("§7Követelmények:");
        lore.add("");
        lore.add("§b➡ §7Heti 2 darab minimum 1 órás stream,");
        lore.add("§7amin legalább 10 átlag néző van.");
        im.setLore(lore);
        is.setItemMeta(im);

        return is;
    }

    public Inventory inv() {
        Inventory inv = Bukkit.createInventory(null, 1 * 9, "§4You§fTuber §7rang");
        ItemStack glasspane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
        for(int i = 0; i < 9; ++i) {
            inv.setItem(i, glasspane);
        }
        inv.setItem(2, info());
        inv.setItem(6, howcani());

        return inv;
    }

    @EventHandler
    public void onInvEvent(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§4You§fTuber §7rang")) {
            e.setCancelled(true);
        }
    }
}
