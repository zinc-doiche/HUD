package com.reve.thirst.thirst;

import com.reve.thirst.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.HashMap;
import java.util.UUID;

public class RunOrJumpTask extends BukkitRunnable {
    Main plugin; UUID id;
    public static HashMap<UUID, Boolean> isrunning = new HashMap<>();
    public static HashMap<UUID, Boolean> isjumping = new HashMap<>();
    public RunOrJumpTask(Main plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
        if (!isrunning.containsKey(id)) setIsRunning(id, false);
        if (!isjumping.containsKey(id)) setIsJumping(id, false);
    }
    public boolean isRunning(UUID id){
        return isrunning.get(id);
    }
    public boolean isJumping(UUID id){
        return isjumping.get(id);
    }
    public void setIsRunning(UUID id, boolean value){
        isrunning.put(id, value);
    }
    public void setIsJumping(UUID id, boolean value){
        isjumping.put(id, value);
    }
    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);
        if (player != null) {
            if (!isRunning(id)) {
                setIsRunning(id, false);
                player.sendMessage("You've Stopped Running.");
            } else {
                setIsRunning(id, true);
                player.sendMessage("You're on Running.");
            }
            if (isJumping(id)) setIsJumping(id, false);
        }
    }
}
