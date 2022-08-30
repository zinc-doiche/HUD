package com.reve.HUD.commands;

import com.reve.HUD.HUDPlugin;
import com.reve.HUD.huds.stamina.Stamina;
import com.reve.HUD.huds.temperature.Temperature;
import com.reve.HUD.huds.thirst.Thirst;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class GetHUDCommand implements CommandExecutor {
    HUDPlugin plugin;
    public GetHUDCommand(HUDPlugin plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            UUID id = player.getUniqueId();
            int HUDlevel = -31;
            String hud = "hud";
            Player name = null;
            if(strings.length == 1){
                hud = strings[0];
            }else if(strings.length == 2){
                name = plugin.getServer().getPlayer(strings[0]);
                hud = strings[1];
            }
            switch (hud){
                case "thirst": HUDlevel = (int) Math.ceil(Thirst.getThirst(id));
                    break;
                case "stamina": HUDlevel = (int) Math.ceil(Stamina.getStamina(id));
                    break;
                case "temperature": HUDlevel = (int) Math.ceil(Temperature.getTemperature(id));
                    break;
                default:
                    break;
            }
            if (HUDlevel == -31) player.sendMessage(ChatColor.RED+ "usage:/gethud <name> (thirst|stamina|temperature)");
            else {
                if(name != null) player.sendMessage(strings[0]+"`s "+hud+": "+HUDlevel);
                else player.sendMessage(hud+": "+HUDlevel);
            }
        }
        return true;
    }
}
