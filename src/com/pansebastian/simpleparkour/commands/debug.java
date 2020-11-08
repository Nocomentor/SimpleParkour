package com.pansebastian.simpleparkour.commands;

import com.pansebastian.komunikaty.MalyKom;
import com.pansebastian.simpleparkour.ConfigManager;
import com.pansebastian.simpleparkour.ParkourManager;
import com.pansebastian.simpleparkour.objects.Parkour;
import com.pansebastian.simpleparkour.objects.ParkourPoint;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class debug implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(args[0].equals("display"))
        {
            displayParkours();
        }
        else if(args[0].equals("save"))
        {
            ConfigManager.saveParkours();
        }

        return true;
    }

    public static void displayParkours()
    {
        List<Parkour> parkourList = ParkourManager.getParkourList();

        for(Parkour p : parkourList)
        {
            MalyKom.debug(p.name);
            MalyKom.debug("&7" + p.length);
            for (ParkourPoint pp : p.pointsArr)
            {
                MalyKom.debug("&8" + pp.position + " { " + pp.X + ' ' + pp.Y + ' ' + pp.Z + " }");
            }
        }
    }
}
