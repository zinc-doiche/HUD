package com.reve.thirst.thirst;

import com.reve.thirst.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;
public class ThirstListener implements Listener{
    Main plugin;
    private final HashMap<UUID, Integer> remainWater = new HashMap<>();
    public ThirstListener(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        UUID id = player.getUniqueId();
        if(remainWater.containsKey(id)) Thirst.setThirst(id, remainWater.get(id));
        else Thirst.setThirst(id, Thirst.DEFAULT);
        ThirstTask task = new ThirstTask(plugin, id);
        player.sendMessage("Thirst: "+Thirst.getThirst(id));
        task.runTaskTimer(plugin, 0, 200L);
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        remainWater.put(player.getUniqueId(), Thirst.getThirst(player.getUniqueId()) );
    }
    @EventHandler
    public void onDrink(PlayerItemConsumeEvent e){
        ItemStack item = e.getItem();
        UUID id = e.getPlayer().getUniqueId();
        if (item == new ItemStack(Material.GLASS_BOTTLE, 1)){
            Thirst.setThirst(id, Thirst.getThirst(id) + 3);
            e.getPlayer().sendMessage("Drink.");
        }
        if (Thirst.getThirst(id) >= 20)  Thirst.setThirst(id,20);
    }

}
