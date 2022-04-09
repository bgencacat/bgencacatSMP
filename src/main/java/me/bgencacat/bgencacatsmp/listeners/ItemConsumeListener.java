package me.bgencacat.bgencacatsmp.listeners;

import me.bgencacat.bgencacatsmp.BSMP;
import me.bgencacat.bgencacatsmp.ItemManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.Plugin;

public class ItemConsumeListener implements Listener {

    Plugin plugin = BSMP.getPlugin();

    @EventHandler
    public void onItemConsume(PlayerItemConsumeEvent e) {

        if (!(e.getItem().getItemMeta().equals(ItemManager.heartApple.getItemMeta()))) return;

        Player p = e.getPlayer();

        double pHp = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();

        if (pHp < plugin.getConfig().getDouble("maxHp")) {

            p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(pHp + plugin.getConfig().getDouble("increaseOnAppleConsume"));

            p.sendMessage(ChatColor.GREEN + " +" + (int) plugin.getConfig().getDouble("increaseOnAppleConsume") / 2 + " kalp kazandın!");

        } else {

            e.setCancelled(true);

            p.sendMessage(ChatColor.RED + "Canın zaten en fazla (" + (int) plugin.getConfig().getDouble("maxHp") / 2 + ") olduğu için bunu yiyemezsin.");

        }

    }

}
