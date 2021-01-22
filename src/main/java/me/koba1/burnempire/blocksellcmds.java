package me.koba1.burnempire;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;

public class blocksellcmds implements Listener, CommandExecutor {

    private Main m = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        int something = 0;
        int blockok = 0;
        HashMap<String, Integer> price = new HashMap<String, Integer>();

        if (sender instanceof Player) {
            if (args.length == 0) {
                if (cmd.getName().equalsIgnoreCase("sLeTR8cyvXkyGrxt")) {
                    for (ItemStack is : p.getInventory().getContents()) {
                        if (is != null && is.getType() == Material.DIAMOND_BLOCK) {
                            int diaamount = 0;

                            blockok += is.getAmount();
                            diaamount += is.getAmount() * 15;
                            something += diaamount;
                            price.put(p.getName(), something);
                        }

                        if (is != null && is.getType() == Material.EMERALD_BLOCK) {
                            int smariamount = 0;

                            blockok += is.getAmount();
                            smariamount += is.getAmount() * 8;
                            something += smariamount;
                            price.put(p.getName(), something);
                        }

                        if (is != null && is.getType() == Material.GOLD_BLOCK) {
                            int goldamount = 0;

                            blockok += is.getAmount();
                            goldamount += is.getAmount() * 10;
                            something += goldamount;
                            price.put(p.getName(), something);
                        }

                        if (is != null && is.getType() == Material.LAPIS_BLOCK) {
                            int lapisamount = 0;

                            blockok += is.getAmount();
                            lapisamount += is.getAmount() * 8;
                            something += lapisamount;
                            price.put(p.getName(), something);
                        }

                        if (is != null && is.getType() == Material.QUARTZ) {
                            int quartzamount = 0;

                            blockok += is.getAmount();
                            quartzamount += is.getAmount() * 3;
                            something += quartzamount;
                            price.put(p.getName(), something);
                        }

                        if (is != null && is.getType() == Material.REDSTONE) {
                            int redstoneamount = 0;

                            blockok += is.getAmount();
                            redstoneamount += is.getAmount() * 3;
                            something += redstoneamount;
                            price.put(p.getName(), something);
                        }

                        if (is != null && is.getType() == Material.IRON_BLOCK) {
                            int ironblock = 0;

                            blockok += is.getAmount();
                            ironblock += is.getAmount() * 5;
                            something += ironblock;
                            price.put(p.getName(), something);
                        }

                        if (is != null && is.getType() == Material.INK_SACK && is.getDurability() == 4) {
                            int lapis = 0;

                            blockok += is.getAmount();
                            lapis += is.getAmount() * 3;
                            something += lapis;
                            price.put(p.getName(), something);
                        }
                    }

                    int lapisboolean = 0;
                    for (ItemStack is : p.getInventory().getContents()) {
                        if (is != null && is.getType() == Material.INK_SACK) {
                            short data = is.getDurability();
                            if (data == 4) {
                                lapisboolean = 1;
                                p.getPlayer().getInventory().remove(is);
                            } else {
                                lapisboolean = 0;
                            }
                        }
                    }

                    if (p.getPlayer().getInventory().contains(Material.DIAMOND_BLOCK) || p.getPlayer().getInventory().contains(Material.EMERALD_BLOCK)
                            || p.getPlayer().getInventory().contains(Material.GOLD_BLOCK) || p.getPlayer().getInventory().contains(Material.LAPIS_BLOCK)
                            || p.getPlayer().getInventory().contains(Material.QUARTZ) || p.getPlayer().getInventory().contains(Material.REDSTONE)
                            || p.getPlayer().getInventory().contains(Material.IRON_BLOCK) || lapisboolean == 1) {
                        p.getInventory().remove(Material.DIAMOND_BLOCK);
                        p.getInventory().remove(Material.EMERALD_BLOCK);
                        p.getInventory().remove(Material.GOLD_BLOCK);
                        p.getInventory().remove(Material.LAPIS_BLOCK);
                        p.getInventory().remove(Material.QUARTZ);
                        p.getInventory().remove(Material.REDSTONE);
                        p.getInventory().remove(Material.IRON_BLOCK);
                        p.updateInventory();

                        Integer price2 = price.get(p.getName());
                        Integer price1 = price.get(p.getName());
                        int multiplier = files.getMultipliers().getInt("Multipliers." + p.getName() + ".Multiplier");
                        //if (p.hasPermission("blocksell.glitch")) price1 = price2 * 2;

                        int sellprice;
                        if (p.hasPermission("blocksell.glitch")) {
                            sellprice = price2 * multiplier + price1 * 2;
                        } else {
                            if (multiplier == 0) {
                                sellprice = price2;
                            } else {
                                sellprice = price2 * multiplier + price1;
                            }
                        }

                        p.sendMessage("§7Eladtál §c" + blockok + " §7tárgyat §c$" + sellprice + "§7-ért.");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + p.getName() + " " + sellprice);

                    } else {
                        p.sendMessage("§cNincsen nálad megfelelő block!");
                    }
                }
                //
                else if (cmd.getName().equalsIgnoreCase("OADVNdig4J68f2Lf")) {
                    for (ItemStack is : p.getInventory().getContents()) {
                        if (is != null && is.getType() == Material.COAL) {
                            double coalamount = 0;

                            blockok += is.getAmount();
                            coalamount += is.getAmount() * 2;
                            something += coalamount;
                            price.put(p.getName(), something);
                        }
                    }

                    if(p.getInventory().contains(Material.COAL)) {
                        p.getInventory().remove(Material.COAL);
                        p.updateInventory();

                        Integer price2 = price.get(p.getName());
                        Integer price1 = price.get(p.getName());
                        int multiplier = files.getMultipliers().getInt("Multipliers." + p.getName() + ".Multiplier");
                        //if (p.hasPermission("blocksell.glitch")) price1 = price2 * 2;

                        int sellprice;
                        if (p.hasPermission("blocksell.glitch")) {
                            sellprice = price2 * multiplier + price1 * 2;
                        } else {
                            if (multiplier == 0) {
                                sellprice = price2;
                            } else {
                                sellprice = price2 * multiplier + price1;
                            }
                        }

                        p.sendMessage("§7Eladtál §c" + blockok + " §7szenet §c$" + sellprice + "§7-ért.");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + p.getName() + " " + sellprice);
                        // /GO <FATELEP, BÁNYA, SZÉNBÁNYA>
                        // SORREND: MINE , COALMINE, Lumber yard
                    } else {
                        p.sendMessage("§cNincsen nálad megfelelő block!");
                    }
                }
            }
        }
        return false;
    }
}