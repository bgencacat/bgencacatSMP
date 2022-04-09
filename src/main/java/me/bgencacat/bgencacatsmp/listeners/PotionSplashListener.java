package me.bgencacat.bgencacatsmp.listeners;

import me.bgencacat.bgencacatsmp.utils.DamageUtils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;

public class PotionSplashListener implements Listener {

    @EventHandler
    public void onPotionSplash(PotionSplashEvent e) {
        if (!(e.getEntity().getShooter() instanceof Player)) return;

        Player d = (Player) e.getEntity().getShooter();

        if (DamageUtils.isProtectedFromDamage(d)) {
            e.setCancelled(true);
            return;
        }

        for (Entity entity : e.getAffectedEntities()) {

            if (entity.getName().equalsIgnoreCase(d.getName())) continue;

            if (entity instanceof Player) {
                if (DamageUtils.isProtectedFromDamage((Player) entity)) e.setCancelled(true);
            }
        }
    }
}
