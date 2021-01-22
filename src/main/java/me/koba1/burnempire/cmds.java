package me.koba1.burnempire;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cmds implements Listener, CommandExecutor {

    private Main m = Main.getPlugin(Main.class);
    textcomponents tcs = new textcomponents();
    itemstacks items = new itemstacks();
    scoreboard sb = new scoreboard();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                if (cmd.getName().equalsIgnoreCase("stats")) {
                    Player t = (Player) sender;
                    Player player = (Player) sender;

                    int kills = files.getKills().getInt("Players." + t.getName() + ".Kills");
                    int deaths = files.getKills().getInt("Players." + t.getName() + ".Deaths");
                    double kills2 = files.getKills().getInt("Players." + t.getName() + ".Kills");
                    double deaths2 = files.getKills().getInt("Players." + t.getName() + ".Deaths");
                    double kdr = kills2 / deaths2;
                    if (deaths < 1) {
                        kdr = 0;
                    }

                    String replaced = PlaceholderAPI.setPlaceholders(player, "%vault_eco_balance_fixed%");
                    String replaced2 = PlaceholderAPI.setPlaceholders(player, "%server_time_HH:mm:ss%");
                    String replaced3 = PlaceholderAPI.setPlaceholders(player, "%server_time_yyyy.MM.dd%");
                    String replaced4 = PlaceholderAPI.setPlaceholders(player, "%playerpoints_points%");

                    sender.sendMessage(ChatColor.YELLOW + "+------------------------------------+");
                    sender.sendMessage(ChatColor.GRAY + "Pontjaid száma: " + ChatColor.AQUA + replaced4 + ChatColor.GRAY + " | XP szinted: " + ChatColor.AQUA + player.getLevel());
                    sender.sendMessage("");
                    sender.sendMessage(ChatColor.GRAY + "Idő: " + ChatColor.AQUA + replaced2 + ChatColor.GRAY + " | Dátum: " + ChatColor.AQUA + replaced3);
                    sender.sendMessage("");
                    sender.sendMessage(ChatColor.GRAY + "Pénzed: " + ChatColor.AQUA + "$" + replaced + ChatColor.GRAY + " | KDR: " + ChatColor.AQUA + kdr);
                    sender.sendMessage("");
                    sender.sendMessage(ChatColor.GRAY + "Öléseid száma: " + ChatColor.AQUA + kills + ChatColor.GRAY + " | Halálaid száma: " + ChatColor.AQUA + deaths);
                    sender.sendMessage(ChatColor.YELLOW + "+------------------------------------+");
                    return false;
                }
                //
                else if (cmd.getName().equalsIgnoreCase("FIYBOTYJEUWOZ1W0")) {
                    sender.sendMessage("§7 ---=== §bTelek segítségek §7===---");
                    sender.sendMessage("");
                    sender.spigot().sendMessage(tcs.auto());
                    sender.spigot().sendMessage(tcs.home());
                    sender.spigot().sendMessage(tcs.playeradd());
                    sender.spigot().sendMessage(tcs.playertrust());
                    sender.spigot().sendMessage(tcs.claim());
                    sender.spigot().sendMessage(tcs.clear());
                    sender.spigot().sendMessage(tcs.delete());
                    sender.spigot().sendMessage(tcs.setOwner());
                    sender.spigot().sendMessage(tcs.merge());
                    sender.spigot().sendMessage(tcs.unlink());
                    sender.spigot().sendMessage(tcs.toggles());
                    sender.spigot().sendMessage(tcs.setbime());
                    sender.sendMessage("");
                    sender.sendMessage("§7 ---=== §bTelek segítségek §7===---");
                }
                //
                else if (cmd.getName().equalsIgnoreCase("update")) {
                    List<String> messages = m.getConfig().getStringList("Update");
                    String message = "";
                    for (String m : messages) {
                        message += m;
                        message += "\n";
                    }
                    sender.sendMessage("§7§m+------§8§m------+§7§l [ §b§lFrissítések §7§l] §8§m+------§7§m------+");
                    sender.sendMessage("");
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message.replace("arrow", "➡ ")));
                    sender.sendMessage("");
                    sender.sendMessage("§7§m+------§8§m------+§7§l [ §b§lFrissítések §7§l] §8§m+------§7§m------+");
                }
                //
                else if (cmd.getName().equalsIgnoreCase("telkek")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "warp telkek " + p.getName());
                }
                //
                else if (cmd.getName().equalsIgnoreCase("crates")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "warp crates " + p.getName());
                }
                //
                else if (cmd.getName().equalsIgnoreCase("ip")) {
                    sender.sendMessage("§7Szerver ip: §bburnempire.craft.run");
                }
                //
                else if (cmd.getName().equalsIgnoreCase("mention")) {
                    sender.sendMessage("§7Ha az üzenetedbe bele írsz egy játékosnevet és elé írsz egy \"§b@§7\" §7jelet, akkor meg fogod jelölni az üzenetedben. " +
                            "Kapni fog egy értesítést, hogy megjelölted az üzenetedben.\n§7Példa: §fSzia §6@kbalu§f!");
                }
                //
                else if (cmd.getName().equalsIgnoreCase("burnempire")) {
                    sender.sendMessage("§7Plugint készítette: §bkbalu");
                    sender.sendMessage("");
                    sender.sendMessage("§7Parancsok:");
                    sender.sendMessage("§b/stats §7- Statisztikád megtekintése");
                    sender.sendMessage("§b/webshop §7- Webshop link");
                    sender.sendMessage("§b/stats §7- Statisztikád megtekintése");
                    sender.sendMessage("§b/discord §7- Discord szerverünk linkje");
                    if (p.isOp()) {
                        sender.sendMessage("§b/be reload§7- Config újratöltése");
                    }
                }
                //
                else if (cmd.getName().equalsIgnoreCase("discord")) {
                    String link = m.getConfig().getString("Discord-link");
                    sender.sendMessage("§7Discord szerverünk linkje: §b" + link);
                }
                //
                else if (cmd.getName().equalsIgnoreCase("resetupdate")) {
                    if (p.isOp()) {
                        ArrayList<String> list = new ArrayList();
                        list.add("&7arrow &bJelenleg nincsenek");
                        list.add("&7arrow &bfrissítések a szerveren");
                        m.getConfig().set("Update", list);
                        m.saveConfig();
                        sender.sendMessage("§aUpdate lista resetelve");
                    }
                }
                //
                else if (cmd.getName().equalsIgnoreCase("webshop")) {
                    sender.sendMessage("§7Webshopunk linkje:§b http://burnempire.minemarket.hu/");
                }
                //
                else if (cmd.getName().equalsIgnoreCase("clearmultiplier")) {
                    files.getMultipliers().set("Multipliers." + sender.getName() + ".MultiplierTime", 0);
                    files.saveMultipliers();
                }
                //
                else if (cmd.getName().equalsIgnoreCase("szabályzat")) {
                    p.performCommand("/rules");
                }
                //
                else if (cmd.getName().equalsIgnoreCase("sbreload")) {
                    if (p.isOp()) {
                        sb.scoreboardtimer();
                    }
                }
                //
                else if (cmd.getName().equalsIgnoreCase("moneybooster")) {
                    if (p.isOp()) {
                        p.getInventory().addItem(items.twoxmoney());
                    }
                }
            }
            //
            else if (args.length == 1) {
                if (p.isOp()) {
                    if (cmd.getName().equalsIgnoreCase("moneybooster")) {
                        p.getInventory().addItem(items.twoxmoney());
                    }
                }
                //
                if (cmd.getName().equalsIgnoreCase("burnempire")) {
                    if (args[0].equalsIgnoreCase("reload")) {
                        m.reloadConfig();
                        files.reloadKills();
                        files.reloadMultipliers();
                        sender.sendMessage("§aConfig, kills.yml és multipliers.yml fájl sikeresen újratöltve");
                    }
                }
            }
            //
            else if (args.length == 2) {
                if (p.isOp()) {
                    if (cmd.getName().equalsIgnoreCase("moneybooster")) {
                        Player target = m.getServer().getPlayer(args[0]);
                        int args1 = Integer.parseInt(args[1]);
                        ItemStack is = items.twoxmoney();
                        is.setAmount(args1);
                        target.getInventory().addItem(is);
                    }
                }
            }
        }
        //
        else if(sender instanceof ConsoleCommandSender) {
            if (args.length == 2) {
                if (cmd.getName().equalsIgnoreCase("moneybooster")) {
                    Player target = m.getServer().getPlayer(args[0]);
                    int args1 = Integer.parseInt(args[1]);
                    ItemStack is = items.twoxmoney();
                    is.setAmount(args1);
                    target.getInventory().addItem(is);
                }
            }
        }
        return false;
    }
}