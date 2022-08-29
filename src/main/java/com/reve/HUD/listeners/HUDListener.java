package com.reve.HUD.listeners;

import com.reve.HUD.HUDPlugin;
import com.reve.HUD.configs.ThirstConfig;
import com.reve.HUD.huds.thirst.Thirst;
import com.reve.HUD.tasks.DisplayTask;
import com.reve.HUD.events.PlayerJumpEvent;
import com.reve.HUD.tasks.JumpTask;
import com.reve.HUD.tasks.RunTask;
import com.reve.HUD.tasks.temperatureTasks.TemperatureTask;
import com.reve.HUD.tasks.thirstTasks.*;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.Objects;
import java.util.UUID;
public class HUDListener implements Listener{
    HUDPlugin plugin;
    public HUDListener(HUDPlugin plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        player.sendMessage("HI!");
        UUID id = player.getUniqueId();

        new ThirstConfig(plugin, player).setThirstConfig();

        //player.sendMessage("Thirst: "+Thirst.getThirst(id));
        new ThirstTask(plugin, id).runTaskTimer(plugin, 5L, 5L);

        new TemperatureTask(plugin, id).runTaskTimer(plugin, 10L, 10L);
        if (player != null && (player.getGameMode().equals(GameMode.SURVIVAL) ||
                player.getGameMode().equals(GameMode.ADVENTURE)))
            new DisplayTask(plugin, id).runTaskTimer(plugin, 0L, 1L);
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        new ThirstConfig(plugin, player).saveThirstConfig();
    }
    @EventHandler
    public void onDrink(PlayerItemConsumeEvent e){
        ItemStack item = e.getPlayer().getItemInUse();
        UUID id = e.getPlayer().getUniqueId();
        PotionData data;

        if (item != null) {
            data = ((PotionMeta) Objects.requireNonNull(item.getItemMeta())).getBasePotionData();

            if (data.getType().equals(PotionType.WATER)) {
                Thirst.setThirst(id, Thirst.getThirst(id) + 6d);
                //e.getPlayer().sendMessage("Drink.");
            }
            if (data.getType().equals(PotionType.AWKWARD)) {
                Thirst.setThirst(id, Thirst.getThirst(id) - 20d);
                //e.getPlayer().sendMessage("Drink.");
            }
        }
        if (Thirst.getThirst(id) >= 20d)  Thirst.setThirst(id,20d);
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
            Thirst.setThirst(id, Thirst.MAX);
        }
    }
}
