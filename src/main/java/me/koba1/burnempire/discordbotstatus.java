package me.koba1.burnempire;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.DisconnectEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class discordbotstatus extends ListenerAdapter implements Listener, CommandExecutor {
    public Main plugin;
    public JDA jda;

    public discordbotstatus(Main main) {
        this.plugin = main;
        startBot();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        jda.addEventListener(this);
    }

    private void startBot() {
        try {
            jda = new JDABuilder(AccountType.BOT).setToken("NzkzODUxNzYxODA1NzU0Mzk4.X-ySEQ.RODogdVj0J_OEwWtwBrk-81yhAA").build();
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
                    /*int thirdLength = (int) Math.ceil(list.size() / 3F);
                    int remainder = list.size() % 3;
                    String strlist1;
                    String strlist2;
                    String strlist3;
                    if (remainder == 1) {
                        strlist1 = list.subList(0, thirdLength + 1).toString();
                        strlist2 = list.subList(thirdLength + 1, thirdLength * 2).toString();
                        strlist3 = list.subList(thirdLength * 2, list.size()).toString();
                    } else if (remainder == 2) {
                        strlist1 = list.subList(0, thirdLength + 1).toString();
                        strlist2 = list.subList(thirdLength + 1, thirdLength * 2 + 1).toString();
                        strlist3 = list.subList(thirdLength * 2 + 1, list.size()).toString();
                    } else {
                        strlist1 = list.subList(0, thirdLength).toString();
                        strlist2 = list.subList(thirdLength, thirdLength * 2).toString();
                        strlist3 = list.subList(thirdLength * 2, list.size()).toString();
                    }*/

                    int playersonline = plugin.getServer().getOnlinePlayers().size();
                    MessageChannel channel = jda.getTextChannelById("790739136881360917");
                    EmbedBuilder embed = new EmbedBuilder();

                    embed.setColor(Color.CYAN);
                    embed.setAuthor("BurnEmpire státusza", "https://i.imgur.com/LeGmjYM.png", "https://i.imgur.com/LeGmjYM.png");
                    embed.setDescription("**" + "Szerver információk" + "**"
                            + "\nHa bármilyen problémád akadna olvasd át az 'INFO' kategóriát. Ha még mindig nem kaptál a kérdésedre választ, akkor írj a 'segítség' szobába. "
                            + "**" + "Jó játékot!" + "**");

                    embed.addField("Szerver státusz:", status, true);
                    embed.addField("Szerver IP:", "Majd itt lesz", true);
                    embed.addField("Játékosok:", playersonline + "/" + plugin.getServer().getMaxPlayers(), true);
                    embed.addField("", "", true);
                    embed.addField("Weboldalunk:", "burnempire.minemarket.hu", true);
                    embed.addField("Karbantartás:", maintenance, true);
                    embed.addField("Játékosok:", stringlist, true);
//                    if (list.size() >= 0) {
//                        embed.addField("Játékosok:", strlist1, true);
//                        embed.addField("", strlist2, true);
//                        embed.addField("", strlist3, true);
//                    } else {
//                        embed.addField("Játékosok:", stringlist, true);
//                    }
//                    }

                    embed.setFooter("BurnEmpire • " + date, "https://i.imgur.com/LeGmjYM.png");
                    channel.editMessageById("801912163287302185", embed.build()).queue();
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
        else if(cmd.getName().equalsIgnoreCase("tesztembed")) {
            int playersonline = plugin.getServer().getOnlinePlayers().size();
            sender.sendMessage(playersonline + "");
            ArrayList list = new ArrayList();
            for(Player onlinePlayers : plugin.getServer().getOnlinePlayers()) {
                list.add(onlinePlayers.getName());
            }
            String stringlist = Arrays.toString(list.toArray()).replace('[', ' ').replace(']', ' ').replace(',', ' ').trim();
            sender.sendMessage(stringlist + "");
        }
        return false;
    }

    public DisconnectEvent onDisconnect() {
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
        return null;
    }
}
