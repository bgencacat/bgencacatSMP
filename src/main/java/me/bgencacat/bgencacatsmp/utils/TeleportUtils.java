package me.bgencacat.bgencacatsmp.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Random;

public class TeleportUtils {
    public static HashSet<Material> badBlocks = new HashSet<>();

    static {
        badBlocks.add(Material.LAVA);
        badBlocks.add(Material.FIRE);
        badBlocks.add(Material.CACTUS);
        badBlocks.add(Material.WATER);
        badBlocks.add(Material.MAGMA_BLOCK);
    }


    public static Location generateLocation(Player player) {
        //Generate Random Location
        Random random = new Random();

        int x = 0;
        int z = 0;
        int y = 0;

        x = random.nextInt(25000);
        z = random.nextInt(25000);
        y = 150;

        Location randomLocation = new Location(player.getWorld(), x * (random.nextBoolean() ? -1 : 1), y, z * (random.nextBoolean() ? -1 : 1));
        y = randomLocation.getWorld().getHighestBlockYAt(randomLocation);
        randomLocation.setY(y);

        return randomLocation;
    }

    public static Location findSafeLocation(Player player) {

        Location randomLocation = generateLocation(player);

        while (!isLocationSafe(randomLocation)) {
            //Keep looking for a safe location
            randomLocation = generateLocation(player);
        }
        return randomLocation;
    }

    public static boolean isLocationSafe(Location location) {

        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        //Get instances of the blocks around where the player would spawn
        Block block = location.getWorld().getBlockAt(x, y, z);
        Block below = location.getWorld().getBlockAt(x, y - 1, z);
        Block above = location.getWorld().getBlockAt(x, y + 1, z);

        //Check to see if the surroundings are safe or not
        return !(badBlocks.contains(below.getType())) || (block.getType().isSolid()) || (above.getType().isSolid());
    }
}
