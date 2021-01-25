package me.koba1.burnempire;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.permissions.PermissionDefault;

import java.security.Permission;
import java.util.Objects;

public class killevent implements Listener {

    private Main m = Main.getPlugin(Main.class);

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Location loc = Objects.requireNonNull(p.getPlayer()).getLocation();
        if (p.getKiller() != null) {
            Player k = p.getKiller();
            Objects.requireNonNull(k.getPlayer()).playEffect(loc, Effect.MOBSPAWNER_FLAMES, 1);
            k.getPlayer().playSound(loc, Sound.BLOCK_NOTE_PLING, 1, 1);
//            String pUUID = p.getUniqueId().toString();
//            String kUUID = k.getUniqueId().toString();
            int kills = files.getKills().getInt("Players." + k.getName() + ".Kills");
            int deaths = files.getKills().getInt("Players." + p.getName() + ".Deaths");
            int killerstreak = files.getKills().getInt("Players." + k.getName() + ".Streak");
            int deathstreak = files.getKills().getInt("Players." + p.getName() + ".Streak");

            files.getKills().set("Players." + k.getName() + ".Kills", kills + 1);
            files.getKills().set("Players." + p.getName() + ".Deaths", deaths + 1);
            files.getKills().set("Players." + k.getName() + ".Streak", killerstreak + 1);
            files.saveKills();
            e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GRAY + " meghalt " + k.getName() + " által.");
            int money = 0;

            if(k.getPlayer().hasPermission("kill.default")) {
                money = 100;
            }
            //
            if(k.getPlayer().hasPermission("kill.nemes")) {
                money = 150;
            }
            //
            if(k.getPlayer().hasPermission("kill.mester")) {
                money = 200;
            }
            //
            if(k.getPlayer().hasPermission("kill.elit")) {
                money = 250;
            }
            //
            if(k.getPlayer().hasPermission("kill.veteran")) {
                money = 300;
            }
            //
            if(k.getPlayer().hasPermission("kill.glitch")) {
                money = 600;
            }
            //
            if(k.getPlayer().hasPermission("kill.youtuber")) {
                money = 650;
            }
            //
            if(killerstreak % 3 == 0 && killerstreak > 2) {
                money = money + 150;
            }
            //
            if(/*deathstreak % 3 == 0 &&*/ deathstreak > 2) {
                money = money + 150;
            }

            files.getKills().set("Players." + p.getName() + ".Streak", 0);
            files.saveKills();

            String balance = PlaceholderAPI.setPlaceholders(p.getPlayer(), "%vault_eco_balance_fixed%");

            int multiplier = files.getMultipliers().getInt("Multipliers." + k.getName() + ".Multiplier");
            int balance1 = Integer.parseInt(balance);

            if (balance1 >= 50) {
                if(files.getMultipliers().contains("Multipliers." + k.getName() + ".Multiplier")) {
                    if(multiplier == 0) {
                        // owww
                    } else {
                        money = money * multiplier;
                    }
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + k.getName() + " " + money);
                k.sendMessage("§7Megölted őt: " + ChatColor.AQUA + p.getName() + "§7. Kaptál §b$" + money + "§7-t.");

                p.sendMessage("§7Megölt téged: " + ChatColor.AQUA + k.getName() + "§7. Veszettél §b$50§7-t.");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco take " + p.getName() + " 50");
            } else {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + k.getName() + " " + money);
                k.sendMessage("§7Megölted őt: " + ChatColor.AQUA + p.getName() + "§7. Kaptál §b$" + money + "§7-t.");

                p.sendMessage("§7Megölt téged: " + ChatColor.AQUA + k.getName() + "§7. §cNincsen $50-od, ezért nem vesztettél pénzt!");
            }

            if (p.getAddress().getAddress().getHostAddress().equals(k.getAddress().getAddress().getHostAddress())) {
                p.getPlayer().sendMessage("§cNe farmolj saját karakteren.");
                k.getPlayer().sendMessage("§cNe farmolj saját karakteren.");
            } else {
                // owwww
            }
        }
    }
}
