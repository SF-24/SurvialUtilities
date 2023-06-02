package com.xpkitty.survivalutils;

import com.xpkitty.survivalutils.listener.MobSpawnListener;
import com.xpkitty.survivalutils.listener.UIListener;
import com.xpkitty.survivalutils.manager.DataManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class SurvivalUtils extends JavaPlugin {

    DataManager dataManager = new DataManager(this);
    Timer timer;

    @Override
    public void onEnable() {
        Bukkit.getLogger().log(Level.INFO,this.getName() + " has been enabled");

        timer = new Timer(this);

        getCommand("survivalutils").setExecutor(new UtilCommand(this));

        Bukkit.getPluginManager().registerEvents(new UIListener(), this);
        Bukkit.getPluginManager().registerEvents(new MobSpawnListener(this), this);
    }

    @Override
    public void onDisable() {
        timer.cancel();
    }

    public DataManager getDataManager() {return dataManager;}
    public Timer getTimer() {return timer;}
}
