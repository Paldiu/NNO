package me.Paldiu.NNO.Commands;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import java.util.Random;
import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class RandSmite implements CommandExecutor
{
    public Main plugin;
    public RandSmite(Main instance)
    {
        plugin = instance;
    }
    private Random random = new Random();
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("randsmite") || commandLabel.equalsIgnoreCase("rsmt"))
        {
            Player[] players = Bukkit.getServer().getOnlinePlayers();
            final Player p = players[random.nextInt(players.length)];
            if (sender instanceof Player)
            {
                if (sender.hasPermission("nonamedorg.randsmite"))
                {
                    Util.bcastMsg(ChatColor.RED + sender.getName() + " - Playing Smite Roulette...");
                    
                    new BukkitRunnable()
                    {
                        @Override
                        public void run()
                        {
                            final Location l = p.getLocation();
                            final World w = p.getWorld();
                            for (int x = -1; x <= 1; x++)
                            {
                                for (int z = -1; z <= 1; z++)
                                {
                                    final Location strike = new Location(w, l.getBlockX() + x, l.getBlockY(), l.getBlockZ() + z);
                                    w.strikeLightning(strike);
                                    p.setVelocity(new Vector(7,0,0));
                                }
                            }
                            p.sendMessage(ChatColor.RED + "You were randomly chosen by the roulette system! Thank you for playing!");
                            Util.bcastMsg(ChatColor.RED + p.getName() + " was the lucky selection of the Smite Roulette!");
                        }
                    }.runTaskLater(plugin, 20L * 2L);
                    return true;
                }
                else
                {
                    Main.noPermission(sender);
                    return true;
                }
            }
            else
            {
                Util.bcastMsg(ChatColor.RED + "CONSOLE - Playing Smite Roulette...");
        
                new BukkitRunnable()
                {
                    @Override
                    public void run()
                    {
                        final Location l = p.getLocation();
                        final World w = p.getWorld();
                        for (int x = -1; x <= 1; x++)
                        {
                            for (int z = -1; z <= 1; z++)
                            {
                                final Location strike = new Location(w, l.getBlockX() + x, l.getBlockY(), l.getBlockZ() + z);
                                w.strikeLightning(strike);
                                p.setVelocity(new Vector(7,0,0));
                            }
                        }
                        p.sendMessage(ChatColor.RED + "You were randomly chosen by the roulette system! Thank you for playing!");
                        Util.bcastMsg(ChatColor.RED + p.getName() + " was the lucky selection of the Smite Roulette!");
                    }
                }.runTaskLater(plugin, 20L * 2L);
                return true;
            }
        }
        return false;
    }
}
