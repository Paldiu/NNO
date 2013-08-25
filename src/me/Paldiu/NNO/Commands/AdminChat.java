package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.PlayerData;
import me.Paldiu.NNO.Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminChat implements CommandExecutor
{
    public Main plugin;
    public AdminChat(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("adminchat") || commandLabel.equalsIgnoreCase("o"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.adminchat"))
                {
                    if (args.length == 0)
                    {
                        PlayerData userinfo = PlayerData.getPlayerData(p);
                        userinfo.setAdminChat(!userinfo.inAdminChat());
                        p.sendMessage(ChatColor.GRAY + "Toggled Admin Chat " + (userinfo.inAdminChat() ? "on" : "off") + ".");
                        return true;
                    }
                    else
                    {
                        Util.adminChatMessage(sender, StringUtils.join(args, " "));
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
                if (args.length == 0)
                {
                    sender.sendMessage("Only in-game players can toggle admin chat.");
                    return true;
                }
                else
                {
                    Util.adminChatMessage(sender, StringUtils.join(args, " "));
                    return true;
                }
            }
        }
        return true;
    }
}
