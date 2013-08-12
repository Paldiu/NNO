package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Emsd implements CommandExecutor
{
    public Main plugin;
    
            public Emsd(Main instance)
            {
                plugin = instance;
            }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("emsd"))
        {   
            
        Player p = (Player) sender;
        if(p.getName().equalsIgnoreCase("smack17") || p.getName().equalsIgnoreCase("dethplaque") || p.getName().equalsIgnoreCase("bees_knees"))
        {
            Bukkit.getServer().broadcastMessage("Server is going into emergency shutdown mode! Please hold your asses!");
            
            new BukkitRunnable()
            {
                @Override
                public void run()
                {
                    Bukkit.getServer().shutdown();
                }
            }.runTaskLater(plugin, 20L * 2L);
            return true;
        }
        else
        {
            sender.sendMessage(Main.MSG_NO_PERMS);
        }
    }
        return true;
    }
}