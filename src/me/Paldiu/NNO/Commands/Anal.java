/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.Paldiu.NNO.Commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import me.Paldiu.NNO.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Anal implements CommandExecutor
{
    public Main plugin;
    public Anal(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if(commandLabel.equalsIgnoreCase("anal"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (args.length != 1)
                {
                    p.sendMessage("Not enough arguments! Please specify a player.");
                    return false;
                }
                else if (args.length == 1)
                {
                    if (sender.hasPermission("nonamedorg.anal"))
                    {
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        if (target != null)
                        {
                            if (!target.hasPermission("nonamedorg.anal.exempt"))
                            {
                                Bukkit.getServer().broadcastMessage(ChatColor.RED + sender.getName() + " wants to fuck " + target.getName() + " anally!");
                                p.teleport(target);
                                return true;
                            }
                            else
                            {
                                p.sendMessage(ChatColor.RED + "Error: That player has teleportion disabled.");
                                return true;
                            }
                        } else {
                            p.sendMessage(Main.PLAYER_NOT_FOUND);
                            return true;
                        }
                    } else {
                        Main.noPermission(p);
                        return true;
                    }
                }
            } else {
                sender.sendMessage(Main.NOT_FROM_CONSOLE);
                return true;
            }
        }    
        
        if(commandLabel.equalsIgnoreCase("oral"))
        {
            if (sender instanceof Player)
            {
                final Player p = (Player) sender;
                if (args.length != 1)
                {
                    p.sendMessage("Not enough arguments! Please specify a player.");
                    return false;
                }
                else if (args.length == 1)
                {
                    if (sender.hasPermission("nonamedorg.anal"))
                    {
                        final Player target = Bukkit.getServer().getPlayer(args[0]);
                        if (target != null)
                        {
                            if (!target.hasPermission("nonamedorg.anal.exempt"))
                            {
                                Bukkit.getServer().broadcastMessage(ChatColor.BLUE + sender.getName() + " is giving oral to " + target.getName() + "!");
                                p.teleport(target);
                                
                                new BukkitRunnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        p.teleport(target);
                                        p.setVelocity(new Vector(2,2,0));
                                        target.setVelocity(new Vector(-2,2,0));
                                    }
                                }.runTaskLater(plugin, 20L);
                                return true;
                            }
                            else
                            {
                                p.sendMessage(ChatColor.RED + "Error: That player has teleportion disabled.");
                                return true;
                            }
                        } else {
                            p.sendMessage(Main.PLAYER_NOT_FOUND);
                            return true;
                        }
                    } else {
                        Main.noPermission(p);
                        return true;
                    }
                }
            } else {
            sender.sendMessage(Main.NOT_FROM_CONSOLE);
            return true;
            }
        }
                
        if(commandLabel.equalsIgnoreCase("rape"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (args.length != 1)
                {
                    p.sendMessage("Not enough arguments! Please specify a player.");
                }
                else if (args.length == 1)
                {
                    if (sender.hasPermission("nonamedorg.anal"))
                    {
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        if (target != null)
                        {
                            if (!target.hasPermission("nonamedorg.exempt"))
                            {
                                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + sender.getName() + ": Raping " + target.getName() + "...");
                                p.teleport(target);
                                return true;
                            }
                            else
                            {
                                p.sendMessage(ChatColor.RED + "Error: That player has teleportation disabled.");
                                return true;
                            }
                        } else {
                            p.sendMessage(Main.PLAYER_NOT_FOUND);
                            return true;
                        }
                    } else {
                        Main.noPermission(p);
                        return true;
                    }
                }
            } else {
                sender.sendMessage(Main.NOT_FROM_CONSOLE);
                return true;
            }
        }
        return false;
    }
}