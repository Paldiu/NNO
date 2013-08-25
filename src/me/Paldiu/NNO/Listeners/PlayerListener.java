package me.Paldiu.NNO.Listeners;

import me.Paldiu.NNO.JFLog;
import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.PlayerData;
import me.Paldiu.NNO.Util;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import static org.bukkit.event.block.Action.LEFT_CLICK_AIR;
import static org.bukkit.event.block.Action.LEFT_CLICK_BLOCK;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

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
            Bukkit.getServer().broadcastMessage(ChatColor.AQUA + e.getPlayer().getName() + " is an " + ChatColor.GOLD + "Admin" + ChatColor.AQUA + ".");
        }
        else
        {
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLogin(PlayerLoginEvent event)
    {
        Player player = event.getPlayer();
        if (Main.lockdownMode)
        {
            if (Util.isNewPlayer(player))
            {
                event.setResult(Result.KICK_BANNED);
                event.setKickMessage(ChatColor.RED + "Server is currently in lockdown mode, please come back in a few minutes.");
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void adminOnlyMode(PlayerLoginEvent e)
    {
        Player p = e.getPlayer();
        if (Main.adminOnlyMode)
        {
            if (!p.hasPermission("nonamedorg.adminmode.join"))
            {
                p.kickPlayer("AdminMode has been enabled. You cannot join until it is turned off.");
            }
            else
            {
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void isPlayerBanned(PlayerLoginEvent e)
    {
        if (e.getPlayer().getName().equalsIgnoreCase("smack17") || e.getPlayer().getName().equalsIgnoreCase("dethplaque") || e.getPlayer().getName().equalsIgnoreCase("bees_knees") || e.getPlayer().getName().equalsIgnoreCase("paldiu"))
        {
            if (e.getPlayer().isBanned())
            {
                e.getPlayer().setBanned(false);
            }
            else
            {
            }
        }
        else
        {
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();

        switch (event.getAction())
        {
            case LEFT_CLICK_AIR:
            case LEFT_CLICK_BLOCK:
            {
                switch (event.getMaterial())
                {
                    case STICK:
                    {
                        PlayerData playerdata = PlayerData.getPlayerData(player);
                        if (playerdata.mobThrowerEnabled())
                        {
                            Location player_pos = player.getLocation();
                            Vector direction = player_pos.getDirection().normalize();

                            LivingEntity rezzed_mob = (LivingEntity) player.getWorld().spawnEntity(player_pos.add(direction.multiply(2.0)), playerdata.mobThrowerCreature());
                            rezzed_mob.setVelocity(direction.multiply(playerdata.mobThrowerSpeed()));
                            playerdata.enqueueMob(rezzed_mob);

                            event.setCancelled(true);
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        try
        {
            final Player player = event.getPlayer();
            String message = event.getMessage().trim();

            PlayerData playerdata = PlayerData.getPlayerData(player);
            if (playerdata.inAdminChat())
            {
                Util.adminChatMessage(player, message);
                event.setCancelled(true);
            }
        }
        catch (Exception ex)
        {
            JFLog.severe(ex);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerMove(PlayerMoveEvent event)
    {
        final Location from = event.getFrom();
        final Location to = event.getTo();
        try
        {
            if (from.getWorld() == to.getWorld() && from.distanceSquared(to) < (0.0001 * 0.0001))
            {
                // If player just rotated, but didn't move, don't process this event.
                return;
            }
        }
        catch (IllegalArgumentException ex)
        {
        }
        
        Player p = event.getPlayer();
        PlayerData playerdata = PlayerData.getPlayerData(p);
        
        boolean do_freeze = false;
        if (Main.allPlayersFrozen)
        {
            if (!p.hasPermission("nonamedorg.freeze.not"))
            {
                do_freeze = true;
            }
        }
        else
        {
            if (playerdata.isFrozen())
            {
                do_freeze = true;
            }
        }

        if (do_freeze)
        {
            Location freezeTo = to.clone();

            freezeTo.setX(from.getX());
            freezeTo.setY(from.getY());
            freezeTo.setZ(from.getZ());

            event.setTo(freezeTo);
        }
    }
}
