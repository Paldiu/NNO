package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.PlayerData;
import me.Paldiu.NNO.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Lockup implements CommandExecutor
{
    public Main plugin;
    public Lockup(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("lockup"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.lockup"))
                {
                    if (args.length == 1)
                    {
                        if (args[0].equalsIgnoreCase("all"))
                        {
                            Util.bcastMsg(ChatColor.RED + sender.getName() + " - Locking up all players");
            
                            for (Player player : Bukkit.getServer().getOnlinePlayers())
                            {
                                startLockup(player);
                            }
                            p.sendMessage("Locked up all players.");
                            Util.ChatBot(p.getName() + ": Locked up all players.");
                        }
                        else if (args[0].equalsIgnoreCase("purge"))
                        {
                            Util.bcastMsg(ChatColor.RED + sender.getName() + " - Unlocking all players");
                            for (Player player : Bukkit.getServer().getOnlinePlayers())
                            {
                                cancelLockup(player);
                            }
            
                            p.sendMessage("Unlocked all players.");
                            Util.ChatBot(p.getName() + ": Unlocked all players.");
                        }
                        else
                        {
                            return false;
                        }
                    }
                    else if (args.length == 2)
                    {
                        if (args[1].equalsIgnoreCase("on"))
                        {
                            final Player player = Bukkit.getServer().getPlayer(args[0]);

                            Util.bcastMsg(ChatColor.RED + sender.getName() + " - Locking up " + player.getName());
                            startLockup(player);
                            p.sendMessage("Locked up " + player.getName() + ".");
                            Util.ChatBot(p.getName() + ": Locked up " + player.getName() + ".");
                        }
                        else if (Util.isStopCommand(args[1]))
                        {
                            final Player player = Bukkit.getServer().getPlayer(args[0]);
            
                            Util.bcastMsg(ChatColor.RED + sender.getName() + " - Unlocking " + player.getName());
                            cancelLockup(player);
                            Util.ChatBot(p.getName() + ": Unlocked " + player.getName() + ".");
                            p.sendMessage("Unlocked " + player.getName() + ".");
                        }
                        else
                        {
                            return false;
                        }
                    }
                    else
                    {
                        return false;
                    }

                    return true;
                }
                else
                {
                    Main.noPermission(p);
                    Util.ChatBot(p.getName() + " just tried to use a disciplinary command!");
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
    
    private void cancelLockup(PlayerData playerdata)
    {
        BukkitTask lockupScheduleID = playerdata.getLockupScheduleID();
        if (lockupScheduleID != null)
        {
            lockupScheduleID.cancel();
            playerdata.setLockupScheduleID(null);
        }
    }
    
    private void cancelLockup(final Player player)
    {
        cancelLockup(PlayerData.getPlayerData(player));
    }

    private void startLockup(final Player player)
    {
        final PlayerData playerdata = PlayerData.getPlayerData(player);

        cancelLockup(playerdata);

        playerdata.setLockupScheduleID(new BukkitRunnable()
        {
            @Override
            public void run()
            {
                if (player.isOnline())
                {
                    player.openInventory(player.getInventory());
                }
                else
                {
                    cancelLockup(playerdata);
                }
            }
        }.runTaskTimer(plugin, 0L, 5L));
    }
}
