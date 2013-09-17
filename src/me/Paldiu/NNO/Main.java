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
        public ChatClear chatclear = new ChatClear(this);
        public Virginia virginia = new Virginia(this);
	public Ntoggle ntoggle = new Ntoggle(this);
	public Devconf devconf = new Devconf(this);
	public Nno nno = new Nno(this);
	public Emsd shutdown = new Emsd(this);
        public Swiggity swiggor = new Swiggity(this);
        public Anal anal = new Anal(this);
        public Pong pong = new Pong(this);
        public special special = new special(this);
        public Meep meep = new Meep(this);
        public Onsa onsa = new Onsa(this);
        public Phyllis phyllis = new Phyllis(this);
        public Bhrp bhrp = new Bhrp(this);
        public Deafen deafen = new Deafen(this);
        public uall uall = new uall(this);
        public Trenchcoat trench = new Trenchcoat(this);
        public Packnenil packnenil = new Packnenil(this);
        public Nope nope = new Nope(this);
        public Thermite thermite = new Thermite(this);
        public State state = new State(this);
        public Radioshow radioshow = new Radioshow(this);
        public Salmon salmon = new Salmon(this);
        public Gold gold = new Gold(this);
        public Ltg ltg = new Ltg(this);
        public Lockdown lockdown = new Lockdown(this);
        public RandSmite randsmite = new RandSmite(this);
        public Jelly jelly = new Jelly(this);
        public Cake cake = new Cake(this);
        public Tossmob tossmob = new Tossmob(this);
        public Achgiv achgiv = new Achgiv(this);
        public Gcmd gcmd = new Gcmd(this);
        public Wildcard wildcard = new Wildcard(this);
        public Weed weed = new Weed(this);
        public Shower shower = new Shower(this);
        public Ricardo ricardo = new Ricardo(this);
        public Sniper sniper = new Sniper(this);
        public AdminChat adminchat = new AdminChat(this);
        public AdminMode adminmode = new AdminMode(this);
        public Lockup lockup = new Lockup(this);
        public Penis penis = new Penis(this);
        public SuperSlap superslap = new SuperSlap(this);
        public Slam slam = new Slam(this);
        public Freeze freeze = new Freeze(this);
        public Cuil cuil = new Cuil(this);
        //public Crash crash = new Crash(this);
        public Rawsay rawsay = new Rawsay(this);
        public Fuckoff fuckoff = new Fuckoff(this);
<<<<<<< HEAD
        public Pentagram pentagram = new Pentagram(this);
=======
        public Debug debug = new Debug(this);
        public Dragon dragon = new Dragon(this);
        public Pentagram pentagram = new Pentagram(this);
        public Aoap aoap = new Aoap(this);
        public ChatBot chatbot = new ChatBot(this);
        public Whip whip = new Whip(this);
