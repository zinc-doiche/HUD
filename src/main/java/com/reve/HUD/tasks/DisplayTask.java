package com.reve.HUD.tasks;

import com.reve.HUD.HUDPlugin;
import com.reve.HUD.huds.stamina.Stamina;
import com.reve.HUD.huds.thirst.Thirst;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class DisplayTask extends BukkitRunnable {
    private final HUDPlugin plugin;
    private final UUID id;
    public DisplayTask (HUDPlugin plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
    }
    private boolean isTotallyInWater(Player player){
        //player.sendMessage(player.getLocation().toString());
        Location location = player.getLocation().add(0f,1f,0f);

        if (player.isSleeping()) location = player.getLocation();
        //WIP: 눈거나 엎드릴 때 감지!
        Block block = player.getWorld().getBlockAt(location);
        return (block.getType().equals(Material.WATER));
    }
    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);
        String unicode; String bar;

        int t = (int) Math.ceil(Thirst.getThirst(player.getUniqueId()));
        if (isTotallyInWater(player)) {
            if (t == 0) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005";
            } else if (t == 1) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE004";
            } else if (t == 2) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE003";
            } else if (t == 3) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE004\uF802\uE003";
            } else if (t == 4) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE003\uF802\uE003";
            } else if (t == 5) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE004\uF802\uE003\uF802\uE003";
            } else if (t == 6) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE003\uF802\uE003\uF802\uE003";
            } else if (t == 7) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE004\uF802\uE003\uF802\uE003\uF802\uE003";
            } else if (t == 8) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
            } else if (t == 9) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE004\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
            } else if (t == 10) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
            } else if (t == 11) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE004\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
            } else if (t == 12) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
            } else if (t == 13) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE004\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
            } else if (t == 14) {
                unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
            } else if (t == 15) {
                unicode = "\uE005\uF802\uE005\uF802\uE004\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
            } else if (t == 16) {
                unicode = "\uE005\uF802\uE005\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
            } else if (t == 17) {
                unicode = "\uE005\uF802\uE004\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
            } else if (t == 18) {
                unicode = "\uE005\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
            } else if (t == 19) {
                unicode = "\uE004\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
            } else {
                //t>=20;
                unicode = "\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
            }
        } else {
            if (t == 0) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002";
            } else if (t == 1) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE001";
            } else if (t == 2) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE000";
            } else if (t == 3) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE001\uF802\uE000";
            } else if (t == 4) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE000\uF802\uE000";
            } else if (t == 5) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE001\uF802\uE000\uF802\uE000";
            } else if (t == 6) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE000\uF802\uE000\uF802\uE000";
            } else if (t == 7) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE001\uF802\uE000\uF802\uE000\uF802\uE000";
            } else if (t == 8) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
            } else if (t == 9) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE001\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
            } else if (t == 10) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
            } else if (t == 11) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE001\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
            } else if (t == 12) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
            } else if (t == 13) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE001\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
            } else if (t == 14) {
                unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
            } else if (t == 15) {
                unicode = "\uE002\uF802\uE002\uF802\uE001\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
            } else if (t == 16) {
                unicode = "\uE002\uF802\uE002\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
            } else if (t == 17) {
                unicode = "\uE002\uF802\uE001\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
            } else if (t == 18) {
                unicode = "\uE002\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
            } else if (t == 19) {
                unicode = "\uE001\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
            } else {
                //t>=20;
                unicode = "\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
            }
        }// thirst 출력 코드

        int k = (int) Math.ceil(Stamina.getStamina(player.getUniqueId()));
        if (k == 0) {
            bar = "\uEA28";
        } else if (k == 1) {
            bar = "\uEA27";
        } else if (k == 2) {
            bar = "\uEA26";
        } else if (k == 3) {
            bar = "\uEA25";
        } else if (k == 4) {
            bar = "\uEA24";
        } else if (k == 5) {
            bar = "\uEA23";
        } else if (k == 6) {
            bar = "\uEA22";
        } else if (k == 7) {
            bar = "\uEA21";
        } else if (k == 8) {
            bar = "\uEA20";
        } else if (k == 9) {
            bar = "\uEA19";
        } else if (k == 10) {
            bar = "\uEA18";
        } else if (k == 11) {
            bar = "\uEA17";
        } else if (k == 12) {
            bar = "\uEA16";
        } else if (k == 13) {
            bar = "\uEA15";
        } else if (k == 14) {
            bar = "\uEA14";
        } else if (k == 15) {
            bar = "\uEA13";
        } else if (k == 16) {
            bar = "\uEA12";
        } else if (k == 17) {
            bar = "\uEA11";
        } else {
            //k>=18;
            bar = "\uEA10";
        }


        String tab1 = "\uF801";
        // -3

        String tab2 = "\uF80B" + "\uF809" + "\uF803";
        // -66-18-5

        String display = tab1 + bar + tab2 + unicode;
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(display));
    }
}