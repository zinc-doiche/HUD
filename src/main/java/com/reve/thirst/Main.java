package com.reve.thirst;

import com.reve.thirst.thirst.ThirstListener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {

        System.out.println("HW");
        ThirstListener listener = new ThirstListener(this);
        getServer().getPluginManager().registerEvents(listener, this);
    }
}
