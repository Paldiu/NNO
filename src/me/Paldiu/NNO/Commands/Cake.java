package me.Paldiu.NNO.Commands;

import java.util.Random;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.Achievement;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Cake implements CommandExecutor
{
    public Main plugin;
    public Cake(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("cake"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.cake"))
                {
                    StringBuilder output = new StringBuilder();
                    Random randomGenerator = new Random();
            
                    String[] words = Main.CAKE_LYRICS.split(" ");
                    for (String word : words)
                    {
                        String color_code = Integer.toHexString(1 + randomGenerator.nextInt(14));
                        output.append(ChatColor.COLOR_CHAR).append(color_code).append(word).append(" ");
                    }
            
                    for (Player player : Bukkit.getServer().getOnlinePlayers())
                    {
                        ItemStack heldItem = new ItemStack(Material.CAKE, 1);
                        player.getInventory().setItem(player.getInventory().firstEmpty(), heldItem);
                        player.awardAchievement(Achievement.MINE_WOOD);
                        player.awardAchievement(Achievement.BUILD_WORKBENCH);
                        player.awardAchievement(Achievement.BUILD_HOE);
                        player.awardAchievement(Achievement.BAKE_CAKE);
                    }
            
                    Util.bcastMsg(output.toString());
                    return true;
                }
                else
                {
                    Main.noPermission(p);
                    return true;
                }
            }
            else
            {
                sender.sendMessage(Main.NOT_FROM_CONSOLE);
                return true;
            }
        }
        return true;
    }
}
