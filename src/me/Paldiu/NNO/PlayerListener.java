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
            }
        }.runTaskLater(plugin, 60L * 2L);
    }
}
