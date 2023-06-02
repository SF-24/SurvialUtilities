package com.xpkitty.survivalutils.listener;

import com.xpkitty.survivalutils.SurvivalUtils;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Repairable;

public class UIListener implements Listener {

    // removes too expensive anvil message by setting repair cost to 38 if is higher
    @EventHandler
    void onAnvil(PrepareAnvilEvent e) {
        ItemStack stack = e.getResult();

        if(stack.getItemMeta()!=null) {
            ItemMeta itemMeta = stack.getItemMeta();
            if(itemMeta instanceof Repairable && ((Repairable) itemMeta).hasRepairCost()) {
                int repairCost = ((Repairable) itemMeta).getRepairCost();
                if(repairCost>39) {
                    ((Repairable) itemMeta).setRepairCost(39);
                    stack.setItemMeta(itemMeta);
                }
            }
        }
    }

    @EventHandler
    void onModSpawn(EntitySpawnEvent e) {
        if(e.getEntity() instanceof Monster) {
            //TODO: add timer difficulty
        }
    }
}
