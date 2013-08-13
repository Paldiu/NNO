package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.Bukkit;
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
            if (args.length == 1)
            {
                if (p.hasPermission("nonamedorg.gold"))
                {
                    final Player target = Bukkit.getServer().getPlayer(args[0]);
                    Util.adminAction(p, "GOLD'ing " + target.getName() + ".", true);
                
                    new BukkitRunnable()
                    {
                        @Override
                        public void run()
                        {
                            target.kickPlayer("IT'S GOLD NOT BUDDER OR BUTTER YOU SKYFAG");
                            Util.bcastMsg(target.getName() + " is a sky fan!");
                        }
                    }.runTaskLater(plugin, 20L * 2L);
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
                p.sendMessage(Main.NOT_ENOUGH_ARGS);
                return true;
            }
        }
        return false;
    }
}
