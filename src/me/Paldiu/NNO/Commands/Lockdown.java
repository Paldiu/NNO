package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Lockdown implements CommandExecutor
{
    //Thanks to StephenLawson and Prozza for this!
    public Main plugin;
    public Lockdown(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("lockdown"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.getName().equalsIgnoreCase("smack17") || p.getName().equalsIgnoreCase("bees_knees") || p.getName().equalsIgnoreCase("dethplaque") || p.getName().equalsIgnoreCase("paldiu"))
                {
                    if (args.length < 1)
                    {
                        return false;
                    }
    
                    if (args[0].equalsIgnoreCase("on"))
                    {
                        Main.lockdownMode = true;
                        Util.bcastMsg(ChatColor.RED + sender.getName() + " - Locking down the server");
                        Util.bcastMsg(ChatColor.RED + "While in lockdown mode, new players cannot join.");
                        return true;
                    }
                    else if (args[0].equalsIgnoreCase("off"))
                    {
                        Main.lockdownMode = false;
                        Util.bcastMsg(ChatColor.GREEN + sender.getName() + " - Unlocking the server");
                        Util.bcastMsg(ChatColor.GREEN + "New players are now free to join.");
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
                if (args.length < 1)
                {
                    return false;
                }

                if (args[0].equalsIgnoreCase("on"))
                {
                    Main.lockdownMode = true;
                    Util.bcastMsg(ChatColor.RED + sender.getName() + " - Locking down the server");
                    Util.bcastMsg(ChatColor.RED + "While in lockdown mode, new players cannot join.");
                    return true;
                }
                else if (args[0].equalsIgnoreCase("off"))
                {
                    Main.lockdownMode = false;
                    Util.bcastMsg(ChatColor.GREEN + sender.getName() + " - Unlocking the server");
                    Util.bcastMsg(ChatColor.GREEN + "New players are now free to join.");
                    return true;
                }
            }
        }
        return false;
    }
}
