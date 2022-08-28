package com.reve.thirst;

import com.reve.thirst.events.PlayerJumpEvent.*;
import com.reve.thirst.thirst.Thirst;
import com.reve.thirst.thirst.ThirstListener;
import com.reve.thirst.thirstCommands.GetThirstCommand;
import com.reve.thirst.thirstCommands.SaveThirstCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("HW");
        ThirstListener listener = new ThirstListener(this);
        PlayerJumpEventListener jumpListener = new PlayerJumpEventListener(this);

        getServer().getPluginManager().registerEvents(listener, this);
        getServer().getPluginManager().registerEvents(jumpListener, this);

        getCommand("getmythirst").setExecutor(new GetThirstCommand(this));
        getCommand("savethirst").setExecutor(new SaveThirstCommand(this));
    }
    @Override
    public void onDisable() {
        Thirst.saveThirst(this, Thirst.getThirst());
    }
}
