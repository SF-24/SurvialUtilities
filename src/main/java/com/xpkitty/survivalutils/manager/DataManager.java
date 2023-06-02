package com.xpkitty.survivalutils.manager;

import com.xpkitty.survivalutils.SurvivalUtils;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DataManager {

    public DataManager(SurvivalUtils survivalUtils) {
        initFiles(survivalUtils);
    }

    File file;

    // INITIALIZE FILE
    public void initFiles(SurvivalUtils survivalUtils) {
        String path = survivalUtils.getDataFolder() + File.separator + "Data";
        String fileName = "time_data.yml";
        file = new File(path,fileName);

        //if dir does not exist create it
        if(!file.getParentFile().exists()) {
            try {
                file.getParentFile().createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // if file does not exist, create it
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        YamlConfiguration yamlConfiguration = getModifyFile();
        yamlConfiguration.set("server-time",0);
        try {
            yamlConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public YamlConfiguration getModifyFile() {
        return YamlConfiguration.loadConfiguration(file);
    }

    public int getTime() {
        return getModifyFile().getInt("server-time");
    }

    // set time function
    public void setTime(int time) {

        YamlConfiguration yamlConfiguration = getModifyFile();
        yamlConfiguration.set("server-time",time);
        try {
            yamlConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // add server time
    public void addTime(int time) {
        int newTime = getTime() + time;

        if(newTime>500000) {
            newTime=500000;
        }

        setTime(newTime);
    }

}
