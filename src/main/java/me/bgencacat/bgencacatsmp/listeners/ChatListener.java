package me.bgencacat.bgencacatsmp.listeners;

import me.bgencacat.bgencacatsmp.utils.ChatUtils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        ChatUtils.FormatChat(e);
        ChatUtils.NotifyPlayerIfMentioned(e);
    }

}

