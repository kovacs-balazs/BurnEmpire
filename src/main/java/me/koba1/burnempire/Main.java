package me.koba1.burnempire;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.security.Permission;
import java.text.DateFormat;
import java.util.*;
import java.util.List;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new killevent(), this);
        getServer().getPluginManager().registerEvents(new cmds(), this);
        getServer().getPluginManager().registerEvents(new blocksellcmds(), this);
        getServer().getPluginManager().registerEvents(new itemstacks(), this);
        getServer().getPluginManager().registerEvents(new interactevent(), this);
        getServer().getPluginManager().registerEvents(new lapisregen(), this);
        getServer().getPluginManager().registerEvents(new scoreboard(), this);
        getServer().getPluginManager().registerEvents(new pluginblocker(), this);
        getServer().getPluginManager().registerEvents(new timer(), this);
        getServer().getPluginManager().registerEvents(new youtubergui(), this);
        getServer().getPluginManager().registerEvents(new maintenance(), this);
        getServer().getPluginManager().registerEvents(new joinevents(), this);
        getServer().getPluginManager().registerEvents(new anvilregen(), this);
        getServer().getPluginManager().registerEvents(new minesteleports(), this);
        files.kills();
        files.dcbot();
        files.multipliers();
        files.getMultipliers().addDefault("asd", "asd");
        files.getMultipliers().options().copyDefaults(true);
        files.saveMultipliers();

        new discordbotstatus(this);
        new discordbotstatus(this).dctimer();
        new timer().timer();
        new scoreboard().scoreboardtimer();

        List<String> defa = new ArrayList<>();
        defa.add("&7arrow &bJelenleg nincsenek"); defa.add("&7arrow &bfrissítések a szerveren");

        getConfig().addDefault("Discord-link", "Place discord link here");
        getConfig().addDefault("Update", defa);
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        saveConfig();
        getConfig().set("Status.BurnEmpire", true);
        saveConfig();

        getCommand("sLeTR8cyvXkyGrxt").setExecutor(new blocksellcmds());
        getCommand("OADVNdig4J68f2Lf").setExecutor(new blocksellcmds());

        getCommand("stats").setExecutor(new cmds());
        getCommand("discord").setExecutor(new cmds());
        getCommand("burnempire").setExecutor(new cmds());
        getCommand("webshop").setExecutor(new cmds());
        getCommand("telkek").setExecutor(new cmds());
        getCommand("FIYBOTYJEUWOZ1W0").setExecutor(new cmds());
        getCommand("moneybooster").setExecutor(new cmds());
        getCommand("update").setExecutor(new cmds());
        getCommand("resetupdate").setExecutor(new cmds());
        getCommand("sbreload").setExecutor(new cmds());
        getCommand("ip").setExecutor(new cmds());
        getCommand("mention").setExecutor(new cmds());
        getCommand("crates").setExecutor(new cmds());
        getCommand("scoreboardmonitor").setExecutor(new cmds());
        getCommand("szabályzat").setExecutor(new cmds());
        getCommand("clearmultiplier").setExecutor(new cmds());

        getCommand("youtuber").setExecutor(new youtubergui());
        getCommand("helps").setExecutor(new pluginblocker());
        getCommand("maintenance").setExecutor(new maintenance());

        getCommand("silent").setExecutor(new joinevents());

        getCommand("mines1").setExecutor(new minesteleports());
        getCommand("go").setExecutor(new minesteleports());
        getCommand("pvparena").setExecutor(new minesteleports());

        getCommand("sendembed").setExecutor(new discordbotstatus(this));
        getCommand("tesztembed").setExecutor(new discordbotstatus(this));
        // SCOREBOARD RENDEZÉST MEGNÉZNI MERT ÁTÁLLÍTOTTAM
    }

    public JDA jda;
    @Override
    public void onDisable() {
        try {
            Locale locale = new Locale("hu", "HU");
            DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
            String date = dateFormat.format(new Date());
            MessageChannel channel = jda.getTextChannelById("790739136881360917");
            EmbedBuilder embed = new EmbedBuilder();

            embed.setColor(Color.CYAN);
            //embed.setTitle("BurnEmpire");
            embed.setAuthor("BurnEmpire státusza", "https://i.imgur.com/LeGmjYM.png", "https://i.imgur.com/LeGmjYM.png");
            embed.setDescription("**" + "Szerver információk" + "**"
                    + "\nHa bármilyen problémád akadna olvasd át az 'INFO' kategóriát. Ha még mindig nem kaptál a kérdésedre választ, akkor írj a 'segítség' szobába. "
                    + "**" + "Jó játékot!" + "**");

            embed.addField("Szerver státusz:", ":x: " + "Nem elérhető", true);
            embed.addField("Szerver IP:", "Majd itt lesz", true);
            embed.addField("Weboldalunk:", "burnempire.minemarket.hu", true);

            embed.setFooter("BurnEmpire • " + date, "https://i.imgur.com/LeGmjYM.png");
            channel.editMessageById("801912163287302185", embed.build()).queue();
        } catch (Exception exception) {
            // owww
        }
    }
}
