package me.bgencacat.bgencacatsmp.listeners;

import me.bgencacat.bgencacatsmp.BSMP;
import me.bgencacat.bgencacatsmp.utils.ChatUtils;
import me.bgencacat.bgencacatsmp.utils.TeleportUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {

        ChatUtils.GiveChatAndDisplayNameColors(e.getPlayer());

        TextComponent joinMessage = (TextComponent) e.getPlayer().displayName().append(Component.text(" giriş yaptı").color(TextColor.color(94, 153, 247)));
        e.joinMessage(joinMessage);

        BSMP.getPlugin().getTabManager().setPlayerList(e.getPlayer());

        if(!e.getPlayer().hasPlayedBefore())
        {
            Location randomLocation = TeleportUtils.findSafeLocation(e.getPlayer());

            e.getPlayer().teleport(randomLocation);

            PersistentDataContainer data = e.getPlayer().getPersistentDataContainer();

            data.set(new NamespacedKey(BSMP.getPlugin(), "respawnLocationX"), PersistentDataType.INTEGER, randomLocation.getBlockX());
            data.set(new NamespacedKey(BSMP.getPlugin(), "respawnLocationY"), PersistentDataType.INTEGER, randomLocation.getBlockY());
            data.set(new NamespacedKey(BSMP.getPlugin(), "respawnLocationZ"), PersistentDataType.INTEGER, randomLocation.getBlockZ());
        }

    }
}
