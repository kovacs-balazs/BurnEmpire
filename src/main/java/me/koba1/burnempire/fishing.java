package me.koba1.burnempire;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.Random;

public class fishing implements Listener, CommandExecutor {

    private Main m = Main.getPlugin(Main.class);

     @EventHandler(priority = EventPriority.HIGH)
     public void onFish(PlayerFishEvent e) {
         Player p = e.getPlayer();
         Item item = (Item) e.getCaught();
         if(e.getCaught() != null) {
             Random rand = new Random();
             int value = rand.nextInt(100);
             e.getCaught().remove();

             if (value <= 55) p.sendTitle("§4Nem fogtál semmit", "§cMajd legközelebb");
             if (value > 55 && value <= 60) p.getInventory().addItem(ironsword());
             if (value > 60 && value <= 65) p.getInventory().addItem(stonepickaxe());
             if (value > 65 && value <= 70) p.getInventory().addItem(chainmailchestplate());
             if (value > 70 && value <= 75) p.getInventory().addItem(fishingrod());
             if (value > 75 && value <= 80) p.getInventory().addItem(prot2());
             if (value > 80 && value <= 85) p.getInventory().addItem(sharp1());
             if (value > 85 && value <= 90) p.getInventory().addItem(dura2());
             if (value > 90 && value <= 95) p.getInventory().addItem(apple());
             if (value > 95) p.getInventory().addItem(bow());
         }
     }

    public ItemStack ironsword() {
        ItemStack is = new ItemStack(Material.IRON_SWORD);
        is.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        return is;
    }

    public ItemStack stonepickaxe() {
        ItemStack is = new ItemStack(Material.STONE_PICKAXE);
        is.addEnchantment(Enchantment.DIG_SPEED, 2);
        is.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
        is.addEnchantment(Enchantment.DURABILITY, 1);
        return is;
    }

    public ItemStack chainmailchestplate() {
        ItemStack is = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        is.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        is.addEnchantment(Enchantment.DURABILITY, 2);
        return is;
    }

    public ItemStack fishingrod() {
        ItemStack is = new ItemStack(Material.FISHING_ROD);
        is.addEnchantment(Enchantment.LUCK, 1);
        is.addEnchantment(Enchantment.DURABILITY, 1);
        return is;
    }

    public ItemStack prot2() {
        ItemStack is = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta AMeta = (EnchantmentStorageMeta) is.getItemMeta();
        AMeta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        is.setItemMeta(AMeta);
        return is;
    }

    public ItemStack sharp1() {
        ItemStack is = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta AMeta = (EnchantmentStorageMeta) is.getItemMeta();
        AMeta.addStoredEnchant(Enchantment.DAMAGE_ALL, 1, true);
        is.setItemMeta(AMeta);
        return is;
    }

    public ItemStack dura2() {
        ItemStack is = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta AMeta = (EnchantmentStorageMeta) is.getItemMeta();
        AMeta.addStoredEnchant(Enchantment.DURABILITY, 2, true);
        is.setItemMeta(AMeta);
        return is;
    }

    public ItemStack apple() {
        ItemStack is = new ItemStack(Material.APPLE);
        return is;
    }

    public ItemStack bow() {
        ItemStack is = new ItemStack(Material.BOW);
        is.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
        is.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
        return is;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
         if(cmd.getName().equalsIgnoreCase("rand")) {
             Random rand = new Random();
             int value = rand.nextInt(8);
             sender.sendMessage(value + "");

         }
         return false;
    }
}
