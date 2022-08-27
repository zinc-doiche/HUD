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
        if (Thirst.getThirst(id) > 0 && player != null) {
            if(runOrJump.isRunning(id)) {
                player.sendMessage("Running!!");
                amp += 1f;
            }
            if(runOrJump.isJumping(id)) {
                player.sendMessage("Jumping!!");
                amp += 1f;
            }
            Thirst.setThirst(id,Thirst.getThirst(id) - 0.1f*amp);
        }
        else Thirst.setThirst(id, 0);

        if(player != null) player.sendMessage("Thirst: "+Thirst.getThirst(id));
    }
}
