package com.reve.thirst.thirstTasks;

import com.reve.thirst.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class ThirstDamageTask extends BukkitRunnable {
    Main plugin; UUID id;
    public ThirstDamageTask(Main plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
    }
    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);
        if (player != null) player.damage(2d);
    }
}