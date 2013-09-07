package me.Paldiu.NNO.Commands;

import org.bukkit.Server;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import java.util.Random;

public class Pentagram extends CommandExecutor
{
    public Main plugin;
    private Server server = Bukkit.getServer();
    private Random random = new Random();
    private boolean TrailMix = false;
    public Pentagram(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("pentagram")
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.pentagram")
                {
                    if (args.length < 1)
                    {
                        return false;
                    }
                    else if (args.length > 2)
                    {
                        return false;
                    }
                    else if (args.length == 1)
                    {
                        if ((args[0].equals("on")))
                        {
                            TrailMix = true;
                            final Location location = p.getLocation();
                            for (int x = -1; x <= 1; x++)
                            {
                                for (int z = -1; z <= 1; z++)
                                {
                                    while (TrailMix)
                                    {
                                        location.setX(random.nextInt(location.getBlockX() + x));
                                        location.setZ(random.nextInt(location.getBlockY() + y));
                                        p.teleport(location);
                                    }
                                }
                            }
                        }
                        else if (args[0].equals("off"))
                        {
                            TrailMix = false;
                            p.kickPlayer(ChatColor.RED + "Pentagram has been disabled. Please relog for the changes to take effect.");
                        }
                    }
                    else if (args.length == 2)
                    {
                        Player target = server.getPlayer(args[1])
                        if ((args[0].equals("on")) && (args[1].equals(target.getName())))
                        {
                            if (target != null)
                            {
                                TrailMix = true;
                                final Location location = target.getLocation();
                                for (int x = -1; x <= 1; x++)
                                {
                                    for (int z = -1; z <= 1; z++)
                                    {
                                        while (TrailMix)
                                        {
                                            location.setX(random.nextInt(location.getBlockX() + x));
                                            location.setZ(random.nextInt(location.getBlockZ() + z));
                                            target.teleport(location);
                                        }
                                    }
                                }
                            }
                            else
                            {
                                p.sendMessage(Main.PLAYER_NOT_FOUND);
                            }
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
                else
                {
                    Main.noPermission(p);
                }
            }
            else
            {
                sender.sendMessage(Main.NOT_FROM_CONSOLE);
            }
            
            return true;
        }
        
        return false;
    }
}
