package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Meep implements CommandExecutor
{
    public Main plugin;
    public Meep(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player p = (Player) sender;
        if (commandLabel.equalsIgnoreCase("meep"))
        {
            if (p.hasPermission("nonamedorg.meep"))
            {
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + p.getName() + " has just MEEPED THE FUCK OUT OF EVERYTHING.");
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