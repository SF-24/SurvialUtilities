package com.xpkitty.survivalutils;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public class Timer {

    BukkitTask task;
    SurvivalUtils survivalUtils;

    public Timer(SurvivalUtils survivalUtils) {
        this.survivalUtils=survivalUtils;

        task = Bukkit.getScheduler().runTaskTimer(survivalUtils,() -> {
            survivalUtils.getDataManager().addTime(Bukkit.getOnlinePlayers().size());
        } , 1200, 1200);
    }

    public int getTime() {
        return survivalUtils.getDataManager().getTime();
    }

    public double getServerDifficulty() {
        double difficulty = survivalUtils.getDataManager().getTime();
        difficulty/=250000;

        return difficulty;
    }

    public void cancel() {
        task.cancel();
    }
}
