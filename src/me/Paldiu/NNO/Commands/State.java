/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.Paldiu.NNO.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import me.Paldiu.NNO.Main;
import org.bukkit.ChatColor;

public class State implements CommandExecutor
{
    public Main plugin;
    public State(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("state"))
        {
            if (args.length == 1)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.state"))
                {
                    switch (args[0]) {
                        case "illusion":
                            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getName() + " now lives in the state of ILLUSION");
                            return true;
                        case "confusion":
                            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getName() + " now lives in the state of CONFUSION");
                            return true;
                        case "consciousness":
                            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getName() + " now lives in the state of CONSCIOUSNESS");
                            return true;
                        case "afghanistan":
                            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getName() + " now lives in the state of AFGHANISTAN");
                            return true;
                    }
                }
                else
                {
                    p.sendMessage(Main.MSG_NO_PERMS);
                    return true;
                }
            }
            else
            {
                sender.sendMessage(Main.NOT_ENOUGH_ARGS);
                return true;
            }
        }
        return false;
    }
}
