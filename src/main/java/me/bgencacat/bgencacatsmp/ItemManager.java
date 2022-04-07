package me.bgencacat.bgencacatsmp;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack heartApple;

    public static void init() {
        createHeartApple();
    }

    public static void createHeartApple() {

        // Item

        ItemStack item = new ItemStack(Material.GOLDEN_APPLE, 1);

        ItemMeta meta = item.getItemMeta();

        TextComponent name = Component.text("Caco Elması").color(TextColor.color(255, 0, 0));

        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("Bu elmayı yiyerek 1 kalp kazanırsın").color(TextColor.color(200, 0, 0)));

        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.lore(lore);
        meta.displayName(name);

        item.setItemMeta(meta);

        heartApple = item;

        // Recipe

        ShapelessRecipe sr = new ShapelessRecipe(NamespacedKey.minecraft("heart_apple"), item);
        sr.addIngredient(2, Material.GHAST_TEAR);
        sr.addIngredient(2, Material.NETHERITE_SCRAP);
        sr.addIngredient(1, Material.EGG);
        sr.addIngredient(1, Material.GOLDEN_APPLE);
        sr.addIngredient(1, Material.OBSIDIAN);
        sr.addIngredient(1, Material.COBWEB);
        sr.addIngredient(1, Material.DIAMOND);


        BSMP.getPlugin().getServer().addRecipe(sr);

    }
}
