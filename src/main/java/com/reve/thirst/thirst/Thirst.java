package com.reve.thirst.thirst;

import com.reve.thirst.Main;

import java.util.*;

public class Thirst {
    private static HashMap<UUID, Float> thirst = new HashMap<>();
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
}
