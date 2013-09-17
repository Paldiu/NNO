package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SuperSlap implements CommandExecutor
{
    public Main plugin;
    public SuperSlap(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("superslap"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.superslap"))
                {
                    if (args.length != 1)
                    {
                        return false;
                    }
                    else
                    {
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        Util.bcastMsg(ChatColor.RED + target.getName() + " has been superslapped!");
                        Location newLocation = target.getLocation();
                        newLocation.setY(132);
                        Util.ChatBot(p.getName() + ": Superslapped " + target.getName() + ".");
                        target.teleport(newLocation);
                        target.setGameMode(GameMode.SURVIVAL);
                        target.getInventory().clear();
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
                        target.setVelocity(new Vector(0, 10, 0));
                        return true;
                    }
                }
                else
                {
                    Main.noPermission(p);
                    Util.ChatBot(p.getName() + " has just used a disciplinary command!");
                    return true;
                }
            }
            else
            {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                Util.bcastMsg(ChatColor.RED + target.getName() + " has been superslapped!");
                Location newLocation = target.getLocation();
                Util.ChatBot("Console: Superslapped " + target.getName() + ".");
                newLocation.setY(132);
                target.teleport(newLocation);
                target.setGameMode(GameMode.SURVIVAL);
                target.getInventory().clear();
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
                target.setVelocity(new Vector(0, 10, 0));
                return true;
            }
        }
        return false;
    }
}
