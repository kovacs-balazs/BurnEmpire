package me.koba1.burnempire;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.DisconnectEvent;
import net.dv8tion.jda.api.events.ShutdownEvent;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.apache.logging.log4j.message.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class discordbot extends ListenerAdapter implements Listener, CommandExecutor {
    public static Main plugin;
    public static JDA jda;
    public static String prefix;

    public discordbot(Main main) {
        this.plugin = main;
        prefix = "-";
        startBot();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        //jda.addEventListener(this);
    }

    private void startBot() {
        try {
            jda = new JDABuilder(AccountType.BOT).createDefault("NzkzODUxNzYxODA1NzU0Mzk4.X-ySEQ.RODogdVj0J_OEwWtwBrk-81yhAA").addEventListeners(this).build();
            jda.getPresence().setStatus(OnlineStatus.ONLINE);
            jda.getPresence().setActivity(Activity.watching("BurnEmpire szerverét"));
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public void dctimer() {
        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    boolean statusgetting = plugin.getConfig().getBoolean("Status.BurnEmpire");
                    boolean maintenancegetting = plugin.getConfig().getBoolean("Maintenance." + "Maintenance");

                    String status;
                    Locale locale = new Locale("hu", "HU");
                    DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
                    String date = dateFormat.format(new Date());
                    String maintenance;

                    if (statusgetting == true) {
                        status = ":white_check_mark: " + "Elérhető";
                    } else {
                        status = "Nem elérhető";
                    }
                    if (maintenancegetting == true) {
                        maintenance = "Bekapcsolva";
                    } else {
                        maintenance = "Kikapcsolva";
                    }
                    ArrayList list = new ArrayList();
                    for (Player onlinePlayers : plugin.getServer().getOnlinePlayers()) {
                        list.add(onlinePlayers.getName());
                    }
                    String stringlist = Arrays.toString(list.toArray()).replace('[', ' ').replace(']', ' ').replace(',', '\n').trim();
                    //int border1 = (int) Math.ceil(list.size() / 3F);
                    /*int border2 = (int) ((((list.size() - Math.ceil(list.size())) / 3) / 2) + Math.ceil(list.size() / 3));
                    border2 += 1;*/
                    /*int border2 = (int) Math.floor(list.size()) * 2;
                    System.out.println("border2");
                    String strlist1 = list.subList(0, border1).toString();
                    System.out.println("összes stringlist2");
                    String strlist2 = list.subList(border1, border2).toString();
                    System.out.println("összes stringlist3");
                    String strlist3 = list.subList(border2, list.size()).toString();
                    System.out.println("összes stringlist4");*/

                    int playersonline = plugin.getServer().getOnlinePlayers().size();
                    MessageChannel channel = jda.getTextChannelById("790739136881360917");
                    EmbedBuilder embed = new EmbedBuilder();

                    embed.setColor(Color.CYAN);
                    embed.setAuthor("BurnEmpire státusza", "https://i.imgur.com/LeGmjYM.png", "https://i.imgur.com/LeGmjYM.png");
                    embed.setDescription("**" + "Szerver információk:" + "**"
                            + "\nHa bármilyen problémád akadna olvasd át az <#768817038902427658> szobát. Ha még mindig nem kaptál a kérdésedre választ, akkor írj a <#802517674881449994> szobába. "
                            + "**" + "Jó játékot!" + "**" + "\n\n(Ha alul az idő kb. 30 másodperccel régebbi, akkor nagy eséllyel a szerver le van állítva)");

                    embed.addField("Szerver státusz:", status, true);
                    embed.addField("Szerver IP:", "burnempire.craft.run", true);
                    embed.addField("Játékosok:", playersonline + "/" + plugin.getServer().getMaxPlayers(), true);
                    embed.addField("Karbantartás:", maintenance, true);
                    embed.addField("Verzió:", "1.8-1.12.2", true);
                    embed.addField("Weboldalunk:", "burnempire.minemarket.hu", true);
                    embed.addField("", "", true);
                    embed.addField("", "", true);
                    embed.addField("", "", true);
                    embed.addField("Játékosok:", stringlist, true);
                    /*embed.addField("", strlist2, true);
                    embed.addField("", strlist3, true);*/
                    embed.setFooter("BurnEmpire • " + date, "https://i.imgur.com/LeGmjYM.png");
                    channel.editMessageById("802249767052771412", embed.build()).queue();
                } catch (Exception exception) {
                    // owwww
                }
            }
        }.runTaskTimer(plugin, 0, 100L);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("sendembed")) {
            if(sender.isOp()) {
                boolean statusgetting = plugin.getConfig().getBoolean("Status.BurnEmpire");
                String status;
                if(statusgetting == true) {
                    status = "Elérhető";
                } else {
                    status = "Nem elérhető";
                }
                ArrayList list = new ArrayList();
                for(Player onlinePlayers : plugin.getServer().getOnlinePlayers()) {
                    list.add(onlinePlayers.getName());
                }
                MessageChannel channel = jda.getTextChannelById("790739136881360917");
                EmbedBuilder embed = new EmbedBuilder();
                embed.setColor(Color.ORANGE);
                embed.setTitle("BurnEmpire");
                embed.setDescription("**" + "Szerver információk" + "**"
                        + "\nHa bármilyen problémád akadna olvasd át az 'INFO' kategóriát. Ha még mindig nem kaptál a kérdésedre választ, akkor írj a 'segítség' szobát. "
                        + "**" +  "Jó játékot!" + "**");
                embed.addField("Szerver státusz:", status, true);
                channel.sendMessage(embed.build()).queue();
            }
        }
        //
        else if(cmd.getName().equalsIgnoreCase("stop1")) {
            if(sender.isOp()) {
                shutdownedit();
                plugin.getServer().shutdown();
            }
        }
        return false;
    }

    /*@Override // USE THIS WHEN YOU WANT TO OVERRIDE A METHOD
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        try {
            String user = event.getMember().getAsMention();
            JDA client = event.getJDA(); // DO NOT CREATE A NEW JDA INSTANCE EVERY TIME
            TextChannel channel = client.getTextChannelById("801195246733885482");
            channel.sendMessage("New member joined: " + user).queue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    @EventHandler
    public void onChat(PlayerCommandPreprocessEvent e) {
        String[] args = e.getMessage().split(" ");
        if (args[0].equalsIgnoreCase("/stop")) {
            if (e.getPlayer().hasPermission("stop.stauts.update")) {
                if (e.getPlayer().isOp()) {
                    shutdownedit();
                    plugin.getServer().shutdown();
                }
            }
        }
    }

    public void shutdownedit() {
        Locale locale = new Locale("hu", "HU");
        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
        String date = dateFormat.format(new Date());
        MessageChannel channel = jda.getTextChannelById("790739136881360917");
        EmbedBuilder embed = new EmbedBuilder();

        embed.setColor(Color.CYAN);
        //embed.setTitle("BurnEmpire");
        embed.setAuthor("BurnEmpire státusza", "https://i.imgur.com/LeGmjYM.png", "https://i.imgur.com/LeGmjYM.png");
        embed.setDescription("**" + "Szerver információk:" + "**"
                + "\nHa bármilyen problémád akadna olvasd át az <#768817038902427658> szobát. Ha még mindig nem kaptál a kérdésedre választ, akkor írj a <#802517674881449994> szobába. "
                + "**" + "Jó játékot!" + "**" + "\n\n(Ha alul az idő kb. 30 másodperccel régebbi, akkor nagy eséllyel a szerver le van állítva)");

        embed.addField("Szerver státusz:", ":x: " + "Nem elérhető", true);
        embed.addField("Szerver IP:", "burnempire.craft.run", true);
        embed.addField("Weboldalunk:", "burnempire.minemarket.hu", true);
        embed.addField("", "", true);
        embed.addField("", "", true);
        embed.addField("Verzió:", "1.8-1.12.2", true);
        embed.addBlankField(true);

        embed.setFooter("BurnEmpire • " + date, "https://i.imgur.com/LeGmjYM.png");
        channel.editMessageById("802249767052771412", embed.build()).queue();
    }
}
