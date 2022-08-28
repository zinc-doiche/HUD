package com.reve.thirst.thirst;

import com.reve.thirst.Main;
import org.bukkit.entity.Player;

import java.util.*;

public class Thirst {
    private static final HashMap<UUID, Float> thirst = new HashMap<>();
    public static final float DEFAULT = 20L;
    public Thirst(UUID id){
        if (!thirst.containsKey(id)) setThirst(id, DEFAULT);
    }
    public static HashMap<UUID, Float> getThirst(){
        return thirst;
    }
    public static float getThirst(UUID id){
        if (!thirst.containsKey(id)) return DEFAULT;
        else return thirst.get(id);
    }
    public static void setThirst(UUID id, float value){
        thirst.put(id, value);
    }
    public static void saveThirst(Main plugin, HashMap<UUID, Float> thirst) {
        Iterator<Map.Entry<UUID, Float>> i = thirst.entrySet().iterator();
        Map<String, Float> map = new HashMap<>();
        while(i.hasNext()){
            Map.Entry<UUID, Float> entry = i.next();
            String name = plugin.getServer().getPlayer(entry.getKey()).getName();
            map.put(name, entry.getValue());
        }
        plugin.getConfig().set("thirst", map);
        plugin.saveConfig();
    }
    public static void loadThirst(Main plugin) {
        Map<String, Float> map = (Map<String, Float>) plugin.getConfig().get("thirst");
        Iterator<Map.Entry<String, Float>> i = map.entrySet().iterator();
        while(i.hasNext()){
            String name = i.next().getKey();
            Player player = plugin.getServer().getPlayer(name);
            UUID id = player.getUniqueId();
            Thirst.setThirst(id, i.next().getValue());
        }
    }
}
