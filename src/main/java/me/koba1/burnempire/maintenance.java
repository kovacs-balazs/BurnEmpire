package me.koba1.burnempire;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class maintenance implements Listener, CommandExecutor {

    private Main m = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        boolean maintenance = m.getConfig().getBoolean("Maintenance." + "Maintenance");
        Player p = (Player) sender;
        if(sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("maintenance")) {
                if (maintenance == true) {
                    m.getServer().broadcastMessage("§8[§bKarbantartás§8] §aKarbantartás kikapcsolva");
                    m.getConfig().set("Maintenance." + "Maintenance", false);
                    m.getConfig().set("Maintenance." + "executed by", p.getName());
                    m.saveConfig();
                } else {
                    m.getServer().broadcastMessage("§8[§bKarbantartás§8] §cKarbantartás bekapcsolva");
                    m.getConfig().set("Maintenance." + "Maintenance", true);
                    m.getConfig().set("Maintenance." + "executed by", p.getName());
                    m.saveConfig();
                    Player[] players = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0]);
                    for (int i = 0; i < players.length; i++) {
                        if (!(players[i].hasPermission("maintenance.bypass"))) {
                            players[i].kickPlayer("§8[§bKarbantartás§8] §cKarbantartás folyik jelenleg a szerveren.");
                        }
                    }
                }
            }
        }
        return false;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        boolean maintenance = m.getConfig().getBoolean("Maintenance." + "Maintenance");
        Player p = e.getPlayer();
        if(maintenance == true) {
            Player[] players = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0]);
            for (int i = 0; i < players.length; i++) {
                if (!(players[i].hasPermission("maintenance.bypass"))) {
                    p.kickPlayer("§8[§bKarbantartás§8] §cKarbantartás folyik jelenleg a szerveren.");
                    m.getServer().broadcastMessage("§8[§bKarbantartás§8] §b" + e.getPlayer().getName() + "§7 megpróbált feljönni");
                } else {
                    // owww
                }
            }
        }
    }
}
