package me.Paldiu.NNO.Commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ChatClear implements CommandExecutor
{
    public Main plugin;
    public ChatClear(Main instance){
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player p = (Player) sender;
        if (commandLabel.equalsIgnoreCase("chcl"))
        {
            if(p.hasPermission("nonamedorg.chatclear"))
            {
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage(ChatColor.RED + "Your chat has been cleared!");
                return true;
            }
            else
            {
                p.sendMessage(Main.MSG_NO_PERMS);
                return true;
            }
            
        }
        
        else if (commandLabel.equalsIgnoreCase("chcln"))
        {
            if (p.hasPermission("nonamedorg.chatclear"))
            {
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("");
                return true;
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