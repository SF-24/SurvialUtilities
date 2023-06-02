package com.xpkitty.survivalutils.listener;

import com.xpkitty.survivalutils.SurvivalUtils;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class MobSpawnListener implements Listener {

    SurvivalUtils survivalUtils;
    public MobSpawnListener(SurvivalUtils survivalUtils) {
        this.survivalUtils=survivalUtils;
    }

    @EventHandler
    void onMobSpawn(EntitySpawnEvent e) {
        if(e.getEntity() instanceof Monster) {
            double difficulty = survivalUtils.getTimer().getServerDifficulty();
            double hpModifier = difficulty+1;

            // if modifier >2
            if(hpModifier>2) {
                hpModifier=2;
            }
            Monster monster = (Monster) e.getEntity();
            int health = (int) (monster.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()*hpModifier);
            int damage = (int) (monster.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue()*hpModifier);
            monster.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(damage);
            monster.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);

        }
    }
}
