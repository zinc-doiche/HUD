package com.reve.HUD;

import com.reve.HUD.commands.GetHUDCommand;
import com.reve.HUD.events.PlayerJumpEvent.*;
import com.reve.HUD.listeners.HUDListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class HUDPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("HW");
        getServer().getPluginManager().registerEvents(new HUDListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJumpEventListener(this), this);
        getCommand("gethud").setExecutor(new GetHUDCommand(this));
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
    @Override
    public void onDisable() {
    }
}
