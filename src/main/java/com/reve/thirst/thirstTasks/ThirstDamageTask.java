package com.reve.thirst.thirstTasks;

import com.reve.thirst.Main;
import com.reve.thirst.thirst.Thirst;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class ThirstDamageTask extends BukkitRunnable {
    Main plugin; UUID id;
    HashMap<UUID, Boolean> isCooldown = new HashMap<>();
    public ThirstDamageTask(Main plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
        if(isCooldown.containsKey(id)) setIsCooldown(id, false);
    }

    public void setIsCooldown(UUID id, boolean value) {
        isCooldown.put(id, value);
    }

    public boolean isCooldown(UUID id){
        return isCooldown.get(id);
    }
    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);
        if (player != null  && Thirst.getThirst(id) == 0) player.damage(2d);
        setIsCooldown(id, false);
    }
}