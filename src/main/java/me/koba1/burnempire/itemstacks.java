package me.koba1.burnempire;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class itemstacks implements Listener {

    public ItemStack twoxmoney() {
        ItemStack is = new ItemStack(Material.BOOK, 1);
        ItemMeta im = is.getItemMeta();

        ArrayList lore = new ArrayList();
        lore.add("§7§l+2x§7 pénzszorzó ölések");
        lore.add("§7és blokk eladás után §l+30 percig");
        lore.add("");
        lore.add("§7Jobb klikk az elhasználáshoz.");
        im.setDisplayName("§c2x pénzszorzó §7(30p)");
        im.setLore(lore);
        is.setItemMeta(im);

        return is;
    }

    public ItemStack Smaragdblock() {
        ItemStack is = new ItemStack(Material.EMERALD_BLOCK, 1);
        ItemMeta im = is.getItemMeta();

        ArrayList lore = new ArrayList();
        lore.add("§7Ércblokkok bányája,");
        lore.add("§7ahol a pvp határtalan.");
        im.setDisplayName("§4§lBánya");
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }

    public ItemStack Diablock() {
        ItemStack is = new ItemStack(Material.DIAMOND_BLOCK, 1);
        ItemMeta im = is.getItemMeta();

        ArrayList lore = new ArrayList();
        lore.add("§7Ércblokkok bányája,");
        lore.add("§7ahol a pvp határtalan.");
        im.setDisplayName("§4§lBánya");
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }

    public ItemStack Goldblock() {
        ItemStack is = new ItemStack(Material.GOLD_BLOCK, 1);
        ItemMeta im = is.getItemMeta();

        ArrayList lore = new ArrayList();
        lore.add("§7Ércblokkok bányája,");
        lore.add("§7ahol a pvp határtalan.");
        im.setDisplayName("§4§lBánya");
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }

    public ItemStack Ironblock() {
        ItemStack is = new ItemStack(Material.IRON_BLOCK, 1);
        ItemMeta im = is.getItemMeta();

        ArrayList lore = new ArrayList();
        lore.add("§7Ércblokkok bányája,");
        lore.add("§7ahol a pvp határtalan.");
        im.setDisplayName("§4§lBánya");
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }

    public ItemStack Quartzblock() {
        ItemStack is = new ItemStack(Material.QUARTZ_ORE, 1);
        ItemMeta im = is.getItemMeta();

        ArrayList lore = new ArrayList();
        lore.add("§7Ércblokkok bányája,");
        lore.add("§7ahol a pvp határtalan.");
        im.setDisplayName("§4§lBánya");
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }

    public ItemStack Lapisore() {
        ItemStack is = new ItemStack(Material.LAPIS_ORE, 1);
        ItemMeta im = is.getItemMeta();

        ArrayList lore = new ArrayList();
        lore.add("§7Ércblokkok bányája,");
        lore.add("§7ahol a pvp határtalan.");
        im.setDisplayName("§4§lBánya");
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }

    public ItemStack redstoneore() {
        ItemStack is = new ItemStack(Material.REDSTONE_ORE, 1);
        ItemMeta im = is.getItemMeta();

        ArrayList lore = new ArrayList();
        lore.add("§7Ércblokkok bányája,");
        lore.add("§7ahol a pvp határtalan.");
        im.setDisplayName("§4§lBánya");
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }

    public ItemStack coalore() {
        ItemStack is = new ItemStack(Material.COAL_ORE, 1);
        ItemMeta im = is.getItemMeta();

        ArrayList lore = new ArrayList();
        lore.add("§7Szénbánya,");
        lore.add("§7ahol a pvp nem létezik.");
        im.setDisplayName("§8§lSzénbánya");
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }

    public ItemStack lapisore() {
        ItemStack is = new ItemStack(Material.LAPIS_ORE, 1);
        ItemMeta im = is.getItemMeta();

        ArrayList lore = new ArrayList();
        lore.add("§7Lapisbánya,");
        lore.add("§7ahol a pvp nem létezik.");
        im.setDisplayName("§9§lSzénbánya");
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }

    public ItemStack lumberyard() {
        ItemStack is = new ItemStack(Material.LOG, 1);
        ItemMeta im = is.getItemMeta();

        ArrayList lore = new ArrayList();
        lore.add("§7Fatelep,");
        lore.add("§7ahol a valóság a megszűnik.");
        im.setDisplayName("§6§lFatelep");
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }
}
