package com.reve.HUD.tasks.temperatureTasks;

import com.reve.HUD.HUDPlugin;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class PlayerTemperatureTask extends BukkitRunnable {

    private final HUDPlugin plugin;
    private final UUID id;
    private final HashMap<UUID, Boolean> isRunning = new HashMap<>();
    private TemperatureTask tempTask;
    public PlayerTemperatureTask(HUDPlugin plugin, UUID id) {
        this.plugin = plugin;
        this.id = id;
        tempTask = new TemperatureTask(plugin, id);
        if(!isRunning.containsKey(id)) isRunning.put(id, false);
    }
    @Override
    public void run() {
        if (isRunning()){
            tempTask.getTemperature();
        }
        setIsRunning(false);
    }
    public boolean isRunning(){
        return isRunning.get(id);
    }
    public void setIsRunning(boolean value) {
        isRunning.put(id, value);
    }
}
