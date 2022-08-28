package com.reve.HUD.tasks.temperatureTasks;

import com.reve.HUD.HUDPlugin;
import com.reve.HUD.huds.temperature.Temperature;
import com.reve.HUD.tasks.DamageTask;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class TemperatureTask extends BukkitRunnable {
    HUDPlugin plugin; UUID id;
    public TemperatureTask(HUDPlugin plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
    }
    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);
        if (player != null) {
            DamageTask damageTask = new DamageTask(plugin, id, 2d);
            double temp = Temperature.getTemperature(id);
            if (temp > 0d && temp < 4d) {
                damageTask.setIsRunning(id, false);
            } else {
                if (temp >= 4d) Temperature.setTemperature(id, 4d);
                if (temp <= 0d) Temperature.setTemperature(id, 0d);
                if(!damageTask.isRunning(id)) {
                    damageTask.setIsRunning(id, true);
                    damageTask.runTaskLater(plugin, 60L);
                }
            }

        }
    }
}
