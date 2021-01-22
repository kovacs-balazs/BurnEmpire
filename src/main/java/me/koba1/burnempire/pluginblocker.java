package me.koba1.burnempire;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class pluginblocker implements Listener, CommandExecutor {

    textcomponents comps = new textcomponents();

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)  {
        String[] args = event.getMessage().split(" ");
        String message = event.getMessage();
        message.split(" ")[0].substring(1);
        if(args.length >= 0) {
            if (args[0].equalsIgnoreCase("/pl") || args[0].equalsIgnoreCase("/plugins")
                    || args[0].equalsIgnoreCase("/ver") || args[0].equalsIgnoreCase("/version")
                    || args[0].equalsIgnoreCase("/about") || args[0].equalsIgnoreCase("/icanhasbukkit")
                    || args[0].equalsIgnoreCase("/minecraft:help") || args[0].equalsIgnoreCase("/bukkit:pl")
                    || args[0].equalsIgnoreCase("/bukkit:plugins") || args[0].equalsIgnoreCase("/bukkit:about")
                    || args[0].equalsIgnoreCase("/bukkit:ver") || args[0].equalsIgnoreCase("/bukkit:version")
                    || args[0].equalsIgnoreCase("/minecraft:me")) {
                if (!event.getPlayer().isOp()) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage("§fPlugins (7): §aBurnPrefixes§f, §aBurnKills§f, §aBurnSell§f, §aBurnScorebaord" +
                            "§f, §aBurnEmpire§f, §aBurnMaintenance§f, §aBurnYoutube");
                }
            }
            //
            else if (args[0].equalsIgnoreCase("plotme") || args[0].equalsIgnoreCase("plot")
                    || args[0].equalsIgnoreCase("plotsquared") || args[0].equalsIgnoreCase("plots")
                    || args[0].equalsIgnoreCase("p") || args[0].equalsIgnoreCase("2")
                    || args[0].equalsIgnoreCase("ps") || args[0].equalsIgnoreCase("p2")) {
                //if (!(event.getPlayer().getWorld().getName().equalsIgnoreCase("plots"))) {
                //event.getPlayer().sendMessage(args[0] + "");
                if (!(event.getPlayer().isOp())) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage("§cEzt ebben a világban nem használhatod! Használd: /telkek");
                }
                //}
            }
        }
        if(args.length >= 0) {
            if (event.getMessage().startsWith("/op")) {
                event.setCancelled(true);
                event.getPlayer().sendMessage("§cEzt csak consoleból tudod lefuttatni.");
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("helps")) {
            if (args.length == 0) {
                helps1msg(p);
            }
            //
            else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("1")) {
                    helps1msg(p);
                }
                //
                else if (args[0].equalsIgnoreCase("2")) {
                    helps2msg(p);
                }
            }
        }
        return false;
    }

    public void helps1msg(Player sender) {
        sender.sendMessage("§7§m+------§8§m------+§7§l [ §b§lSegítség §7§l] §8§m+------§7§m------+");
        sender.sendMessage("");
        sender.sendMessage("§b/discord §7- Discord link");
        sender.sendMessage("§b/webshop §7- Webshop link");
        sender.sendMessage("§b/stats §7- Statisztikád megnézése");
        sender.sendMessage("§b/update §7- Legutóbbi update megnézése");
        sender.sendMessage("§b/telkek §7- Telek világ elérése");
        sender.sendMessage("§b/tptoggle §7- Teleportálás letiltása");
        sender.sendMessage("§b/ignore <játékos név> §7- Játékos ignorálása");
        sender.sendMessage("§b/shop §7- Bolt megnyitása");
        sender.sendMessage("§b/menu §7- Menü elérése");
        sender.sendMessage("§b/rang §7- Rangok megnézése");
        sender.sendMessage("");
        sender.spigot().sendMessage(comps.nexthelp1());
    }

    public void helps2msg(Player sender) {
        sender.sendMessage("§7§m+------§8§m------+§7§l [ §b§lSegítség §7§l] §8§m+------§7§m------+");
        sender.sendMessage("");
        sender.sendMessage("§b/rules §7- Játékszabályzat");
        sender.sendMessage("§b/crates §7- Ládához eljutás");
        sender.sendMessage("§b/report §7- Játékos jelentése");
        sender.sendMessage("§b/realname <név> §7- Játékos igazi neve");
        sender.sendMessage("§b/mines §7- Bánya menü");
        sender.sendMessage("§b/go §7- Bányákhoz eljutás");
        sender.sendMessage("§b/mention §7- Játékos megjelölése");
        sender.sendMessage("§b/prefix §7- Egyedi előtagok (Elit rangtól)");
        sender.sendMessage("§b/youtuber §7- Youtuber rang információk");
        sender.sendMessage("§b/ip §7- Szerver IP");
        sender.sendMessage("");
        sender.spigot().sendMessage(comps.nexthelp2());
    }
}
