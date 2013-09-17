package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import java.util.Random;
import me.Paldiu.NNO.Util;
import org.bukkit.Server;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Dragon implements CommandExecutor
{
    public Main plugin;
    private Random random = new Random();
    private Server server = Bukkit.getServer();
    public Dragon(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("dragon"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.dragon"))
                {
                    if (args.length > 1)
                    {
                        return false;
                    }
                    
                    else if (args.length == 0)
                    {
                        p.sendMessage(ChatColor.RED + "Dragons D:");
                    }
                    
                    else if (args.length == 1)
                    {
                        Player target = server.getPlayer(args[0]);
                        final Location target_pos = target.getLocation();
                        final World world = target.getWorld();
                        for (int x = -1; x <= 1; x++)
                        {
                            for (int z = -1; z <= 1; z++)
                            {
                                final Location strike_pos = new Location(world, target_pos.getBlockX() + x, target_pos.getBlockY(), target_pos.getBlockZ() + z);
                                for (int i = 0; i < 2; i++)
                                {
                                    world.strikeLightning(strike_pos);
                                }
                            }
                        }
                        
                        Util.bcastMsg(ChatColor.RED + "DRAGONS BITCH!");
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