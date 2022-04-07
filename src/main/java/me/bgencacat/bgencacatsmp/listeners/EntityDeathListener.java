package me.bgencacat.bgencacatsmp.listeners;

import me.bgencacat.bgencacatsmp.BSMP;
import me.bgencacat.bgencacatsmp.utils.ChatUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

public class EntityDeathListener implements Listener {

    Plugin plugin = BSMP.getPlugin();
    @EventHandler
    public void onEntityDeath(PlayerDeathEvent e) {

        Player v = e.getEntity();

        double victimHP = v.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();

        if( victimHP <= plugin.getConfig().getDouble("minHp") ) {

            v.sendMessage(ChatUtils.warningColor + "Kaybedecek kalbin kalmadığı için sana karışmadık");

        } else {

            v.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(victimHP - plugin.getConfig().getDouble("decreaseOnDeath"));
            v.sendMessage(ChatColor.RED + "Öldüğün için " + (int) plugin.getConfig().getDouble("decreaseOnDeath")/2 + " kalbin eksildi");

        }

        if( e.getEntity().getKiller() != null && e.getEntity().getKiller() instanceof Player ) {

            Player k = e.getEntity().getKiller();
            double killerHP = k.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();

            if(victimHP > plugin.getConfig().getDouble("minHp") && killerHP < plugin.getConfig().getDouble("maxHp")) {

                k.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(killerHP + plugin.getConfig().getDouble("increaseOnKill"));
                k.sendMessage(ChatColor.GREEN + "Birini öldürdüğün için " + (int) plugin.getConfig().getDouble("increaseOnKill")/2 + " kalp kazandın");

            }

            if( killerHP >= plugin.getConfig().getDouble("maxHp") ) k.sendMessage(ChatUtils.warningColor + "Canın " + (int) plugin.getConfig().getDouble("maxHp")/2 + "'dan yüksek veya eşit olduğu için daha fazla can toplayamazsın.");

            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta meta = (SkullMeta) playerHead.getItemMeta();
            meta.setOwningPlayer(v);

            TextComponent tx = Component.text(v.getName());
            meta.displayName(tx);

            playerHead.setItemMeta(meta);

            e.getDrops().add(playerHead);
        }
    }
}
