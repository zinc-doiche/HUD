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
        Iterator<String> line= plugin.getConfig().getStringList("thirst").iterator();
        while(line.hasNext()){
            String name = line.next();
            Player player = plugin.getServer().getPlayer(name);
            UUID id = player.getUniqueId();
            Thirst.setThirst(id, 0f);
        }
    }
}
