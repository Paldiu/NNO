package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Gold implements CommandExecutor
{
    public Main plugin;
    public Gold(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("gold"))
        {
            Player p = (Player) sender;
            if (p.hasPermission("nonamedorg.gold"))
            {
                if (args.length == 1)
                {
                    final Player target = Bukkit.getServer().getPlayer(args[0]);
                    Util.bcastMsg(ChatColor.RED + p.getName() +  " - GOLD'ing " + target.getName() + ".");
                
                    new BukkitRunnable()
                    {
                        @Override
                        public void run()
                        {
                            target.setHealth(0);
                            target.sendMessage(ChatColor.RED + "IT'S GOLD NOT BUDDER OR BUTTER YOU SKYFAG");
                            Util.bcastMsg(ChatColor.RED + target.getName() + " is a Sky fan -_-");
                        }
                    }.runTaskLater(plugin, 5L * 2L);
                    return true;
                }
                else
                {
                    p.sendMessage(Main.NOT_ENOUGH_ARGS);
                    return true;
                }
            }
            else
            {
                Main.noPermission(p);
                return true;
            }
        }
        return false;
    }
}
