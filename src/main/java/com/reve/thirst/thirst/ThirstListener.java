package com.reve.thirst.thirst;

import com.reve.thirst.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
public class ThirstListener implements Listener{
    Main plugin;
    private final HashMap<UUID, Integer> remainWater = new HashMap<>();
    public ThirstListener(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        player.sendMessage("HI!");
        UUID id = player.getUniqueId();
        if(remainWater.containsKey(id)) Thirst.setThirst(id, remainWater.get(id));
        else Thirst.setThirst(id, Thirst.DEFAULT);
        ThirstTask task = new ThirstTask(plugin, id);
        player.sendMessage("Thirst: "+Thirst.getThirst(id));
        task.runTaskTimer(plugin, 0, 200L);
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        remainWater.put(player.getUniqueId(), Thirst.getThirst(player.getUniqueId()) );
    }
    @EventHandler
    public void onDrink(PlayerItemConsumeEvent e){
        ItemStack item = e.getPlayer().getItemInUse();
        UUID id = e.getPlayer().getUniqueId();
        PotionData data;
        if (item != null) {
            data = ((PotionMeta) Objects.requireNonNull(item.getItemMeta())).getBasePotionData();

            if (data.getType().equals(PotionType.WATER)) {
                Thirst.setThirst(id, Thirst.getThirst(id) + 3);
                e.getPlayer().sendMessage("Drink.");
            }
        }
        if (Thirst.getThirst(id) >= 20)  Thirst.setThirst(id,20);
    }

}
