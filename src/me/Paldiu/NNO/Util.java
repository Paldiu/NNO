package me.Paldiu.NNO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class Util
{
    
    public static void createDefaultConfiguration(String name, File plugin_file)
    {
        Main main = Main.plugin;

        File actual = new File(main.getDataFolder(), name);
        if (!actual.exists())
        {
            JFLog.info("Installing default configuration file template: " + actual.getPath());
            InputStream input = null;
            try
            {
                JarFile file = new JarFile(plugin_file);
                ZipEntry copy = file.getEntry(name);
                if (copy == null)
                {
                    JFLog.severe("Unable to read default configuration: " + actual.getPath());
                    return;
                }
                input = file.getInputStream(copy);
            }
            catch (IOException ioex)
            {
                JFLog.severe("Unable to read default configuration: " + actual.getPath());
            }
            if (input != null)
            {
                FileOutputStream output = null;

                try
                {
                    main.getDataFolder().mkdirs();
                    output = new FileOutputStream(actual);
                    byte[] buf = new byte[8192];
                    int length;
                    while ((length = input.read(buf)) > 0)
                    {
                        output.write(buf, 0, length);
                    }

                    JFLog.info("Default configuration file written: " + actual.getPath());
                }
                catch (IOException ioex)
                {
                    JFLog.severe("Unable to write default configuration: " + actual.getPath() + "\n" + ExceptionUtils.getStackTrace(ioex));
                }
                finally
                {
                    try
                    {
                        if (input != null)
                        {
                            input.close();
                        }
                    }
                    catch (IOException ioex)
                    {
                    }

                    try
                    {
                        if (output != null)
                        {
                            output.close();
                        }
                    }
                    catch (IOException ioex)
                    {
                    }
                }
            }
        }
    }
    
    public static void bcastMsg(String message, ChatColor color)
    {
        JFLog.info(message, true);

        for (Player p : Bukkit.getOnlinePlayers())
        {
            p.sendMessage((color == null ? "" : color) + message);
        }
    }

    public static void bcastMsg(String message)
    {
        Util.bcastMsg(message, null);
    }

    public static void adminAction(Player adminName, String action, boolean isRed)
    {
        Util.bcastMsg(adminName + " - " + action, (isRed ? ChatColor.RED : ChatColor.AQUA));
    }

    public static boolean isNewPlayer(Player player)
    {
        OfflinePlayer[] offlinePlayers = Bukkit.getServer().getOfflinePlayers();
        boolean newPlayer = true;
        for (OfflinePlayer offlinePlayer : offlinePlayers)
        {
            if (offlinePlayer.getName().equals(player.getName()))
            {
                newPlayer = false;
            }
        }
        return newPlayer;
    }
}
