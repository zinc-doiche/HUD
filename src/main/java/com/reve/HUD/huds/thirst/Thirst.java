package com.reve.HUD.huds.thirst;

import com.reve.HUD.huds.HUD;

import java.util.*;
public class Thirst extends HUD {
    private static final HashMap<UUID, Double> thirst = new HashMap<>();
    public Thirst(UUID id){
        if (!thirst.containsKey(id)) setThirst(id, MAX);
    }
    public static HashMap<UUID, Double> getThirst(){
        return thirst;
    }
    public static double getThirst(UUID id){
        if (!thirst.containsKey(id)) return MAX;
        else return thirst.get(id);
    }
    public static void setThirst(UUID id, double value){
        thirst.put(id, value);
    }
}
