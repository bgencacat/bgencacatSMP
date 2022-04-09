package me.bgencacat.bgencacatsmp.utils;

import me.bgencacat.bgencacatsmp.BSMP;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.awt.*;
import java.util.Random;

public class ChatUtils {

    public static ChatColor warningColor = ChatColor.of(new Color(235, 79, 52));

    public static void GiveChatAndDisplayNameColors(Player p) {
        int randomR = new Random().nextInt(255);
        int randomG = new Random().nextInt(255);
        int randomB = new Random().nextInt(255);

        BSMP.chatColors.put(p, new Color(randomR, randomG, randomB));

        TextComponent displayName = Component.text(p.getPlayer().getName()).color(TextColor.color(randomR, randomG, randomB));

        p.getPlayer().playerListName(displayName);
        p.getPlayer().displayName(displayName);
    }

    public static void NotifyPlayerIfMentioned(AsyncPlayerChatEvent e) {
        String[] arr = e.getMessage().split(" ");

        for (String word : arr) {
            for (Player player : BSMP.getPlugin().getServer().getOnlinePlayers()) {
                if (word.equalsIgnoreCase(player.getName())) {
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                }
            }
        }
    }

    public static void FormatChat(AsyncPlayerChatEvent e) {
        double hp = e.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
        e.setFormat(
                ChatColor.of(new Color(120, 120, 120)) + "" + (int) hp / 2 + "♥ " +
                        ChatColor.of(BSMP.chatColors.get(e.getPlayer()).brighter()) + "(%s" + ChatColor.of(BSMP.chatColors.get(e.getPlayer()).brighter()) + ")"
                        + " "
                        + ChatColor.of(BSMP.chatColors.get(e.getPlayer()).brighter())
                        + e.getMessage());
    }

}
