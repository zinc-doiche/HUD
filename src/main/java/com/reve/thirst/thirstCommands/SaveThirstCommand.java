package com.reve.thirst.thirstCommands;

import com.reve.thirst.Main;
import com.reve.thirst.thirst.Thirst;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SaveThirstCommand implements CommandExecutor {
    Main plugin;
    public SaveThirstCommand(Main plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Thirst.saveThirst(plugin, Thirst.getThirst());
        return true;
    }
}
