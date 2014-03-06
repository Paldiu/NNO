package me.Paldiu.NNO;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;
import me.Paldiu.NNO.Commands.*;
import me.Paldiu.NNO.Listeners.ChatListener;
import me.Paldiu.NNO.Listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin {
    
        // THIS HAS BEEN COMMENTED AS THE FUNCTION IS NO LONGER USED. YOU MAY IMPLEMENT IT IN THE FUTURE.
        // public static String MSG_NO_PERMS = ChatColor.RED + "You do not have permission to use this command!";
    
    public static String NOT_FROM_CONSOLE = ChatColor.RED + "This command cannot be used from the console!";
	public static String PLAYER_NOT_FOUND = ChatColor.RED + "The defined player is not online!";
	public static String ONLY_SUPERPOSITION = ChatColor.RED + "Only the plugin developer and the Owner/Co-Owner(s) are allowed to use this command!";
    public static String NO_REASON_GIVEN = ChatColor.RED + "There was no reason given therefore the command could not complete a revolution.";
    public static String TOO_MANY_ARGS = ChatColor.RED + "Too many arguments!";
    public static String NOT_ENOUGH_ARGS = ChatColor.RED + "Not enough arguments!";
    public static String UNKNOWN_COMMAND = ChatColor.RESET + "Unknown command. Type \"help\" for help.";
    public static Main plugin;
    public static String pluginName = "";
    public static File plugin_file = null;
    public static final String CONFIG_FILE = "config.yml";
    public static final String CAKE_LYRICS = "But there's no sense crying over every mistake. You just keep on trying till you run out of cake.";
    public static boolean lockdownMode = false;
    public static Server server = Bukkit.getServer();
    public static boolean allPlayersFrozen = false;
    public static BukkitTask freezePurgeTask = null;
    public static Map<Player, Double> fuckoffEnabledFor = new HashMap<Player, Double>();
    
    @Override
    public void onLoad()
    {
        Main.plugin = this;
        Main.pluginName = this.getDescription().getName();
    }
        
    @Override
	public void onEnable() 
	{
        this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        //Configuration
        this.getConfig().load();
        //LOG
		JF_Log.info(String.format("[%s] Version: %s by %s has been Enabled!", getDescription().getName(), getDescription().getVersion(), getDescription().getAuthors()));
	}
        
    @Override
	public void onDisable() 
	{
		JF_Log.info(String.format("[%s] Has been Disabled!", getDescription().getName()));
	}
        
        
    //Default (Command) No Permissions
    public static void noPermission(Player player)
    {
        player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
        Util.bcastMsg(ChatColor.RED + player.getName() + " has been superslapped!");
        Location l = player.getLocation();
        l.setY(132);
        player.teleport(l);
        player.setVelocity(new Vector(0,10,0));
    }
     
    //Alternate (Command) No Permissions
    public static void noPermission(CommandSender sender)
    {
        Player player = (Player) sender;
        player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command.");
        Util.bcastMsg(ChatColor.RED + player.getName() + " has been superslapped!");
        Location l = player.getLocation();
        l.setY(132);
        player.teleport(l);
        player.setVelocity(new Vector(0,10,0));
    }
}
