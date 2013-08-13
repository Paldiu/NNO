package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ltg implements CommandExecutor
{
    public Main plugin;
    public Ltg(Main instance) 
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("ltg"))
        {
            Player p = (Player) sender;
            if (sender instanceof Player)
            {
                if (p.hasPermission("nonamedorg.ltg"))
                {
                    Util.bcastMsg(p.getName() + " has just lost the game!");
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
                sender.sendMessage(Main.NOT_FROM_CONSOLE);
                return true;
            }
        }
        return false;
    }
}
