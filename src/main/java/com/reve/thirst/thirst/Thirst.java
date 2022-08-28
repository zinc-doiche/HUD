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
        List<String> lines = new ArrayList<>(thirst.entrySet().size());
        while(i.hasNext()){
            Map.Entry<UUID, Float> entry = i.next();
            Player player = plugin.getServer().getPlayer(entry.getKey());
            if (player != null) {
                String line = player.getName() + "," + entry.getValue();
                lines.add(line);
            }
        }
        plugin.getConfig().setInlineComments("thirst", lines);
        //plugin.getServer().broadcastMessage(map.toString());
        plugin.saveConfig();
    }
    public static void loadThirst(Main plugin, String name) {
        if (plugin.getServer().getPlayer(name) != null){
            List<String> lines = plugin.getConfig().getStringList("thirst");
            for(String line : lines){
                String[] mapList = line.split(",");
                Player player = plugin.getServer().getPlayer(name);
                if (name.equals(mapList[0])) Thirst.setThirst(player.getUniqueId(), Float.parseFloat(mapList[1]));
            }
        }
    }
}
