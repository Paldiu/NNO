package me.Paldiu.NNO;

import java.io.File;
import java.util.logging.Logger;
import me.Paldiu.NNO.Commands.Anal;
import me.Paldiu.NNO.Commands.Devconf;
import me.Paldiu.NNO.Commands.Virginia;
import me.Paldiu.NNO.Commands.Emsd;
import me.Paldiu.NNO.Commands.Nno;
import me.Paldiu.NNO.Commands.Ntoggle;
import me.Paldiu.NNO.Commands.Pong;
import me.Paldiu.NNO.Commands.Swiggity;
import me.Paldiu.NNO.Commands.special;
import me.Paldiu.NNO.Commands.Phyllis;
import me.Paldiu.NNO.Commands.Onsa;
import me.Paldiu.NNO.Commands.Meep;
import me.Paldiu.NNO.Commands.Bypass;
import me.Paldiu.NNO.Commands.Bhrp;
import me.Paldiu.NNO.Commands.Deafen;
import me.Paldiu.NNO.Commands.ChatClear;
import me.Paldiu.NNO.Commands.uall;
import me.Paldiu.NNO.Commands.Trenchcoat;
import me.Paldiu.NNO.Commands.Packnenil;
import me.Paldiu.NNO.Commands.Nope;
import me.Paldiu.NNO.Commands.Radioshow;
import me.Paldiu.NNO.Commands.State;
import me.Paldiu.NNO.Commands.Thermite;
import me.Paldiu.NNO.Commands.Salmon;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    
        public static String MSG_NO_PERMS = ChatColor.RED + "You do not have permission to use this command!";
        public static String NOT_FROM_CONSOLE = ChatColor.RED + "This command cannot be used from the console!";
	public static String PLAYER_NOT_FOUND = ChatColor.RED + "The defined player is not online!";
	public static String ONLY_SUPERPOSITION = ChatColor.RED + "Only the plugin developer and the Owner/Co-Owner(s) are allowed to use this command!";
        public static String NO_REASON_GIVEN = ChatColor.RED + "There was no reason given therefore the command could not complete a revolution.";
        public static String NOT_ENOUGH_ARGS = ChatColor.RED + "Not enough arguments!";
        public static Main plugin;
        public static String pluginName = "";
        public static File plugin_file = null;
        public static final String PERMBAN_FILE = "permban.yml";
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
        public Bypass bypass = new Bypass(this);
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

	public Logger log = Logger.getLogger("Minecraft");

	public void onEnable() {
                Main.plugin_file = getFile();
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
                getCommand("bptp").setExecutor(bypass);
                getCommand("bpkick").setExecutor(bypass);
                getCommand("bpban").setExecutor(bypass);
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
                this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		log.info(String.format("[%s] Version: %s by %s has been Enabled!", getDescription().getName(), getDescription().getVersion(), getDescription().getAuthors()));
	}

	public void onDisable() {
		log.info(String.format("[%s] Has been Disabled!", getDescription().getName()));
	}
}