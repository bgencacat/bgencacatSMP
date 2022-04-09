package me.bgencacat.bgencacatsmp;

import me.bgencacat.bgencacatsmp.commands.ResetCommand;
import me.bgencacat.bgencacatsmp.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.util.HashMap;

public final class BSMP extends JavaPlugin {

    public static HashMap<Player, Color> chatColors = new HashMap<Player, Color>();
    private static BSMP plugin;
    private TabManager tabManager;

    public static BSMP getPlugin() {
        return plugin;
    }

    public TabManager getTabManager() {
        return tabManager;
    }


    @Override
    public void onEnable() {
        plugin = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        tabManager = new TabManager();

        ItemManager.init();

        registerListeners();
        registerCommands();
    }

    private void registerListeners() {

        Bukkit.getPluginManager().registerEvents(new EntityDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveListener(), this);
        Bukkit.getPluginManager().registerEvents(new RespawnListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new ProjectileHitListener(), this);
        Bukkit.getPluginManager().registerEvents(new PotionSplashListener(), this);
        Bukkit.getPluginManager().registerEvents(new ItemConsumeListener(), this);

    }

    private void registerCommands() {
        getCommand("reset").setExecutor(new ResetCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
