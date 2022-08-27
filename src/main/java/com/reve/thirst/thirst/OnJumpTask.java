package com.reve.thirst.thirst;

import com.reve.thirst.Main;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class OnJumpTask extends BukkitRunnable {
    Main plugin; UUID id;
    public static HashMap<UUID, Boolean> isjumping = new HashMap<>();
    public OnJumpTask(Main plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
    }
    public static boolean isJumping(UUID id){
        return isjumping.get(id);
    }
    @Override
    public void run() {

    }
}
