package com.reve.thirst.thirstTasks;

import com.reve.thirst.Main;
import com.reve.thirst.thirst.Thirst;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.HashMap;
import java.util.UUID;
public class ThirstDamageTask extends BukkitRunnable {
    Main plugin; UUID id; ThirstDamageTask task;

    private static final HashMap<UUID, Boolean> isRunning = new HashMap<>();
    public ThirstDamageTask(Main plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
        if(!isRunning.containsKey(id)) setIsRunning(id, false);
    }
    public boolean isRunning(UUID id){
        if(!isRunning.containsKey(id)) setIsRunning(id, false);
        return isRunning.get(id);
    }
    public void setIsRunning(UUID id, boolean value){
        isRunning.put(id, value);
    }
    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);
        if(player != null && isRunning(id)) player.damage(2d);
        setIsRunning(id, false);
    }
}