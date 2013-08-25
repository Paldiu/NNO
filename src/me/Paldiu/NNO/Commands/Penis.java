package me.Paldiu.NNO.Commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.ChatColor;
import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;

public class Penis implements CommandExecutor
{
    public Main plugin;
    public Penis(Main instance)
    {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("penis"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.penis"))
                {
                    Util.bcastMsg(ChatColor.RED + p.getName() + " has jacked off so hard their penis came off!");
                    p.damage(6);
                    p.sendMessage(ChatColor.YELLOW + "You need to stop jerking off so much. Holy fuck.");
                }
                else
                {
                    Main.noPermission(p);
                }
            }
            else
            {
                sender.sendMessage(Main.NOT_FROM_CONSOLE);
            }

            return true;
        }
        return false;
    }
}
