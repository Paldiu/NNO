package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class Nope implements CommandExecutor
{
    public Main plugin;
    public Nope(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("nope"))
        {
            Player p = (Player) sender;
            if (sender instanceof Player)
            {
                if (p.hasPermission("nonamedorg.nope"))
                {
                    p.kickPlayer(ChatColor.RED + "NOPE");
                    Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getName() + " has just NOPED the fuck out of the server.");
                    return true;
                }
                else
                {
                    p.sendMessage(Main.MSG_NO_PERMS);
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
