package com.reve.thirst.thirst;

import java.util.HashMap;
import java.util.UUID;

public class Thirst {

    public static HashMap<UUID, Integer> thirst = new HashMap<>();
    public static final int DEFAULT = 20;
    public Thirst(UUID id){
        thirst.put(id, DEFAULT);
    }
    public static int getThirst(UUID id){
        return thirst.get(id);
    }
    public static void setThirst(UUID id, int value){
        if (thirst.containsKey(id)) thirst.replace(id, value);
        else thirst.put(id, DEFAULT);
    }
}
