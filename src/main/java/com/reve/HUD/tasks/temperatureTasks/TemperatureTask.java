package com.reve.HUD.tasks.temperatureTasks;

import com.reve.HUD.HUDPlugin;
import com.reve.HUD.huds.temperature.Temperature;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class TemperatureTask extends BukkitRunnable {
    private final HUDPlugin plugin;
    private final UUID id;
    private final HashMap<UUID, Long> timer = new HashMap<>();
    private Double temperature = 10d;
    public TemperatureTask(HUDPlugin plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
    }
    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);
        PlayerTemperatureTask playerTempTask = new PlayerTemperatureTask(plugin, id);
        if (player != null) {
            temperature = player.getWorld().getTemperature(
                    (int)player.getLocation().getX(),
                    (int)player.getLocation().getY(),
                    (int)player.getLocation().getZ()) + 1;
            temperature = (temperature*20)/3;
            //map from -1~2 to 0~20.
            double deltaTemp = Math.abs(temperature - Temperature.getTemperature(id));
            if (deltaTemp >= 3d){
                if (!timer.containsKey(id)) timer.put(id, System.currentTimeMillis());
                if (System.currentTimeMillis() - timer.get(id) >= 60000L) {
                    playerTempTask.setIsRunning(true);
                    playerTempTask.runTaskLater(plugin, 60L);
                }
            }else{
                playerTempTask.setIsRunning(false);
                timer.remove(id);

            }
            //player.sendMessage(temperature.toString());
            //플레이어가 온도가 체온과 3 이상 다른 곳에서 1분 이상 있으면, 체온 변화 시작.
            //체온은 |현재 체온 - 기온| 의 속도로 변화함.
            //체온 레벨 0/20에서 데미지 입기 시작. x초에 y 데미지 받음.
            //+용암, 물, 가루눈, 지옥
        }
    }
    public double getTemperature(){
        return temperature;
    }
}
