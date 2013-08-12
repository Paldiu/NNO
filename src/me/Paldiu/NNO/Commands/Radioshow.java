/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class Radioshow implements CommandExecutor
{
    public Main plugin;
    public Radioshow(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("radioshow"))
        {
            Player p = (Player) sender;
            if (p.hasPermission("nonamedorg.radioshow"))
            {
                Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "The infinitive process radio show, with Paldiu and Smack17!");
                Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Some dude you STILL will never ever know, because fuck you!");
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
