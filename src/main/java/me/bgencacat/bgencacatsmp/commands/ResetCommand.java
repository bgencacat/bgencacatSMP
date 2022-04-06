package me.bgencacat.bgencacatsmp.commands;

import me.bgencacat.bgencacatsmp.BSMP;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ResetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if( !(sender instanceof Player) ) return false;

        if( !sender.isOp() ) {

            sender.sendMessage(ChatColor.RED + "Bu komutu kullanmak için yetkin yok.");

            return true;

        }

        if( args.length < 1 ) {

            sender.sendMessage(ChatColor.RED + "Bir oyuncu adı yazman gerekiyor.");

            return true;

        }

        for( Player player : BSMP.getPlugin().getServer().getOnlinePlayers()) {

            if( !args[0].equalsIgnoreCase(player.getName()) ) continue;

            sender.sendMessage(player.getName() + "" + ChatColor.GREEN + " adlı oyuncunun özellikleri sıfırlandı");

            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);

        }

        return true;
    }
}
