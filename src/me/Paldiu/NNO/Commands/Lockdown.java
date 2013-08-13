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
            Player p = (Player) sender;
            if (p.hasPermission("nonamedorg.lockdown"))
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
                p.sendMessage(Main.MSG_NO_PERMS);
                return true;
            }
        }
        return false;
    }
}
