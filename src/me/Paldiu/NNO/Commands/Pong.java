package me.Paldiu.NNO.Commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import me.Paldiu.NNO.Main;
import org.bukkit.ChatColor;

public class Pong implements CommandExecutor
{
    public Main plugin;
    public Pong(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("pong"))
        {
            Player p = (Player) sender;
            if (p.hasPermission("nonamedorg.pong"))
            {
                Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "I heard " + p.getName() + " likes little Asian boys.");
                return true;
            }
            else
            {
                p.sendMessage(Main.MSG_NO_PERMS);
                return true;
            }
        }
        
        if (commandLabel.equalsIgnoreCase("grogger"))
        {
            Player p = (Player) sender;
            if (p.hasPermission("nonamedorg.grogger"))
            {
                Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getName() + " is a horny grogger!");
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
