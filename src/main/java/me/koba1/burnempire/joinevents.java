package me.koba1.burnempire;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

public class joinevents implements Listener, CommandExecutor {

    private Main m = Main.getPlugin(Main.class);

    @EventHandler
    public void onJoinE(PlayerJoinEvent e) {
        Location spawn = new Location(m.getServer().getWorld("tgf"), (-633), 4, 144);
        e.getPlayer().teleport(spawn);
        Player[] players = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0]);
        Player p = e.getPlayer();
        boolean silent = m.getConfig().getBoolean("Join-Quit." + p.getName() + ".silent");
        if(m.getConfig().contains("Join-Quit." + p.getName())) {
            m.getConfig().set("Join-Quit." + p.getName() + ".silent", silent);
            m.saveConfig();
        } else {
            m.getConfig().set("Join-Quit." + p.getName() + ".silent", false);
            m.saveConfig();
        }
        //
        boolean maintenance = m.getConfig().getBoolean("Maintenance." + "Maintenance");
        for (int i = 0; i < players.length; i++) {
            if (maintenance == false) {
                if (silent == true) {
                    if (p.hasPermission("burnempire.silent.join")) {
                        if (players[i].hasPermission("burnempire.silent.join.notify")) {
                            players[i].sendMessage("§8[§e+§8] §b" + p.getName() + " §7felcsatlakozott a szerverre!");
                        } else {
                            // owwww
                        }
                    } else {
                        players[i].sendMessage("§8[§e+§8] §b" + p.getName() + " §7felcsatlakozott a szerverre!");
                    }
                }
                //
                else if (silent == false) {
                    players[i].sendMessage("§8[§e+§8] §b" + p.getName() + " §7felcsatlakozott a szerverre!");
                }
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        Player[] players = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0]);
        boolean silent = m.getConfig().getBoolean("Join-Quit." + p.getName() + ".silent");
        for (int i = 0; i < players.length; i++) {
            boolean maintenance = m.getConfig().getBoolean("Maintenance." + "Maintenance");
            if (maintenance == false) {
                if (silent == true) {
                    if (p.hasPermission("burnempire.silent.quit")) {
                        if (players[i].hasPermission("burnempire.silent.quit.notify")) {
                            players[i].sendMessage("§8[§c-§8] §b" + p.getName() + " §7lecsatlakozott a szerverről!");
                        } else {
                            // owwww
                        }
                    } else {
                        players[i].sendMessage("§8[§c-§8] §b" + p.getName() + " §7lecsatlakozott a szerverről!");
                    }
                }
                //
                else if (silent == false) {
                    players[i].sendMessage("§8[§c-§8] §b" + p.getName() + " §7lecsatlakozott a szerverről!");
                }
            } else {
                if (p.hasPermission("maintenance.bypass")) {
                    players[i].sendMessage("§8[§c-§8] §b" + p.getName() + " §7lecsatlakozott a szerverről!");
                }
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(sender instanceof Player) {
            if(args.length == 0) {
                if(cmd.getName().equalsIgnoreCase("silent")) {
                    if (p.hasPermission("burnempire.silent")) {
                        boolean silent = m.getConfig().getBoolean("Join-Quit." + p.getName() + ".silent");
                        if (silent == true) {
                            m.getConfig().set("Join-Quit." + p.getName() + ".silent", false);
                            m.saveConfig();
                            sender.sendMessage("§cSilent fellépés és kilépés kikapcsolva");
                        }
                        //
                        else if (silent == false) {
                            m.getConfig().set("Join-Quit." + p.getName() + ".silent", true);
                            m.saveConfig();
                            sender.sendMessage("§aSilent fellépés és kilépés belépés");
                        }
                    }
                }
            }
        }

        return false;
    }
}
