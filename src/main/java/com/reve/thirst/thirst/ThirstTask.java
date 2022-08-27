package com.reve.thirst.thirst;

import com.reve.thirst.Main;
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
        float run = ThirstListener.run; float jump = ThirstListener.jump;
        if (Thirst.getThirst(id) > 0) Thirst.setThirst(id, (long) (Thirst.getThirst(id) - 0.5f*(1f+run+jump)) );
        else Thirst.setThirst(id, 0);
        System.out.println(Thirst.getThirst(id));
    }
}
