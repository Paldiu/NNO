package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Rawsay implements CommandExecutor
{
    //Thanks to StephenLawson and Prozza for this!
    public Main plugin;
    public Rawsay(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("rawsay"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.rawsay"))
                {
                    if (args.length > 0)
                    {
                        Util.bcastMsg(Util.colorise(StringUtils.join(args, " ")));
                        return true;
                    }
                    else
                    {
                        return false;
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
                Util.bcastMsg(Util.colorise(StringUtils.join(args, " ")));
                return true;
            }
        }
        return false;
    }
}
