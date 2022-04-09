package me.bgencacat.bgencacatsmp.listeners;

import me.bgencacat.bgencacatsmp.BSMP;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class RespawnListener implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();

        if (p.getBedSpawnLocation() != null) return;

        PersistentDataContainer data = p.getPersistentDataContainer();
        int locX = data.get(new NamespacedKey(BSMP.getPlugin(), "respawnLocationX"), PersistentDataType.INTEGER);
        int locY = data.get(new NamespacedKey(BSMP.getPlugin(), "respawnLocationY"), PersistentDataType.INTEGER);
        int locZ = data.get(new NamespacedKey(BSMP.getPlugin(), "respawnLocationZ"), PersistentDataType.INTEGER);

        Location loc = new Location(BSMP.getPlugin().getServer().getWorlds().get(0), locX, locY, locZ);
        e.setRespawnLocation(loc);
    }

}
