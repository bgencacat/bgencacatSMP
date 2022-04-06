package me.bgencacat.bgencacatsmp.listeners;

import me.bgencacat.bgencacatsmp.BSMP;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

public class LeaveListener implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e)
    {
        e.setQuitMessage(ChatColor.of(new Color(50, 168, 82, 255)) +  e.getPlayer().getName() + " oyundan ayrıldı");
        BSMP.chatColors.remove(e.getPlayer());
        System.out.println("Hello");
    }
}
