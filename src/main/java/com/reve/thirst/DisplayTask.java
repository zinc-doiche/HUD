package com.reve.thirst;

import com.reve.thirst.Main;
import com.reve.thirst.thirst.Thirst;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class DisplayTask extends BukkitRunnable {

    Main plugin; UUID id;
    public DisplayTask (Main plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
    }
    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);
        if (player != null){
            int t = (int) Math.ceil(Thirst.getThirst(player.getUniqueId()));
            String unicode = "";

            if(player.isInWater()){
                if (t == 0){
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005";
                } else if(t==1){
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE004";
                } else if (t==2) {
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE003";
                } else if (t==3) {
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE004\uF802\uE003";
                } else if (t==4) {
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE003\uF802\uE003";
                } else if (t==5) {
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE004\uF802\uE003\uF802\uE003";
                } else if (t==6) {
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE003\uF802\uE003\uF802\uE003";
                } else if (t==7) {
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE004\uF802\uE003\uF802\uE003\uF802\uE003";
                } else if (t==8) {
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
                } else if (t==9) {
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE004\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
                } else if (t==10) {
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
                } else if (t==11) {
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE004\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
                } else if (t==12) {
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE005\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
                } else if (t==13) {
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE004\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
                } else if (t==14) {
                    unicode = "\uE005\uF802\uE005\uF802\uE005\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
                } else if (t==15) {
                    unicode = "\uE005\uF802\uE005\uF802\uE004\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
                } else if (t==16) {
                    unicode = "\uE005\uF802\uE005\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
                } else if (t==17) {
                    unicode = "\uE005\uF802\uE004\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
                } else if (t==18) {
                    unicode = "\uE005\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
                } else if (t==19) {
                    unicode = "\uE004\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
                } else if (t>=20) {
                    unicode = "\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003\uF802\uE003";
                }
            }else {
                if (t == 0){
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002";
                } else if(t==1){
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE001";
                } else if (t==2) {
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE000";
                } else if (t==3) {
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE001\uF802\uE000";
                } else if (t==4) {
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE000\uF802\uE000";
                } else if (t==5) {
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE001\uF802\uE000\uF802\uE000";
                } else if (t==6) {
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE000\uF802\uE000\uF802\uE000";
                } else if (t==7) {
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE001\uF802\uE000\uF802\uE000\uF802\uE000";
                } else if (t==8) {
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
                } else if (t==9) {
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE001\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
                } else if (t==10) {
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
                } else if (t==11) {
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE001\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
                } else if (t==12) {
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE002\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
                } else if (t==13) {
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE001\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
                } else if (t==14) {
                    unicode = "\uE002\uF802\uE002\uF802\uE002\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
                } else if (t==15) {
                    unicode = "\uE002\uF802\uE002\uF802\uE001\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
                } else if (t==16) {
                    unicode = "\uE002\uF802\uE002\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
                } else if (t==17) {
                    unicode = "\uE002\uF802\uE001\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
                } else if (t==18) {
                    unicode = "\uE002\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
                } else if (t==19) {
                    unicode = "\uE001\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
                } else if (t>=20) {
                    unicode = "\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000\uF802\uE000";
                }
            }
            String tab = "\uF82B\uF82A\uF825";

            String display = tab+unicode;
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(display));
        }
    }
}
