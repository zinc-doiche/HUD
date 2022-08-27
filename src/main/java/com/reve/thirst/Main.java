package com.reve.thirst;

import com.reve.thirst.thirst.ThirstListener;
import com.reve.thirst.thirstCommands.GetThirstCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {

        System.out.println("HW");
        ThirstListener listener = new ThirstListener(this);
        getServer().getPluginManager().registerEvents(listener, this);

        getCommand("getmythirst").setExecutor(new GetThirstCommand());
    }
}
