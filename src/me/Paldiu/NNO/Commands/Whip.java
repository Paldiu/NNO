package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Whip implements CommandExecutor
{
    public Main plugin;
    public Whip(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("whip"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.whip"))
                {
                    if (args.length != 1)
                    {
                        return false;
                    }
                    else
                    {
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        Util.bcastMsg(ChatColor.RED + target.getName() + " has been a naughty, naughty boy.");
                        Util.ChatBot(p.getName() + ": Whipping " + target.getName() + ".");
                        target.damage(8);
                        target.sendMessage(ChatColor.GRAY + "You have been whipped.");
                    }
                }
                else
                {
                    Main.noPermission(p);
                    Util.ChatBot(p.getName() + " just used a disciplinary command!");
                }
            }
            else
            {
                
            }
            
            return true;
        }
        
        return false;
    }
}
