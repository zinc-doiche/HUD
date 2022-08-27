package com.reve.thirst.thirst;

import com.reve.thirst.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.HashMap;
import java.util.UUID;

public class JumpTask extends BukkitRunnable {
    Main plugin; UUID id;
    public static HashMap<UUID, Boolean> isjumping = new HashMap<>();
    public JumpTask(Main plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
        if (!isjumping.containsKey(id)) setIsJumping(id, false);
    }
    public boolean isJumping(UUID id){
        return isjumping.get(id);
    }
    public void setIsJumping(UUID id, boolean value){
        isjumping.put(id, value);
    }
    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);
        if (player != null && isJumping(id)) setIsJumping(id, false);

    }
}
