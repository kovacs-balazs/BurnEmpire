package me.koba1.burnempire;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.material.PressurePlate;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class scoreboard implements Listener {

    private Main m = Main.getPlugin(Main.class);
    interactevent ie = new interactevent();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        m.getConfig().set("Scoreboard." + e.getPlayer().getName() + ".scoreboard", "default");
        m.getConfig().set("Scoreboard." + e.getPlayer().getName() + ".name", e.getPlayer().getName());
        m.saveConfig();
        scoreboardtimer();
    }

    public void scoreboardtimer() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : m.getServer().getOnlinePlayers()) {
                    if (p == null) {
                        this.cancel();
                    } else {
                        String scoreboard = m.getConfig().getString("Scoreboard." + p.getName() + ".scoreboard");
                        ScoreboardManager sm = m.getServer().getScoreboardManager();
                        Scoreboard b = sm.getNewScoreboard();

                        Objective o = b.registerNewObjective("Minden", "is");
                        o.setDisplaySlot(DisplaySlot.SIDEBAR);
                        o.setDisplayName("§b§oBurn§7§oEmpire");

                        String moneyplaceholder = PlaceholderAPI.setPlaceholders(p, "%vault_eco_balance_fixed%");
                        String playersonline = PlaceholderAPI.setPlaceholders(p, "%server_online%");
                        String playermax = PlaceholderAPI.setPlaceholders(p, "%server_max_players%");
                        int sellandkillmoneyboostexpire = files.getMultipliers().getInt("Multipliers." + p.getName() + ".MultiplierTime");
                        int sellandkillmoneybooster = files.getMultipliers().getInt("Multipliers." + p.getName() + ".Multiplier");

                        int p1 = sellandkillmoneyboostexpire % 60; // MÁSODPERC
                        int p2 = sellandkillmoneyboostexpire / 60; // ÓRA
                        int p3 = p2 % 60; // PERC
                        p2 = p2 / 60;

                        String lejarat = "something";
                        if (p2 > 0 && p3 > 0) lejarat = p2 + "h " + p3 + "m";
                        if (p3 == 0 && p2 > 0) lejarat = p2 + "h";
                        if (p3 == 0 && p2 == 0) lejarat = p1 + "s";
                        if (p1 == 0 && p2 == 0) lejarat = p3 + "m";
                        if (p3 > 0 && p2 == 0 && p1 > 0) lejarat = p3 + "m " + p1 + "s";

                        Score s1 = o.getScore(ChatColor.RED + " ");
                        Score s2 = o.getScore(ChatColor.AQUA + "§l» " + ChatColor.GRAY + "Pénzed:");
                        Score s3 = o.getScore(ChatColor.GRAY + "[" + ChatColor.AQUA + "§l$" + ChatColor.GRAY + "] " + ChatColor.AQUA + "$" + moneyplaceholder);
                        Score s4 = o.getScore(ChatColor.RED + "  ");
                        Score s5 = o.getScore("§b§l» §7Játékosok:");
                        Score s6 = o.getScore("§b" + playersonline + " §7/ §b" + playermax);
                        Score s7 = o.getScore("   ");
                        Score s8 = o.getScore("§b§l» §7Szorzó:");
                        Score s9 = o.getScore("§b" + sellandkillmoneybooster + "x§7 | Lejárat: " + ChatColor.AQUA + lejarat);
                        Score s10 = o.getScore("    ");
                        Score s11 = o.getScore("§b§l» §7Menü:");
                        Score s12 = o.getScore("§b/menu");
                        Score s13 = o.getScore("     ");
                        Score s14 = o.getScore("§b§l» §7Silent:");
                        Score s15 = o.getScore("§bBekapcsolva");
                        s1.setScore(9);
                        s2.setScore(8);
                        s3.setScore(7);
                        s4.setScore(6);
                        s5.setScore(5);
                        s6.setScore(4);
                        s7.setScore(3);
                        s11.setScore(2);
                        s12.setScore(1);
                        boolean silent = m.getConfig().getBoolean("Join-Quit." + p.getName() + ".silent");
                        if (sellandkillmoneyboostexpire > 0 && sellandkillmoneybooster > 0 && silent == true) {
                            s1.setScore(16);
                            s2.setScore(15);
                            s3.setScore(14);
                            s4.setScore(13);
                            s5.setScore(12);
                            s6.setScore(11);
                            s7.setScore(10);
                            s8.setScore(9);
                            s9.setScore(8);
                            s10.setScore(7);
                            s11.setScore(5);
                            s12.setScore(4);
                            s13.setScore(3);
                            s14.setScore(2);
                            s15.setScore(1);
                        }
                        //
                        else if(silent == true) {
                            s1.setScore(13);
                            s2.setScore(12);
                            s3.setScore(11);
                            s4.setScore(10);
                            s5.setScore(9);
                            s6.setScore(8);
                            s7.setScore(7);
                            s11.setScore(5);
                            s12.setScore(4);
                            s13.setScore(3);
                            s14.setScore(2);
                            s15.setScore(1);
                        }
                        //
                        else if(sellandkillmoneyboostexpire > 0 && sellandkillmoneybooster > 0) {
                            s1.setScore(12);
                            s2.setScore(11);
                            s3.setScore(10);
                            s4.setScore(9);
                            s5.setScore(8);
                            s6.setScore(7);
                            s7.setScore(6);
                            s8.setScore(5);
                            s9.setScore(4);
                            s10.setScore(3);
                            s11.setScore(2);
                            s12.setScore(1);
                        }
                        p.setScoreboard(b);
                    }
                }
            }
        }.runTaskTimer(m, 0, 20L);
    }
}
