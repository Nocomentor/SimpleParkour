package com.pansebastian.simpleparkour;

import com.pansebastian.simpleparkour.objects.Parkour;
import com.pansebastian.simpleparkour.objects.ParkourPoint;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

    public static Plugin plugin = SimpleParkour.getPlugin(SimpleParkour.class);

    private static void LoadConfig()
    {
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
    }

    public static void loadParkours()
    {
        LoadConfig();

        List<Parkour> parkourList = new ArrayList<>();

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

        ParkourManager.setParkourList(parkourList);
    }

    public static void saveParkours()
    {
        List<Parkour> parkourList = ParkourManager.getParkourList();

        String pathStart = "parkours.";

        for(Parkour p : parkourList)
        {
            String pathKey = p.name;

            for(ParkourPoint pp : p.pointsArr)
            {
                String path = pathStart + pathKey + "." + pp.position;
                plugin.getConfig().set(path + ".X", pp.X);
                plugin.getConfig().set(path + ".Y", pp.Y);
                plugin.getConfig().set(path + ".Z", pp.Z);
            }

        }
        plugin.saveConfig();
    }
}
