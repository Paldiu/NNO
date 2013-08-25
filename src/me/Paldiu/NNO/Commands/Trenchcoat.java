package me.Paldiu.NNO.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import me.Paldiu.NNO.Main;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class Trenchcoat implements CommandExecutor
{
    public Main plugin;
    public Trenchcoat(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("trenchcoat"))
        {
            if (sender instanceof Player)
            {
                final Player p = (Player) sender;
                if (args.length == 0)
                {
                    if (p.hasPermission("nonamedorg.trenchcoat"))
                    {
                        Bukkit.getServer().broadcastMessage(ChatColor.BLUE + p.getName() + " is putting on a trenchcoat!");
                        
                        new BukkitRunnable()
                        {
                            @Override
                            public void run()
                            {
                                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + p.getName() + " has put on a trenchcoat!");
                            }
                        }.runTaskLater(plugin, 40L * 2L);
                        return true;
                    }
                    else
                    {
                        Main.noPermission(p);
                        return true;
                    }
                }
                else if (args.length == 1)
                {
                    if (p.hasPermission("nonamedorg.trenchcoat.other"))
                    {
                        final Player target = Bukkit.getServer().getPlayer(args[0]);
                        Bukkit.getServer().broadcastMessage(ChatColor.BLUE + p.getName() + " is putting a trenchcoat on " + target.getName());
                        
                        new BukkitRunnable()
                        {
                            @Override
                            public void run()
                            {
                                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + p.getName() + " has put a trenchcoat on " + target.getName());
                            }
                        }.runTaskLater(plugin, 40L * 2L);
                        return true;
                    }
                    else
                    {
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
