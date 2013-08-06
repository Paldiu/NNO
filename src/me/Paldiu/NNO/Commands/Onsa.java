package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Onsa implements CommandExecutor
{
    public Main plugin;
    public Onsa(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player p = (Player) sender;
        if (commandLabel.equalsIgnoreCase("onsa"))
        {
            if (p.hasPermission("nonamedorg.onsa"))
            {
                Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getName() + ": Preparing an Onion Sandwich...");
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