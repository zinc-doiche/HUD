package com.reve.HUD.configs;

import com.reve.HUD.HUDPlugin;
import com.reve.HUD.huds.thirst.Thirst;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class ThirstConfig {
    HUDPlugin plugin; Player player;
    public static final HashMap<UUID, Double> remain = new HashMap<>();
    public ThirstConfig(HUDPlugin plugin, Player player){
        this.plugin = plugin;
        this.player = player;
    }
    public void setThirstConfig(){
        UUID id = player.getUniqueId();
        if(remain.containsKey(player.getUniqueId())) {

            Thirst.setThirst(id, remain.get(id));
            // 서버 일반 유저
        } else if(plugin.getConfig().get("thirst."+player.getUniqueId()) != null){

            Thirst.setThirst(player.getUniqueId(), plugin.getConfig().getDouble("thirst."+player.getUniqueId()));
            // 서버 이용 경혐 있던 유저
        } else{
            Thirst.setThirst(id, Thirst.MAX);
            // 완전 신규 유저
        }
    }
    public void saveThirstConfig(){
        remain.put(player.getUniqueId(), Thirst.getThirst(player.getUniqueId()));
        plugin.getConfig().createSection("thirst",remain);
        plugin.saveConfig();
    }
}
