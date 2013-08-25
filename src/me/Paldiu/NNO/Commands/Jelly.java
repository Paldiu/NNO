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

public class Jelly implements CommandExecutor {

    public Main plugin;
    public Jelly(Main instance){
            plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if(commandLabel.equalsIgnoreCase("jelly"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (sender.hasPermission("nonamedorg.jelly"))
                {
                    if (args.length < 1)
                    {
                        p.sendMessage(Main.NOT_ENOUGH_ARGS);
                        return true;
                    }
            
                    else if (args.length > 1)
                    {
                        p.sendMessage(Main.TOO_MANY_ARGS);
                        return true;
                    }
            
                    else if (args.length == 1)
                    {
                        final Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
                        if (targetPlayer != null)
                        {
                           Util.bcastMsg(ChatColor.RED + "Hey " + targetPlayer.getName() + ", whats the difference between jelly and jam?");
            
                           new BukkitRunnable()
                           {
                               @Override
                               public void run()
                               {
                                   Util.bcastMsg(ChatColor.RED + "I can't jelly my banhammer up your ass.");
                               } 
                           }.runTaskLater(plugin, 40L);
            
                           new BukkitRunnable()
                           {
                               @Override
                               public void run()
                               {
                                   targetPlayer.kickPlayer(ChatColor.RED + "GTFO.");
                               }
                           }.runTaskLater(plugin, 80L);
                           return true;
                        }
                        else
                        {
                            p.sendMessage(Main.PLAYER_NOT_FOUND);
                            return true;
                        }
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
                sender.sendMessage(Main.NOT_FROM_CONSOLE);
                return true;
            }
        }
        return true;
    }
}