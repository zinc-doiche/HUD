package com.reve.thirst.thirstCommands;

import com.reve.thirst.thirst.Thirst;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetThirstCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player p = (Player) commandSender;
            p.sendMessage("Thirst: "+ Thirst.getThirst(p.getUniqueId()));
        }
        return true;
    }
}
