package me.Paldiu.NNO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

public class Util
{
    public static final Map<String, EntityType> mobtypes = new HashMap<String, EntityType>();
    public static final List<String> STOP_COMMANDS = Arrays.asList("stop", "off", "end", "halt", "die");
    public static boolean method_crash = false;
    
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
    
    public static String formatLocation(Location in_loc)
    {
        return String.format("%s: (%d, %d, %d)",
                in_loc.getWorld().getName(),
                Math.round(in_loc.getX()),
                Math.round(in_loc.getY()),
                Math.round(in_loc.getZ()));
    }
    
    /*
    public static void crashServer(boolean crashServer)
    {
        if (crashServer)
        {
            method_crash = true;
        }
        else
        {
            method_crash = false;
        }
    }
    */
    
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
    
    public static void ChatBot(String message)
    {
        JFLog.info(message, true);
        
        for (Player player : Bukkit.getOnlinePlayers())
        {
            if (player.hasPermission("nonamedorg.adminchat.view"))
            {
                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "BOT" + ChatColor.WHITE + ChatColor.DARK_GRAY + "] " + ChatColor.YELLOW + "ChatBot" + ChatColor.RESET + ": " + ChatColor.DARK_AQUA + message);
            }
            else
            {
            }
        }
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
            if (Main.plugin.getConfig().getStringList("ranks.owner").contains(sender.getName().toLowerCase()))
            {
                prefix = ChatColor.DARK_GRAY + "(" + ChatColor.BLUE + "Owner" + ChatColor.DARK_GRAY + ")";
            }
            else if (Main.plugin.getConfig().getStringList("ranks.co_owners").contains(sender.getName().toLowerCase()))
            {
                prefix = ChatColor.DARK_GRAY + "(" + ChatColor.GREEN + "Co-Owner" + ChatColor.DARK_GRAY + ")";
            }
            else
            {
                prefix = ChatColor.DARK_GRAY + "(" + ChatColor.DARK_PURPLE + "Mod" + ChatColor.DARK_GRAY + ")";
            }
            if (Main.plugin.getConfig().getStringList("ranks.admins").contains(sender.getName().toLowerCase()))
            {
                prefix = ChatColor.DARK_GRAY + "(" + ChatColor.GOLD + "Op" + ChatColor.DARK_GRAY + ")";
            }
            if (Main.plugin.getConfig().getStringList("ranks.developer").contains(sender.getName().toLowerCase()))
            {
                prefix = ChatColor.DARK_GRAY + "(" + ChatColor.LIGHT_PURPLE + "Dev" + ChatColor.DARK_GRAY + ")";
            }
        }
        else
        {
            prefix = ChatColor.RED + "(Console)";
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
    
    public static String colorise(String string)
    {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
