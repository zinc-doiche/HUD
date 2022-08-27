package com.reve.thirst.thirst;

import com.reve.thirst.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.UUID;

public class ThirstTask extends BukkitRunnable {
    Main plugin; UUID id;
    public ThirstTask(Main plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
    }
    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);
        float amp = 1f;
        RunOrJumpTask runOrJump = new RunOrJumpTask(plugin, id);
        if (Thirst.getThirst(id) > 0) {
            if(runOrJump.isRunning(id)) amp += 0.3f;
            if(runOrJump.isJumping(id)) amp += 0.3f;
            Thirst.setThirst(id,Thirst.getThirst(id) - 0.1f*amp);
        }
        else Thirst.setThirst(id, 0);

        if(player != null) player.sendMessage("Thirst: "+Thirst.getThirst(id));
    }
}
