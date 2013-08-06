package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Phyllis implements CommandExecutor
{
    public Main plugin;
    public Phyllis(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player p = (Player) sender;
        if (commandLabel.equalsIgnoreCase("phyllis"))
        {
            if (p.hasPermission("nonamedorg.phyllis"))
            {
                Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "HI ITS PHYLLIS FROM DENVAH HERE!");
                Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "I BOUGHT A SHAMWOW BECAUSE MY CAT MR FLUFFY " + ChatColor.RED + "BIT THE DUST " + ChatColor.LIGHT_PURPLE + "A FEW DAYS AGO, ");
                Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "AND I WANTED TO DUST HIM OFF BEFORE I SENT HIM TO THE " + ChatColor.DARK_RED + "TAXIDERMIST" + ChatColor.LIGHT_PURPLE + "!");
                Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "NOW HE SITS PROUDLY ON MY MANTLE, " + ChatColor.WHITE + "CLEAN " + ChatColor.BLUE + "AS EVAH!!!");
                return true;
            }
            else
            {
                p.sendMessage(Main.MSG_NO_PERMS);
                return true;
            }
        }
        return false;
    }
}