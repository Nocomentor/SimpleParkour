package com.pansebastian.simpleparkour.events;

import com.pansebastian.komunikaty.MalyKom;
import com.pansebastian.simpleparkour.ParkourManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.UUID;

public class SPEvents implements Listener {

    HashMap<UUID, Boolean> isOnPlateMap = new HashMap<>();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e)
    {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();

        isOnPlateMap.putIfAbsent(uuid, false);

        Material playerBlock = p.getLocation().getBlock().getType();

        Boolean isOnPlate = isOnPlateMap.get(uuid);

        if((playerBlock == Material.IRON_PLATE || playerBlock == Material.GOLD_PLATE) && !isOnPlate)
        {
            isOnPlateMap.put(uuid, true);
            ParkourManager.plateEntry(p);
            MalyKom.debug("na");
        }
        else if (!(playerBlock == Material.IRON_PLATE || playerBlock == Material.GOLD_PLATE) && isOnPlate)
        {
            isOnPlateMap.put(uuid, false);
            MalyKom.debug("nie na");
        }


    }

    @EventHandler
    public void PlayerQuitEvent(Player p)
    {
        //usuwanie sladu po graczu z ramu ugulnie

        UUID uuid = p.getUniqueId();
        MalyKom.debug(String.valueOf(uuid));
        isOnPlateMap.remove(uuid);
    }

}
