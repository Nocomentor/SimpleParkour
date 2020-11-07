package com.pansebastian.simpleparkour;

import com.pansebastian.komunikaty.MalyKom;
import com.pansebastian.simpleparkour.objects.Parkour;
import com.pansebastian.simpleparkour.objects.ParkourPoint;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class ParkourManager {

    public static Plugin plugin = SimpleParkour.getPlugin(SimpleParkour.class);

    public static List<Parkour> parkourList = new ArrayList<>();

    public static void plateEntry(Player player)
    {

    }

    public static void loadParkours()
    {
        ConfigurationSection parkoursSection = plugin.getConfig().getConfigurationSection("parkours");

        for (String key : parkoursSection.getKeys(false)) {

            List<ParkourPoint> parkourPoints = new ArrayList<>();

            ConfigurationSection elementSection = plugin.getConfig().getConfigurationSection("parkours." + key);

            for (String element : elementSection.getKeys(false)) {

                String path = "parkours." + key + "." + element;

                int X = plugin.getConfig().getInt(path + ".X");
                int Y = plugin.getConfig().getInt(path + ".Y");
                int Z = plugin.getConfig().getInt(path + ".Z");

                ParkourPoint pp = new ParkourPoint(X, Y, Z, Integer.parseInt(element));
                parkourPoints.add(pp);

            }

            Parkour p = new Parkour(parkourPoints, key);
            parkourList.add(p);
        }
    }
}
