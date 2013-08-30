package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Nno implements CommandExecutor
{
    public Main plugin;
    public Nno(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("nno") || commandLabel.equalsIgnoreCase("orangepenis"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.nno"))
                {
                    if (args.length == 0)
                    {
                        p.sendMessage(String.format("[%s] Version: %s by %s - %s", plugin.getDescription().getName(), plugin.getDescription().getVersion(), plugin.getDescription().getAuthors(), plugin.getDescription().getDescription()));
                    }
                    else if (args.length == 1)
                    {
                        if (args[0].equals("help"))
                        {
                            p.sendMessage(ChatColor.RED + "Commands: ");
                            p.sendMessage(ChatColor.GREEN + "/achgiv");
                            p.sendMessage(ChatColor.GREEN + "/anal");
                            p.sendMessage(ChatColor.GREEN + "/oral");
                            p.sendMessage(ChatColor.GREEN + "/rape");
                            p.sendMessage(ChatColor.GREEN + "/bhrp");
                            p.sendMessage(ChatColor.GREEN + "/chcl");
                            p.sendMessage(ChatColor.GREEN + "/chcln");
                            p.sendMessage(ChatColor.GREEN + "/cuil <0-7 | info>");
                            p.sendMessage(ChatColor.GREEN + "/devconf");
                            p.sendMessage(ChatColor.GREEN + "/ltg");
                            p.sendMessage(ChatColor.GREEN + "/meep");
                            p.sendMessage(ChatColor.GREEN + "/grogger");
                            p.sendMessage(ChatColor.GREEN + "/nno [help]");
                            p.sendMessage(ChatColor.GREEN + "/nope");
                            p.sendMessage(ChatColor.GREEN + "/onsa");
                            p.sendMessage(ChatColor.GREEN + "/packnenil");
                            p.sendMessage(ChatColor.GREEN + "/penis");
                            p.sendMessage(ChatColor.GREEN + "/phyllis");
                            p.sendMessage(ChatColor.GREEN + "/pong");
                            p.sendMessage(ChatColor.GREEN + "/radioshow");
                            p.sendMessage(ChatColor.GREEN + "/ricardo");
                            p.sendMessage(ChatColor.GREEN + "/salmon");
                            p.sendMessage(ChatColor.GREEN + "/shower");
                            p.sendMessage(ChatColor.GREEN + "/sniper");
                            p.sendMessage(ChatColor.GREEN + "/state <confusion | consciousness | illusion | afghanistan>");
                            p.sendMessage(ChatColor.GREEN + "/swiggity");
                            p.sendMessage(ChatColor.GREEN + "/thermite");
                            p.sendMessage(ChatColor.GREEN + "/trenchcoat");
                            p.sendMessage(ChatColor.GREEN + "/virginia");
                            p.sendMessage(ChatColor.GREEN + "/weed");
                            p.sendMessage(ChatColor.GREEN + "/special");
                        }
                    }
                    else if (args.length == 2)
                    {
                        if ((args[0].equals("help")) && (args[1].equals("admin")))
                        {
                            if (p.hasPermission("nonamedorg.nno.admin"))
                            {
                                p.sendMessage(ChatColor.RED + "Admin commands: ");
                                p.sendMessage(ChatColor.GREEN + "/superslap <player>");
                                p.sendMessage(ChatColor.GREEN + "/freeze [player | purge]");
                                p.sendMessage(ChatColor.GREEN + "/slam <player>");
                                p.sendMessage(ChatColor.GREEN + "/gold <player>");
                                p.sendMessage(ChatColor.GREEN + "/rawsay <message>");
                                p.sendMessage(ChatColor.GREEN + "/jelly <player>");
                                p.sendMessage(ChatColor.GREEN + "/wildcard <this> ? [that] ?");
                                p.sendMessage(ChatColor.GREEN + "/gcmd <player> <command>");
                                p.sendMessage(ChatColor.GREEN + "/adminchat <message>");
                                p.sendMessage(ChatColor.GREEN + "/adminmode <on | off>");
                                p.sendMessage(ChatColor.GREEN + "/lockdown <on | off>");
                                p.sendMessage(ChatColor.GREEN + "/emsd");
                                p.sendMessage(ChatColor.GREEN + "/cake");
                                p.sendMessage(ChatColor.GREEN + "/deafen");
                                p.sendMessage(ChatColor.GREEN + "/lockup <<player on | off> | all | purge>");
                                p.sendMessage(ChatColor.GREEN + "/ntoggle");
                                p.sendMessage(ChatColor.GREEN + "/randsmite");
                                p.sendMessage(ChatColor.GREEN + "/tossmob");
                                p.sendMessage(ChatColor.GREEN + "/ntoggle");
                                p.sendMessage(ChatColor.GREEN + "/uall");
                            }
                            else
                            {
                                p.sendMessage(ChatColor.RED + "Admin commands: ");
                            }
                        }
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
                sender.sendMessage(Main.NOT_FROM_CONSOLE);
                return true;
            }
        }
        return false;
    }
}