package com.reve.thirst.thirst;

import com.reve.thirst.Main;
import com.reve.thirst.events.PlayerJumpEvent;
import com.reve.thirst.thirstTasks.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
public class ThirstListener implements Listener{
    Main plugin;
    private final HashMap<UUID, Float> remainWater = new HashMap<>();
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
        task.runTaskTimer(plugin, 5L, 5L);

        DisplayTask task1 = new DisplayTask(plugin, id);
        task1.runTaskTimer(plugin, 0L, 1L);
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        remainWater.put(player.getUniqueId(), Thirst.getThirst(player.getUniqueId()));
    }
    @EventHandler
    public void onDrink(PlayerItemConsumeEvent e){
        ItemStack item = e.getPlayer().getItemInUse();
        UUID id = e.getPlayer().getUniqueId();
        PotionData data;

        if (item != null) {
            data = ((PotionMeta) Objects.requireNonNull(item.getItemMeta())).getBasePotionData();

            if (data.getType().equals(PotionType.WATER)) {
                Thirst.setThirst(id, Thirst.getThirst(id) + 6);
                //e.getPlayer().sendMessage("Drink.");
            }
            if (data.getType().equals(PotionType.AWKWARD)) {
                Thirst.setThirst(id, Thirst.getThirst(id) - 20);
                //e.getPlayer().sendMessage("Drink.");
            }
        }
        if (Thirst.getThirst(id) >= 20)  Thirst.setThirst(id,20);
    }
    @EventHandler
    public void onRun(PlayerToggleSprintEvent e){
        RunTask task = new RunTask(plugin, e.getPlayer().getUniqueId());
        task.run();
    }
    @EventHandler
    public void onJump(PlayerJumpEvent e){
        JumpTask task = new JumpTask(plugin, e.getPlayer().getUniqueId());
        task.setIsJumping(e.getPlayer().getUniqueId(), true);
        task.runTaskLater(plugin, 5L);
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if (e.getEntity().getPlayer() != null) {
            UUID id = e.getEntity().getPlayer().getUniqueId();
            Thirst.setThirst(id, Thirst.DEFAULT);
        }
    }
}
