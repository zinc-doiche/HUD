package com.reve.thirst.thirstTasks;

import com.reve.thirst.Main;
import com.reve.thirst.thirst.Thirst;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class DisplayTask extends BukkitRunnable {

    Main plugin; UUID id;

    String tab = "\uF82B\uF82A\uF825";

    public DisplayTask (Main plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
    }

    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);

        if (player != null){

            int t = (int) Thirst.getThirst(player.getUniqueId());
            String unicode = null;

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
            String display="\uF82B\uF82A\uF825"+unicode;
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(display));
        }
    }
}
