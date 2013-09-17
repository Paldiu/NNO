package me.Paldiu.NNO.Commands;

import java.util.List;
import me.Paldiu.NNO.Util;
import me.Paldiu.NNO.Main;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class ChatBot implements CommandExecutor
{
    private List<String> Dev = Main.plugin.getConfig().getStringList("ranks.developer");
    public Main plugin;
    public ChatBot(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("chatbot"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (Dev.contains(p.getName()))
                {
                    if (args.length != 1)
                    {
                        return false;
                    }
                    else
                    {
                        Util.ChatBot((Util.colorise(StringUtils.join(args, " "))));
                    }
                }
                else
                {
                    p.sendMessage(ChatColor.RED + "You don't have permission!");
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
