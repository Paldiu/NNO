package me.Paldiu.NNO;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class PlayerListener implements Listener
{
    public Main plugin;
    
    @EventHandler
    public void onPlayerJoinEvent(final PlayerJoinEvent e)
    {
        if (e.getPlayer().getName().equalsIgnoreCase("Paldiu"))
        {
            Bukkit.getServer().broadcastMessage(ChatColor.AQUA + e.getPlayer().getName() + " is a " + ChatColor.LIGHT_PURPLE + "Developer" + ChatColor.AQUA + "!");
        }
        else if (e.getPlayer().getName().equalsIgnoreCase("smack17"))
        {
            Bukkit.getServer().broadcastMessage(ChatColor.AQUA + e.getPlayer().getName() + " is the " + ChatColor.DARK_RED + "Owner" + ChatColor.AQUA + "!");
        }
        else if (e.getPlayer().getName().equalsIgnoreCase("bees_knees") || e.getPlayer().getName().equalsIgnoreCase("dethplaque"))
        {
            Bukkit.getServer().broadcastMessage(ChatColor.AQUA + e.getPlayer().getName() + " is a " + ChatColor.GREEN + "Co-Owner" + ChatColor.AQUA + "!");
        }
        else if (e.getPlayer().getName().equalsIgnoreCase("austindapro") || e.getPlayer().getName().equalsIgnoreCase("mustardbukkit") || e.getPlayer().getName().equalsIgnoreCase("nerdygirl544") || e.getPlayer().getName().equalsIgnoreCase("soccerkiff") || e.getPlayer().getName().equalsIgnoreCase("spartan12233th"))
        {
            Bukkit.getServer().broadcastMessage(ChatColor.AQUA + e.getPlayer().getName() + " is an " + ChatColor.GOLD + " Admin" + ChatColor.AQUA + ".");
        }
        else
        {
        }
    }
}
