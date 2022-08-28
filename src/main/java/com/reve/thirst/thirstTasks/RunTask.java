package com.reve.thirst.thirstTasks;

import com.reve.thirst.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class RunTask extends BukkitRunnable {
    Main plugin; UUID id;
    private static final HashMap<UUID, Boolean> isrunning = new HashMap<>();
    public RunTask(Main plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
        if (!isrunning.containsKey(id)) setIsRunning(id, false);
    }
    public boolean isRunning(UUID id){
        return isrunning.get(id);
    }
    public void setIsRunning(UUID id, boolean value){
        isrunning.put(id, value);
    }
    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);
        if (player != null) {
            if (isRunning(id)) {
                setIsRunning(id, false);
                //player.sendMessage("You've Stopped Running.");
            } else {
                setIsRunning(id, true);
                //player.sendMessage("You're on Running.");
            }
        }
    }
}
