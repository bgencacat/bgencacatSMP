package me.bgencacat.bgencacatsmp.utils;

import me.bgencacat.bgencacatsmp.BSMP;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class DamageUtils {

    static Plugin plugin = BSMP.getPlugin();

    public static boolean isProtectedFromDamage(Player player)
    {
        double playerHp = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
        return (playerHp <= plugin.getConfig().getDouble("minHp"));
    }
}
