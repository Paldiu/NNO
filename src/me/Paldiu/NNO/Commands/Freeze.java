package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.PlayerData;
import me.Paldiu.NNO.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Freeze implements CommandExecutor
{
    public Main plugin;
    public Freeze(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("freeze") || commandLabel.equalsIgnoreCase("fr"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.freeze"))
                {
                    if (args.length == 0)
                    {
                        Main.allPlayersFrozen = !Main.allPlayersFrozen;
            
                        if (Main.allPlayersFrozen)
                        {
                            Util.bcastMsg(ChatColor.AQUA + p.getName() + " - Freezing all players");
                            Main.allPlayersFrozen = true;
        
                            if (Main.freezePurgeTask != null)
                            {
                                Main.freezePurgeTask.cancel();
                            }
                            Main.freezePurgeTask = new BukkitRunnable()
                            {
                                @Override
                                public void run()
                                {
                                    Util.bcastMsg(ChatColor.AQUA + "FreezeTimer - Unfreezing all players");
                                    Main.allPlayersFrozen = false;
                                }
                            }.runTaskLater(plugin, 20L * 60L * 5L);
            
                            p.sendMessage(ChatColor.GRAY + "Players are now frozen.");
                        }
                        else
                        {
                            Util.bcastMsg(ChatColor.AQUA + p.getName() + " - Unfreezing all players");
                            Main.allPlayersFrozen = false;
                            if (Main.freezePurgeTask != null)
                            {
                                Main.freezePurgeTask.cancel();
                            }
                            p.sendMessage(ChatColor.GRAY + "Players are now free to move.");
                        }
                    }
                    else
                    {
                        if (args[0].toLowerCase().equals("purge"))
                        {
                            Main.allPlayersFrozen = false;
                            if (Main.freezePurgeTask != null)
                            {
                                Main.freezePurgeTask.cancel();
                            }
            
                            for (Player player : Bukkit.getServer().getOnlinePlayers())
                            {
                                PlayerData playerdata = PlayerData.getPlayerData(player);
                                playerdata.setFrozen(false);
                            }
            
                            Util.bcastMsg(ChatColor.AQUA + p.getName() + " - Lifting all global and player freezes");
                        }
                        else
                        {
                            Player player = Bukkit.getServer().getPlayer(args[0]);
            
                            PlayerData playerdata = PlayerData.getPlayerData(player);
                            playerdata.setFrozen(!playerdata.isFrozen());
            
                            p.sendMessage(ChatColor.GRAY + player.getName() + " has been " + (playerdata.isFrozen() ? "frozen" : "unfrozen") + ".");
                            player.sendMessage(ChatColor.AQUA + "You have been " + (playerdata.isFrozen() ? "frozen" : "unfrozen") + ".");
                        }
                    }
    
                    return true;
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
        return false;
    }
}