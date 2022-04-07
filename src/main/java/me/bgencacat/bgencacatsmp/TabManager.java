package me.bgencacat.bgencacatsmp;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;

public class TabManager {

    public void setPlayerList(Player player) {

        Audience aud = player;

        TextComponent header = Component.text("\n\n\n\n              §f\u0BE3              \n\n\n\n");
        TextComponent footer = Component.text("\n              smp.bgencacat.me              \n").color(TextColor.color(256, 200, 100));

        aud.sendPlayerListHeader(header);
        aud.sendPlayerListFooter(footer);

    }



}
