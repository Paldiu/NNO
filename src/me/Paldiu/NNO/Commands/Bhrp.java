package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bhrp implements CommandExecutor
{
    public Main plugin;
    public Bhrp(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player p = (Player) sender;
        if (commandLabel.equalsIgnoreCase("bhrp"))
        {
            if (p.hasPermission("nonamedorg.bhrp"))
            {
                Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "Is this the real life?");
                Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "Is this just fantasy?");
                Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "Caught in a landslide");
                Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "No escape from reality...");
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