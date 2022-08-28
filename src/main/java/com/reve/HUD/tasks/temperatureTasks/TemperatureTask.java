package com.reve.HUD.tasks.temperatureTasks;

import com.reve.HUD.HUDPlugin;
import com.reve.HUD.huds.temperature.Temperature;
import com.reve.HUD.tasks.DamageTask;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class TemperatureTask extends BukkitRunnable {
    HUDPlugin plugin; UUID id; Double temperature = 0d;

    public TemperatureTask(HUDPlugin plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
    }
    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);
        if (player != null) {
            double x = player.getLocation().getX();
            double y = player.getLocation().getY();
            double z = player.getLocation().getZ();
            temperature = plugin.getServer().getWorld(id).getTemperature((int)x,(int)y,(int)z);
            player.sendMessage(temperature.toString());
            DamageTask damageTask = new DamageTask(plugin, id, 3d);
            double playerTemp = Temperature.getTemperature(id);
            if (playerTemp > 0d && playerTemp < 20d) {
                damageTask.setIsRunning(id, false);
            } else {
                if (playerTemp >= 20d) Temperature.setTemperature(id, 20d);
                if (playerTemp <= 0d) Temperature.setTemperature(id, 0d);
                if(!damageTask.isRunning(id)) {
                    damageTask.setIsRunning(id, true);
                    damageTask.runTaskLater(plugin, 60L);
                }
            }

        }
    }
}
