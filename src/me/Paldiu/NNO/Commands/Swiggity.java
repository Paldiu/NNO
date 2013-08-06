package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class Swiggity implements CommandExecutor
{
    public Main plugin;
    public Swiggity(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if(commandLabel.equalsIgnoreCase("swiggity") || commandLabel.equalsIgnoreCase("swig"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (args.length == 0)
                {
                    if (sender.hasPermission("nonamedorg.swiggity"))
                    {
                        Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Swiggity swoner " + p.getName() + " has a boner!");
                        return true;
                    }
                    else
                    {
                        p.sendMessage(Main.MSG_NO_PERMS);
                        return true;
                    }
                }
            }
        }
        return true;
    }
}