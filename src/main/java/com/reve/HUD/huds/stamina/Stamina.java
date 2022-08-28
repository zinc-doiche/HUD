package com.reve.HUD.huds.stamina;

import com.reve.HUD.huds.HUD;

import java.util.HashMap;
import java.util.UUID;

public class Stamina extends HUD {
    public static final float DEFAULT = 18f;
    private static final HashMap<UUID, Float> stamina = new HashMap<>();
    public Stamina(UUID id){
        if (!stamina.containsKey(id)) setStamina(id, DEFAULT);
    }
    public static HashMap<UUID, Float> getStamina(){
        return stamina;
    }
    public static float getStamina(UUID id){
        if (!stamina.containsKey(id)) return DEFAULT;
        else return stamina.get(id);
    }
    public static void setStamina(UUID id, float value){
        stamina.put(id, value);
    }
}