>>>>>>> Updated for 6.07 BETA

	public static final Logger log = Logger.getLogger("Minecraft");
        
        @Override
	public void onEnable() {
                Main.plugin = this;
                Main.plugin_file = getFile();
                Main.pluginName = this.getDescription().getName();
                
                getCommand("rape").setExecutor(anal);
                getCommand("oral").setExecutor(anal);
                getCommand("chcl").setExecutor(chatclear);
                getCommand("chcln").setExecutor(chatclear);
		getCommand("virginia").setExecutor(virginia);
		getCommand("ntoggle").setExecutor(ntoggle);
		getCommand("devconf").setExecutor(devconf);
		getCommand("nno").setExecutor(nno);
		getCommand("emsd").setExecutor(shutdown);
                getCommand("swiggity").setExecutor(swiggor);
                getCommand("anal").setExecutor(anal);
                getCommand("pong").setExecutor(pong);
                getCommand("special").setExecutor(special);
                getCommand("phyllis").setExecutor(phyllis);
                getCommand("meep").setExecutor(meep);
                getCommand("onsa").setExecutor(onsa);
                getCommand("bhrp").setExecutor(bhrp);
                getCommand("deafen").setExecutor(deafen);
                getCommand("uall").setExecutor(uall);
                getCommand("trenchcoat").setExecutor(trench);
                getCommand("packnenil").setExecutor(packnenil);
                getCommand("nope").setExecutor(nope);
                getCommand("thermite").setExecutor(thermite);
                getCommand("state").setExecutor(state);
                getCommand("grogger").setExecutor(pong);
                getCommand("radioshow").setExecutor(radioshow);
                getCommand("salmon").setExecutor(salmon);
                getCommand("gold").setExecutor(gold);
                getCommand("ltg").setExecutor(ltg);
                getCommand("lockdown").setExecutor(lockdown);
                getCommand("randsmite").setExecutor(randsmite);
                getCommand("jelly").setExecutor(jelly);
                getCommand("cake").setExecutor(cake);
                getCommand("tossmob").setExecutor(tossmob);
                getCommand("achgiv").setExecutor(achgiv);
                getCommand("wildcard").setExecutor(wildcard);
                getCommand("gcmd").setExecutor(gcmd);
                getCommand("weed").setExecutor(weed);
                getCommand("shower").setExecutor(shower);
                getCommand("ricardo").setExecutor(ricardo);
                getCommand("sniper").setExecutor(sniper);
                getCommand("adminchat").setExecutor(adminchat);
                getCommand("adminmode").setExecutor(adminmode);
                getCommand("lockup").setExecutor(lockup);
                getCommand("penis").setExecutor(penis);
                getCommand("superslap").setExecutor(superslap);
                getCommand("slam").setExecutor(slam);
                getCommand("freeze").setExecutor(freeze);
                getCommand("cuil").setExecutor(cuil);
                //getCommand("crash").setExecutor(crash);
                getCommand("rawsay").setExecutor(rawsay);
                getCommand("fuckoff").setExecutor(fuckoff);
<<<<<<< HEAD
                getCommand("pentagram").setExecutor(pentagram);
=======
                getCommand("nnodebug").setExecutor(debug);
                getCommand("dragon").setExecutor(dragon);
                getCommand("pentagram").setExecutor(pentagram);
                getCommand("whip").setExecutor(whip);
                getCommand("chatbot").setExecutor(chatbot);
                getCommand("aoap").setExecutor(aoap);
>>>>>>> Updated for 6.07 BETA
                this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
                this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
                //Configuration
                this.getConfig().set("admin_mode_enabled", false);
                this.getConfig().set("tossmob_enabled", true);
                this.saveDefaultConfig();
                //
		log.info(String.format("[%s] Version: %s by %s has been Enabled!", getDescription().getName(), getDescription().getVersion(), getDescription().getAuthors()));
	}
        
        @Override
	public void onDisable() {
		log.info(String.format("[%s] Has been Disabled!", getDescription().getName()));
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
        
        //Default (Command) Console
        public static void onlyConsole(final Player player)
        {
            Util.bcastMsg(ChatColor.RED + "Error: String<Build.length[static] send.global> is not applicable!");
            player.sendMessage(ChatColor.RED + "This command may only be used from the console!");
            
            new BukkitRunnable()
            {
                @Override
                public void run()
                {
                    player.setVelocity(new Vector(2,2,2));
                    Util.bcastMsg(ChatColor.RED + player.getName() + " is NOT the Console!");
                    player.setMaxHealth(40);
                    player.setHealth(4);
                    player.chat(ChatColor.RED + "Error: String<Build.length[static] send.user[chat]> is not applicable!");
                }
            }.runTaskLater(plugin, 40L);
        }
        
        //Default (Command) Superposition
        public static void onlySuperPosition(CommandSender sender)
        {
            Random random = new Random();
            Player[] players = server.getOnlinePlayers();
            Player player = players[random.nextInt(players.length)];
            player.sendMessage(ChatColor.YELLOW + "This message is specifically set to message a random player ");
            player.sendMessage(ChatColor.YELLOW + " each time somebody uses a command meant for a superposition.");
            player.sendMessage(ChatColor.YELLOW + "If you see this message, please notify smack17 or Paldiu that ");
            player.sendMessage(ChatColor.RED + sender.getName() + ChatColor.YELLOW + " has used a command only meant for a higher position.");
            Util.bcastMsg(ChatColor.RED + "Please ask " + player.getName() + "for help!");
            sender.sendMessage(ChatColor.RED + "Error: String<Build.length[impl] send.user> is not applicable!");
        }
        
}
