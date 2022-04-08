package me.bgencacat.bgencacatsmp.utils;

import me.bgencacat.bgencacatsmp.BSMP;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PlayerUtils {

    public static void startAsNewPlayer(Player p) {

        Location randomLocation = TeleportUtils.findSafeLocation(p);

        p.teleport(randomLocation);

        PersistentDataContainer data = p.getPersistentDataContainer();

        data.set(new NamespacedKey(BSMP.getPlugin(), "respawnLocationX"), PersistentDataType.INTEGER, randomLocation.getBlockX());
        data.set(new NamespacedKey(BSMP.getPlugin(), "respawnLocationY"), PersistentDataType.INTEGER, randomLocation.getBlockY());
        data.set(new NamespacedKey(BSMP.getPlugin(), "respawnLocationZ"), PersistentDataType.INTEGER, randomLocation.getBlockZ());

    }

    public static void resetPlayer(Player p) {

        PersistentDataContainer data = p.getPersistentDataContainer();

        data.remove(new NamespacedKey(BSMP.getPlugin(), "respawnLocationX"));
        data.remove(new NamespacedKey(BSMP.getPlugin(), "respawnLocationY"));
        data.remove(new NamespacedKey(BSMP.getPlugin(), "respawnLocationZ"));

        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);

    }

}
