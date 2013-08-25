package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ricardo implements CommandExecutor
{
    public Main plugin;
    public Ricardo(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("ricardo"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.ricardo"))
                {
                    Util.bcastMsg(p.getName() + "'s real name isn't actually " + p.getName() + ", its really Ricardo!", ChatColor.BLUE);
                    p.setDisplayName(ChatColor.RED + "Ricardo");
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
        return true;
    }
}
