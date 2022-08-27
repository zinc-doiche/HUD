package com.reve.thirst.thirst;

import java.util.HashMap;
import java.util.UUID;

public class Thirst {
    public static HashMap<UUID, Float> thirst = new HashMap<>();
    public static final float DEFAULT = 20L;
    public Thirst(UUID id){
        thirst.put(id, DEFAULT);
    }
    public static Float getThirst(UUID id){
        return thirst.get(id);
    }
    public static void setThirst(UUID id, float value){
        if (thirst.containsKey(id)) thirst.replace(id, value);
        else thirst.put(id, DEFAULT);
    }
}
