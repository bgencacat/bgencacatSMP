package me.bgencacat.bgencacatsmp.listeners;

import me.bgencacat.bgencacatsmp.utils.DamageUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHitListener implements Listener {

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (!(e.getEntity().getShooter() instanceof Player)) return;
        if (!(e.getHitEntity() instanceof Player)) return;

        Player d = (Player) e.getEntity().getShooter();
        Player v = (Player) e.getHitEntity();

        if (DamageUtils.isProtectedFromDamage(d)) e.setCancelled(true);
        if (DamageUtils.isProtectedFromDamage(v)) e.setCancelled(true);
    }

}
