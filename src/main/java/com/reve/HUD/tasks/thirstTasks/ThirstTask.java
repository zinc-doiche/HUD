package com.reve.HUD.tasks.thirstTasks;

import com.reve.HUD.HUDPlugin;
import com.reve.HUD.huds.thirst.Thirst;
import com.reve.HUD.tasks.JumpTask;
import com.reve.HUD.tasks.RunTask;
import com.reve.HUD.tasks.DamageTask;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.UUID;

public class ThirstTask extends BukkitRunnable {
    HUDPlugin plugin; UUID id;
    public ThirstTask(HUDPlugin plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
    }
    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);
        float amp = 1f;
        JumpTask jump = new JumpTask(plugin, id);
        RunTask run = new RunTask(plugin, id);

        if (player != null) {
            DamageTask damageTask = new DamageTask(plugin, id,1d);
            //player.sendMessage("Run: " + run.isRunning(id));
            //player.sendMessage("Jump: " + jump.isJumping(id));
            if (Thirst.getThirst(id) > 0) {
                damageTask.setIsRunning(id, false);
                if (run.isRunning(id)) {
                    amp += 0.5f;
                }
                if (jump.isJumping(id)) {
                    amp += 0.5f;
                }
                Thirst.setThirst(id, Thirst.getThirst(id) - 0.025f * amp);
            } else {
                Thirst.setThirst(id, 0);
                if(!damageTask.isRunning(id)) {
                    damageTask.setIsRunning(id, true);
                    damageTask.runTaskLater(plugin, 60L);
                }
            }

        }
    }
}
