package me.koba1.burnempire;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class events implements Listener, CommandExecutor {

    private Main m = Main.getPlugin(Main.class);

    @EventHandler
    public void onDmg(EntityDamageEvent e) {
        Player p = (Player) e.getEntity();
        if (e.getEntity() instanceof Player) {
            double x = p.getLocation().getX();
            double z = p.getLocation().getZ();
            if (x >= 647 && x <= 697 && z >= 629 && z <= 636) {
                int section = files.getEvent().getInt("Events.JumpEvent." + p.getName() + ".section");
                e.setCancelled(true);
                if (section == 1 || files.getEvent().getString("Events.JumpEvent." + p.getName()) == null) {
                    Location loc = new Location(m.getServer().getWorld("event"), 644, 14, 632, (-90), 0);
                    p.teleport(loc);
                }
                //
                else if (section == 2) {
                    Location loc = new Location(m.getServer().getWorld("event"), 674, 14, 632, (-90), 0);
                    p.teleport(loc);
                }
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction().equals(Action.PHYSICAL)) {
            double x = e.getClickedBlock().getX();
            double z = e.getClickedBlock().getZ();
            if (e.getClickedBlock().getType() == Material.GOLD_PLATE) {
                if (x >= 673 && x <= 675 && z >= 629 && z <= 635) {
                    files.getEvent().set("Events.JumpEvent." + p.getName() + ".section", 2);
                    files.saveEvent();
                }
                //
                else if (x == 699 && z == 632) {
                    files.getEvent().set("Events.JumpEvent." + p.getName() + ".section", 1);
                    files.saveEvent();
                    m.getServer().broadcastMessage("§b§oBurn§7§oEmpire §8» §bA §ljump eventet §bnyerte: §3§l" + e.getPlayer().getName() + "§b. Nyereménye: §3§l$30.000");
                    m.getServer().dispatchCommand(m.getServer().getConsoleSender(), "eco give " + e.getPlayer().getName() + " 30000");
                    if (!(p.isOp())) {
                        Location loc = new Location(m.getServer().getWorld("tgf"), (-633), 4, 144, (-90), 0);
                        p.teleport(loc);
                        m.getServer().broadcastMessage("§b§oBurn§7§oEmpire §8» §aAz eventnek vége. Mindenki teleportálva lett a spawnra.");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInvEvent(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§c§lJump Event")) {
            e.setCancelled(true);
            if (e.getSlot() == 0) {
                Bukkit.broadcastMessage("§b§oBurn§7§oEmpire §8» §b§lJump event §blesz. Írjátok be: §b§l/event jump");
            }
            //
            else if (e.getSlot() == 2) {
                countdownstart();
            }
            //
            else if (e.getSlot() == 20) {
                closejump();
                p.sendMessage("§cAz event kapuját bezártad.");
            }
            //
            else if (e.getSlot() == 21) {
                startjump();
                p.sendMessage("§aKinyitottad az event kapuját.");
            }
            //
            else if (e.getSlot() == 18) {
                resetconfig();
                p.sendMessage("§aSpawnpointok resetelve lettek.");
            }
            //
            else if (e.getSlot() == 25) {
                tpjump(p);
                p.sendMessage("§6El lettél teleportálva az eventre.");
            }
            //
            else if (e.getSlot() == 26) {
                resetconfig();
                closejump();
                spawntp(p);
                p.sendMessage("§aEvent resetelve! §7SpawnTP, spawnpoint, door.");
            }
        }
    }

    public Inventory jumpinv() {
        Inventory inv = Bukkit.createInventory(null, 3 * 9, "§c§lJump Event");
        inv.setItem(0, ad());
        inv.setItem(2, start());
        inv.setItem(20, close());
        inv.setItem(21, open());
        inv.setItem(18, reset());
        inv.setItem(26, fullreset());
        inv.setItem(25, tpjump());
        return inv;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("jumpevent")) {
            if (sender.isOp()) {
                p.openInventory(jumpinv());
            }
        }
        return false;
    }

    public void resetconfig() {
        for (String str : files.getEvent().getConfigurationSection("Events.JumpEvent").getKeys(false)) {
            files.getEvent().set("Events.JumpEvent." + str + ".section", 1);
            files.saveEvent();
        }
    }

    public void startjump() {
        double y = 14; // max: 17
        double z = 630; // max: 634
        for (z = 630; z <= 634; z++) {
            for (y = 14; y <= 16; y++) {
                Location loc = new Location(m.getServer().getWorld("event"), 647, y, z);
                Block block = loc.getBlock();
                block.setType(Material.AIR);
            }
        }
    }

    public void closejump() {
        double y = 14; // max: 17
        double z = 630; // max: 634
        for (z = 630; z <= 634; z++) {
            for (y = 14; y <= 16; y++) {
                Location loc = new Location(m.getServer().getWorld("event"), 647, y, z);
                Block block = loc.getBlock();
                block.setType(Material.GLASS);
            }
        }
    }

    public void countdownstart() {
        new BukkitRunnable() {
            int time = 5;

            @Override
            public void run() {
                Bukkit.broadcastMessage("§b§oBurn§7§oEmpire §8» §aAz event indul: §4§l" + time);
                time -= 1;
                if (time == 0) {
                    startjump();
                    Bukkit.broadcastMessage("§b§oBurn§7§oEmpire §8» §cAz event elindult!");
                    cancel();
                }
            }
        }.runTaskTimer(m, 0L, 20L);
    }

    public ItemStack ad() {
        ItemStack is = new ItemStack(Material.PAPER);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§cHirdető");
        is.setItemMeta(im);
        return is;
    }

    public ItemStack reset() {
        ItemStack is = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§5Spawnpoint resetelése");
        is.setItemMeta(im);
        return is;
    }

    public ItemStack start() {
        ItemStack is = new ItemStack(Material.WOOL, 1, (byte) 5);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§aIndítás (5s)");
        is.setItemMeta(im);
        return is;
    }

    public ItemStack close() {
        ItemStack is = new ItemStack(Material.WOOL, 1, (byte) 14);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§cBezárás");
        is.setItemMeta(im);
        return is;
    }

    public ItemStack open() {
        ItemStack is = new ItemStack(Material.WOOL, 1, (byte) 5);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§aKinyitás");
        is.setItemMeta(im);
        return is;
    }

    public ItemStack tpjump() {
        ItemStack is = new ItemStack(Material.INK_SACK, 1, (byte) 14);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§6Teleportálás az eventhez");
        is.setItemMeta(im);
        return is;
    }

    public ItemStack fullreset() {
        ItemStack is = new ItemStack(Material.INK_SACK, 1, (byte) 1);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§cFull reset");
        ArrayList lore = new ArrayList();
        lore.add("§7Reset: kapu, spawnpointok, mindenki tp spawnra");
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }

    public void tpjump(Player p) {
        Location loc = new Location(m.getServer().getWorld("event"), 643, 14, 632, (-90), 0);
        p.teleport(loc);
    }

    public void spawntp(Player p) {
        if(!(p.isOp())) {
            Location loc = new Location(m.getServer().getWorld("tgf"), (-633), 4, 144, (-90), 0);
            p.teleport(loc);
        } else {
            // owww
        }
    }
}
