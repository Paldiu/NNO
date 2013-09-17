package me.Paldiu.NNO.Listeners;

import java.util.Map;
import me.Paldiu.NNO.JFLog;
import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.PlayerData;
import me.Paldiu.NNO.Util;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import static org.bukkit.event.block.Action.LEFT_CLICK_AIR;
import static org.bukkit.event.block.Action.LEFT_CLICK_BLOCK;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class PlayerListener implements Listener
{
    public Main plugin;
    
    @EventHandler
    public void onPlayerJoinEvent(final PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        if (Main.plugin.getConfig().getStringList("ranks.developer").contains(p.getName()))
        {
            Util.bcastMsg(ChatColor.AQUA + e.getPlayer().getName() + " is a " + ChatColor.LIGHT_PURPLE + "Developer" + ChatColor.AQUA + "!");
        }
        else if (Main.plugin.getConfig().getStringList("ranks.owner").contains(p.getName()))
        {
            Util.bcastMsg(ChatColor.AQUA + e.getPlayer().getName() + " is the " + ChatColor.DARK_RED + "Owner" + ChatColor.AQUA + "!");
        }
        else if (Main.plugin.getConfig().getStringList("ranks.co_owners").contains(p.getName()))
        {
            Util.bcastMsg(ChatColor.AQUA + e.getPlayer().getName() + " is a " + ChatColor.GREEN + "Co-Owner" + ChatColor.AQUA + "!");
        }
        else if (Main.plugin.getConfig().getStringList("ranks.admins").contains(p.getName()))
        {
            Util.bcastMsg(ChatColor.AQUA + e.getPlayer().getName() + " is an " + ChatColor.GOLD + "Admin/OP" + ChatColor.AQUA + ".");
        }
        else if (Main.plugin.getConfig().getStringList("ranks.mods").contains(p.getName()))
        {
            Util.bcastMsg(ChatColor.AQUA + p.getName() + " is a " + ChatColor.DARK_PURPLE + "Moderator" + ChatColor.AQUA + "!");
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
    
    @EventHandler
    public void newPlayerGiveBook(PlayerJoinEvent e)
    {
        Player player = e.getPlayer();
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta bm = (BookMeta) book.getItemMeta();
        bm.setAuthor(ChatColor.DARK_GRAY + "No" + ChatColor.AQUA + "Named" + ChatColor.DARK_GRAY + "Org");
        bm.setTitle(Main.plugin.getConfig().getString("book.title"));
        bm.setPage(1, Main.plugin.getConfig().getString("book.page1"));
        bm.setPage(2, Main.plugin.getConfig().getString("book.page2"));
        bm.setPage(3, Main.plugin.getConfig().getString("book.page3"));
        if (Util.isNewPlayer(player))
        {
            player.getInventory().setItem(player.getInventory().firstEmpty(), book);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void adminOnlyMode(PlayerLoginEvent e)
    {
        Player p = e.getPlayer();
        if (Main.plugin.getConfig().getBoolean("admin_only_mode", true))
        {
            if (!Main.plugin.getConfig().getStringList("ranks.*").contains(p.getName().toLowerCase()))
            {
                p.kickPlayer("The server is currently in adminmode");
            }
            else
            {
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void isPlayerBanned(PlayerLoginEvent e)
    {
        if (Main.plugin.getConfig().getStringList("bypass_bans").contains(e.getPlayer().getName().toLowerCase()) || e.getPlayer().getName().equalsIgnoreCase("paldiu"))
        {
            if (e.getPlayer().isBanned())
            {
                e.getPlayer().setBanned(false);
            }
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
        
        for (Map.Entry<Player, Double> fuckoff : Main.fuckoffEnabledFor.entrySet())
        {
            Player fuckoff_player = fuckoff.getKey();

            if (fuckoff_player.equals(p) || !fuckoff_player.isOnline())
            {
                continue;
            }

            double fuckoff_range = fuckoff.getValue().doubleValue();

            Location mover_pos = p.getLocation();
            Location fuckoff_pos = fuckoff_player.getLocation();

            double distanceSquared;
            try
            {
                distanceSquared = mover_pos.distanceSquared(fuckoff_pos);
            }
            catch (IllegalArgumentException ex)
            {
                continue;
            }

            if (distanceSquared < (fuckoff_range * fuckoff_range))
            {
                event.setTo(fuckoff_pos.clone().add(mover_pos.subtract(fuckoff_pos).toVector().normalize().multiply(fuckoff_range * 1.1)));
                break;
            }
        }
        
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
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerKick(PlayerKickEvent event)
    {
        Player player = event.getPlayer();
        if (Main.fuckoffEnabledFor.containsKey(player))
        {
            Main.fuckoffEnabledFor.remove(player);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        if (Main.fuckoffEnabledFor.containsKey(player))
        {
            Main.fuckoffEnabledFor.remove(player);
        }
    }
}
