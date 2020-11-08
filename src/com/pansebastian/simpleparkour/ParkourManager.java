package com.pansebastian.simpleparkour;

import com.pansebastian.simpleparkour.objects.Parkour;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ParkourManager {

    private static List<Parkour> parkourList = new ArrayList<>();

    public static void plateEntry(Player player)
    {

    }

    public static List<Parkour> getParkourList()
    {
        return parkourList;
    }

    public static void setParkourList(List<Parkour> sentParkourList)
    {
        parkourList = sentParkourList;
    }

}
