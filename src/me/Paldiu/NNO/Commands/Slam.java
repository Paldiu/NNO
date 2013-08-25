package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Slam implements CommandExecutor
{
    public Main plugin;
    public Slam(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("slam"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.slam"))
                {
                    if (args.length != 1)
                    {
                        return false;
                    }
                    else
                    {
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        Util.bcastMsg(ChatColor.RED + p.getName() + " has slammed " + target.getName() + " into the ground.");
                        target.setGameMode(GameMode.SURVIVAL);
                        target.getInventory().clear();
                        Location playerLocation = target.getLocation();
                        playerLocation.setY(100);
                        target.teleport(playerLocation);
                        playerLocation.setY(target.getLocation().getY() - 1);
                        target.setHealth(0);
                        target.setVelocity(new Vector(0, -10, 0));
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
                Player target = Bukkit.getServer().getPlayer(args[0]);
                Util.bcastMsg(ChatColor.RED + sender.getName() + " has slammed " + target.getName() + " into the ground.");
                target.setGameMode(GameMode.SURVIVAL);
                target.getInventory().clear();
                Location playerLocation = target.getLocation();
                playerLocation.setY(100);
                target.teleport(playerLocation);
                playerLocation.setY(target.getLocation().getY() - 1);
                target.setHealth(0);
                target.setVelocity(new Vector(0, -10, 0));
                return true;
            }
        }
        return false;
    }
}