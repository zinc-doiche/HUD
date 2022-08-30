package com.reve.HUD.tasks;

import com.reve.HUD.HUDPlugin;
import com.reve.HUD.huds.stamina.Stamina;
import com.reve.HUD.huds.thirst.Thirst;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class DisplayTask extends BukkitRunnable {
    private final HUDPlugin plugin;
    private final UUID id;
    public DisplayTask (HUDPlugin plugin, UUID id){
        this.plugin = plugin;
        this.id = id;
    }
    @Override
    public void run() {
        Player player = plugin.getServer().getPlayer(id);
        String display1 = "";
        String a = "\uE000\uF802"; //풀
        String b = "\uE001\uF802"; //반 + 띄어쓰기
        String c = "\uE002\uF802"; //없


        if (player != null &&
                (player.getGameMode().equals(GameMode.SURVIVAL) || player.getGameMode().equals(GameMode.ADVENTURE))) {
            int t = (int) Math.ceil(Thirst.getThirst(player.getUniqueId()));

            if (player.isSwimming() || (player.getRemainingAir() < 300)) {
                //remainingAir Max값이 왜 300이냐 ㅋㅋ;
                a = "\uE003\uF802"; //풀 물
                b = "\uE004\uF802"; //반 물 + 띄어쓰기
                c = "\uE005\uF802"; //없 물
            }

            if (t % 2 == 0) {
                int k = t / 2;
                int x = 10 - k;

                if (x != 0) {
                    for (int i = x; i > 0; i--) {
                        display1 += c;
                    }
                }
                for (int i = k; i > 0; i--) {
                    display1 += a;
                }

            } else {
                int k = t / 2;
                int x = 9 - k;

                for (int i = x; i > 0; i--) {
                    display1 += c;
                }
                display1 += b;
                for (int i = k; i > 0; i--) {
                    display1 += a;
                }
            }
            String thirst = display1.substring(0, display1.length() - 1);
            // thirst 출력 코드


            String bar;
            int k = (int) Math.ceil(Stamina.getStamina(player.getUniqueId()));

            if (k == 0) {
                bar = "\uEA28";
            } else if (k == 1) {
                bar = "\uEA27";
            } else if (k == 2) {
                bar = "\uEA26";
            } else if (k == 3) {
                bar = "\uEA25";
            } else if (k == 4) {
                bar = "\uEA24";
            } else if (k == 5) {
                bar = "\uEA23";
            } else if (k == 6) {
                bar = "\uEA22";
            } else if (k == 7) {
                bar = "\uEA21";
            } else if (k == 8) {
                bar = "\uEA20";
            } else if (k == 9) {
                bar = "\uEA19";
            } else if (k == 10) {
                bar = "\uEA18";
            } else if (k == 11) {
                bar = "\uEA17";
            } else if (k == 12) {
                bar = "\uEA16";
            } else if (k == 13) {
                bar = "\uEA15";
            } else if (k == 14) {
                bar = "\uEA14";
            } else if (k == 15) {
                bar = "\uEA13";
            } else if (k == 16) {
                bar = "\uEA12";
            } else if (k == 17) {
                bar = "\uEA11";
            } else {
                bar = "\uEA10";
            }
            String staminaBar = bar;
            // bar 출력 코드, case 통한 간결화 필요


            String tab1 = "\uF801";
            // -3

            String tab2 = "\uF80B" + "\uF809" + "\uF803";
            // -66-18-5

            String display = tab1 + staminaBar + tab2 + thirst;
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(display));
        }
    }
}