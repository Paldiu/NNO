package me.Paldiu.NNO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;

public class Util
{
    public static final Map<String, EntityType> mobtypes = new HashMap<String, EntityType>();
    public static final List<String> DEVELOPERS = Arrays.asList("Paldiu");
    public static final List<String> STOP_COMMANDS = Arrays.asList("stop", "off", "end", "halt", "die");
    
    static
    {
        for (EntityType entity_type : EntityType.values())
        {
            try
            {
                if (entity_type.getName() != null)
                {
                    if (Creature.class.isAssignableFrom(entity_type.getEntityClass()))
                    {
                        mobtypes.put(entity_type.getName().toLowerCase(), entity_type);
                    }
                }
            }
            catch (Exception ex)
            {
            }
        }
    }
    
    private Util()
    {
        throw new AssertionError();
    }
    
    
    public static void setConfig(FileConfiguration config)
    {
        config.addDefault("tossmob_enabled", true);
        config.addDefault("admin_only_mode", false);
    }
    
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
    
    public static String formatLocation(Location in_loc)
    {
        return String.format("%s: (%d, %d, %d)",
                in_loc.getWorld().getName(),
                Math.round(in_loc.getX()),
                Math.round(in_loc.getY()),
                Math.round(in_loc.getZ()));
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
    
    public static boolean isStopCommand(String command)
    {
        return STOP_COMMANDS.contains(command.toLowerCase());
    }
    
    public static List<String> removeDuplicates(List<String> old_list)
    {
        List<String> new_list = new ArrayList<String>();
        for (String entry : old_list)
        {
            if (!new_list.contains(entry))
            {
                new_list.add(entry);
            }
        }
        return new_list;
    }
    
    public static void setWorldTime(World world, long ticks)
    {
        long time = world.getTime();
        time -= time % 24000;
        world.setTime(time + 24000 + ticks);
    }
    
    public static void adminChatMessage(CommandSender sender, String message)
    {
        String name = sender.getName() + " " + getPrefix(sender);
        JFLog.info("[ADMIN] " + name + ": " + message);

        for (Player player : Bukkit.getOnlinePlayers())
        {
            if (player.hasPermission("nonamedorg.adminchat.view"))
            {
                player.sendMessage("[" + ChatColor.AQUA + "ADMIN" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + name + ": " + ChatColor.AQUA + message);
            }
            else
            {
            }
        }
    }
    public static String getPrefix(CommandSender sender)
    {        
        String prefix;
        if (sender instanceof Player)
        {
            Player p = (Player) sender;
            if (p.getName().equalsIgnoreCase("smack17"))
            {
                prefix = ChatColor.AQUA + "(Owner)";
            }
            else if (p.getName().equalsIgnoreCase("bees_knees") || p.getName().equalsIgnoreCase("dethplaque"))
            {
                prefix = ChatColor.GREEN + "(Co-Owner)";
            }
            else
            {
                prefix = ChatColor.LIGHT_PURPLE + "(Mod)";
            }
            if (p.hasPermission("nonamedorg.adminchat.op"))
            {
                prefix = ChatColor.GOLD + "(Op)";
            }
            if (DEVELOPERS.contains(sender.getName()))
            {
                prefix = ChatColor.DARK_PURPLE + "(Dev)";
            }
        }
        else
        {
            prefix = ChatColor.BLUE + "(Console)";
        }
        
        return prefix + ChatColor.WHITE;
    }
    
    public static EntityType getEntityType(String mobname) throws Exception
    {
        mobname = mobname.toLowerCase().trim();

        if (!Util.mobtypes.containsKey(mobname))
        {
            throw new Exception();
        }

        return Util.mobtypes.get(mobname);
    }
}
