package me.bgencacat.bgencacatsmp.listeners;

import me.bgencacat.bgencacatsmp.utils.DamageUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player v)) return;
        if (!(e.getDamager() instanceof Player d)) return;

//        Player d = (Player) e.getDamager();
//        Player v = (Player) e.getEntity();

        if (DamageUtils.isProtectedFromDamage(d)) e.setCancelled(true);
        if (DamageUtils.isProtectedFromDamage(v)) e.setCancelled(true);

    }
}
