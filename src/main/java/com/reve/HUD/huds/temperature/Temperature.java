package com.reve.HUD.huds.temperature;

import com.reve.HUD.huds.HUD;

import java.util.HashMap;
import java.util.UUID;

public class Temperature extends HUD {
    private static final HashMap<UUID, Double> temp = new HashMap<>();

    public Temperature(UUID id){
        if (!temp.containsKey(id)) setTemperature(id, MAX/2);
    }
    public static HashMap<UUID, Double> getTemperature(){
        return temp;
    }
    public static double getTemperature(UUID id){
        if (!temp.containsKey(id)) return MAX/2;
        else return temp.get(id);
    }
    public static void setTemperature(UUID id, double value){
        temp.put(id, value);
    }

}
