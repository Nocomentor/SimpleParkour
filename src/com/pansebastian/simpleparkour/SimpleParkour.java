package com.pansebastian.simpleparkour;

import com.pansebastian.simpleparkour.commands.debug;
import com.pansebastian.simpleparkour.events.SPEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleParkour extends JavaPlugin {

        @Override
        public void onEnable()
        {
            RegisterCommands();
            RegisterListeners();

            ConfigManager.loadParkours();

            getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "[SimpleParkour]: Pomyslnie zaladowano plugin");
        }

        @Override
        public void onDisable()
        {
            getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "[SimpleParkour]: Pomyslnie wylaczono plugin");
        }

        //own methods

        private void RegisterCommands()
        {
            getCommand("debug").setExecutor(new debug());
        }

        private void RegisterListeners()
        {
            getServer().getPluginManager().registerEvents(new SPEvents(), this);
        }

}


