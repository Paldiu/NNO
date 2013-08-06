package me.Paldiu.NNO;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pgDev.bukkit.DisguiseCraft.DisguiseCraft;
import pgDev.bukkit.DisguiseCraft.api.DisguiseCraftAPI;

public class DCBridge
{
    private DCBridge()
    {
    }

    public boolean undisguisePlayer(Player player)
    {
        try
        {
            DisguiseCraftAPI api = DisguiseCraft.getAPI();
            if (api != null)
            {
                return api.undisguisePlayer(player);
            }
        }
        catch (Exception ex)
        {
            JFLog.severe(ex);
        }

        return false;
    }

    public void undisguiseAllPlayers()
    {
        try
        {
            DisguiseCraftAPI api = DisguiseCraft.getAPI();
            if (api != null)
            {
                Player[] players = Bukkit.getOnlinePlayers();
                for (Player player : players)
                {
                    api.undisguisePlayer(player);
                }
            }
        }
        catch (Exception ex)
        {
            JFLog.severe(ex);
        }
        
    }

    public static DCBridge getInstance()
    {
        return DCBridgeHolder.INSTANCE;
    }

    private static class DCBridgeHolder
    {
        private static final DCBridge INSTANCE = new DCBridge();
    }
}
