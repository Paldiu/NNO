package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.paldiu.Util;
import io.github.simplexdevelopment.cl.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class CakeCMD extends CommandBase {
    private final NNOPlugin plugin;

    public CakeCMD(NNOPlugin plugin) {
        super("nno.cake", false);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        StringBuilder output = new StringBuilder();
        Random randomGenerator = new Random();

        String[] words = plugin.CAKE_LYRICS.split(" ");
        for (String word : words) {
            String color_code = Integer.toHexString(1 + randomGenerator.nextInt(14));
            output.append(ChatColor.COLOR_CHAR).append(color_code).append(word).append(" ");
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            ItemStack heldItem = new ItemStack(Material.CAKE, 1);
            player.getInventory().setItem(player.getInventory().firstEmpty(), heldItem);
        }

        broadcast(output.toString());
    }
}
