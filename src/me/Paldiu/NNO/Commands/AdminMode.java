package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminMode implements CommandExecutor
{
    public Main plugin;
    public AdminMode(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("adminmode"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.adminmode"))
                {
                    if (args.length != 1)
                    {
                        return false;
                    }
    
                    if (args[0].equalsIgnoreCase("off"))
                    {
                        Main.plugin.getConfig().set("admin_mode_enabled", false);
                        Util.bcastMsg(ChatColor.GREEN + p.getName() + " - Opening the server to all players.");
                        return true;
                    }
                    else if (args[0].equalsIgnoreCase("on"))
                    {
                        Main.plugin.getConfig().set("admin_mode_enabled", true);
                        Util.bcastMsg(ChatColor.RED + p.getName() + " - Closing the server to non-admins.");
                        for (Player player : Bukkit.getServer().getOnlinePlayers())
                        {
                            if (!player.hasPermission("nonamedorg.adminmode.join"))
                            {
                                player.kickPlayer("Server is now closed to non-admins.");
                            }
                        }
                        return true;
                    }
                }
                else
                {
                    Main.noPermission(p);
                    return true;
                }
            }
            else
            {
                if (args.length != 1)
                {
                    return false;
                }

                if (args[0].equalsIgnoreCase("off"))
                {
                    Main.plugin.getConfig().set("admin_only_mode", false);
                    Util.bcastMsg(ChatColor.GREEN + sender.getName() + " - Opening the server to all players.");
                    return true;
                }
                else if (args[0].equalsIgnoreCase("on"))
                {
                    Main.plugin.getConfig().set("admin_only_mode", true);
                    Util.bcastMsg(ChatColor.RED + sender.getName() + " - Closing the server to non-admins.");
                    for (Player player : Bukkit.getServer().getOnlinePlayers())
                    {
                        if (!player.hasPermission("nonamedorg.adminmode.join"))
                        {
                            player.kickPlayer("Server is now closed to non-admins.");
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
