package me.Paldiu.NNO.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.Paldiu.NNO.DCBridge;
import me.Paldiu.NNO.Main;

public class uall implements CommandExecutor
{
    public Main plugin;
    public uall(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("uall"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.uall"))
                {
                   Bukkit.getServer().broadcastMessage(ChatColor.RED + sender.getName() + ": Undisguising all players");
                   DCBridge.getInstance().undisguiseAllPlayers();
                   return true;
                } else { p.sendMessage(Main.MSG_NO_PERMS); }
            } else {
                   Bukkit.getServer().broadcastMessage(ChatColor.RED + "CONSOLE: Undisguising all players");
                   DCBridge.getInstance().undisguiseAllPlayers();
                   return true;
            }
        }
        return false;
    }
}