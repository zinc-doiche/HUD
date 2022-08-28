package com.reve.HUD.tasks;

import com.reve.HUD.HUDPlugin;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.HashMap;
import java.util.UUID;
public class DamageTask extends BukkitRunnable {
    HUDPlugin plugin; UUID id; double damage;

    private static final HashMap<UUID, Boolean> isRunning = new HashMap<>();
    public DamageTask(HUDPlugin plugin, UUID id, double damage){
        this.plugin = plugin;
        this.id = id;
        this.damage = damage;
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
        if(player != null && isRunning(id)) player.damage(damage);
        setIsRunning(id, false);
    }
}