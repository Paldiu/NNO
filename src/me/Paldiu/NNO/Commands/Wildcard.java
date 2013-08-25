package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Wildcard implements CommandExecutor
{
    public Main plugin;
    public Wildcard(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("wildcard"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.wildcard"))
                {
                    switch (args[0])
                    {
                        case "wildcard":
                        {
                            p.sendMessage(ChatColor.RED + "What the hell are you trying to do, you stupid idiot...");
                            return true;
                        }
                            
                        case "ban":
                        {
                            p.sendMessage(ChatColor.RED + "Nice try");
                            return true;
                        }
                            
                        case "jelly":
                        {
                            p.sendMessage(ChatColor.RED + "Look, we all hate people, but this is not the way to deal with it.");
                            return true;
                        }
                            
                        case "gold":
                        {
                            p.sendMessage(ChatColor.RED + "LOLNOPE.");
                            return true;
                        }
                            
                        case "kick":
                        {
                            p.sendMessage(ChatColor.RED + "If /kickall is blocked, what makes you think this wont be?");
                            return true;
                        }
                    }
    
                    String base_command = StringUtils.join(args, " ");
    
                    for (Player player : Bukkit.getServer().getOnlinePlayers())
                    {
                        String out_command = base_command.replaceAll("\\x3f", player.getName());
                        p.sendMessage(ChatColor.GRAY + "Running Command: " + out_command);
                        Bukkit.getServer().dispatchCommand(sender, out_command);
                    }
    
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
                switch (args[0])
                {
                    case "wildcard":
                    {
                        sender.sendMessage(ChatColor.RED + "What the hell are you trying to do, you stupid idiot...");
                        return true;
                    }
                            
                    case "ban":
                    {
                        sender.sendMessage(ChatColor.RED + "Nice try");
                        return true;
                    }

                    case "jelly":
                    {
                        sender.sendMessage(ChatColor.RED + "Look, we all hate people, but this is not the way to deal with it.");
                        return true;
                    }

                    case "gold":
                    {
                        sender.sendMessage(ChatColor.RED + "LOLNOPE.");
                        return true;
                    }
                    
                    case "kick":
                    {
                        sender.sendMessage(ChatColor.RED + "If /kickall is blocked, what makes you think this wont be?");
                        return true;
                    }
                }

                String base_command = StringUtils.join(args, " ");

                for (Player player : Bukkit.getServer().getOnlinePlayers())
                {
                    String out_command = base_command.replaceAll("\\x3f", player.getName());
                    sender.sendMessage(ChatColor.GRAY + "Running Command: " + out_command);
                    Bukkit.getServer().dispatchCommand(sender, out_command);
                }
            }
        }
        return true;
    }
}
