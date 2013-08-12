package me.Paldiu.NNO.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import me.Paldiu.NNO.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;

public class Thermite implements CommandExecutor
{
    public Main plugin;
    public Thermite(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("thermite"))
        {
            Player p = (Player) sender;
            if (sender instanceof Player)
            {
                if (p.hasPermission("nonamedorg.thermite"))
                {
                    Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getName() + " has just stuck thermite up their ass!");
                    final Location l = p.getLocation();
                    final World w = p.getWorld();
                    for (int x = -1; x <= 1; x++)
                    {
                        for (int z = -1; z <= 1; z++)
                        {
                            final Location explosion = new Location(w, l.getBlockX() + x, l.getBlockY(), l.getBlockZ() + z);
                            w.createExplosion(explosion, 3);
                        }
                    }
                    return true;
                }
                else
                {
                    p.sendMessage(Main.MSG_NO_PERMS);
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
