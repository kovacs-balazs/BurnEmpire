package me.koba1.burnempire;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class files {

    private static final Main m = Main.getPlugin(Main.class);

    private static File killscfg;
    private static FileConfiguration killsfile;

    public static Main burnempire = Main.getPlugin(Main.class);

    public static void kills() {
        killscfg = new File(burnempire.getDataFolder(), "kills.yml");

        if (!killscfg.exists()) {
            try {
                killscfg.createNewFile();
            } catch (IOException e) {
                //oowwww
            }
        }
        killsfile = YamlConfiguration.loadConfiguration(killscfg);
    }

    public static FileConfiguration getKills() {
        return killsfile;
    }

    public static void saveKills() {
        try {
            killsfile.save(killscfg);
        } catch (IOException e) {
            System.out.println("§cNem tudta menteni fájlt");
        }
    }

    public static void reloadKills() {
        killsfile = YamlConfiguration.loadConfiguration(killscfg);
    }

    // ----

    private static File multiplierscfg;
    private static FileConfiguration multipliersfile;

    public static Main burnempire2 = Main.getPlugin(Main.class);

    public static void multipliers() {
        multiplierscfg = new File(burnempire2.getDataFolder(), "multipliers.yml");

        if (!multiplierscfg.exists()) {
            try {
                multiplierscfg.createNewFile();
            } catch (IOException e) {
                //oowwww
            }
        }
        multipliersfile = YamlConfiguration.loadConfiguration(multiplierscfg);
    }

    public static FileConfiguration getMultipliers() {
        return multipliersfile;
    }

    public static void saveMultipliers() {
        try {
            multipliersfile.save(multiplierscfg);
        } catch (IOException e) {
            System.out.println("§cNem tudta menteni fájlt");
        }
    }

    public static void reloadMultipliers() {
        multipliersfile = YamlConfiguration.loadConfiguration(multiplierscfg);
    }


    // ----

    private static File dcbotcfg;
    private static FileConfiguration dcbotfile;

    public static Main plugin = Main.getPlugin(Main.class);

    public static void dcbot() {
        dcbotcfg = new File(plugin.getDataFolder(), "botconfig.yml");

        if (!dcbotcfg.exists()) {
            try {
                dcbotcfg.createNewFile();
            } catch (IOException e) {
                //oowwww
            }
        }
        dcbotfile = YamlConfiguration.loadConfiguration(dcbotcfg);
    }

    public static FileConfiguration getBot() {
        return dcbotfile;
    }

    public static void saveBot() {
        try {
            dcbotfile.save(dcbotcfg);
        } catch (IOException e) {
            System.out.println("§cNem tudta menteni fájlt");
        }
    }

    public static void reloadBot() {
        dcbotfile = YamlConfiguration.loadConfiguration(dcbotcfg);
    }
}