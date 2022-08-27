package com.reve.thirst.thirst;

import com.reve.thirst.Main;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class OnRunTask extends BukkitRunnable {
    Main plugin; UUID id;
    public static HashMap<UUID, Boolean> isrunning = new HashMap<>();

    public OnRunTask(Main plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
    }
    public static boolean isRunning(UUID id){
        return isrunning.get(id);
    }
    @Override
    public void run() {
    }
}
