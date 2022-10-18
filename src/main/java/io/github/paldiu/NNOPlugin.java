package io.github.paldiu;

import io.github.paldiu.Commands.AdminChatCMD;
import io.github.paldiu.config.Config;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.CommandLoader;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.reflections.Reflections;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class NNOPlugin extends JavaPlugin {
    public static Component PLAYER_NOT_FOUND = Component.empty().content("The specified player cannot be found.").color(BasicColors.RED.getColor());
    public static Component NOT_ENOUGH_ARGS = Component.empty().content("Not enough arguments.").color(BasicColors.RED.getColor());
    public static String pluginName = "";

    public final String CAKE_LYRICS = "But there's no sense crying over every mistake. You just keep on trying till you run out of cake.";
    private final Reflections reflections = new Reflections(AdminChatCMD.class);
    private final String fileName = "config.yml";
    private final File configFile = new File(getDataFolder(), fileName);
    public Server server = Bukkit.getServer();
    public boolean allPlayersFrozen = false;
    public BukkitTask freezePurgeTask = null;
    public Map<Player, Double> fuckoffEnabledFor = new HashMap<Player, Double>();
    public Config pluginConfig;
    public boolean lockdownMode = false;

    @Override
    public void onLoad() {
        NNOPlugin.pluginName = this.getDescription().getName();
    }

    @Override
    public void onEnable() {
        //Configuration
        pluginConfig = new Config(this, fileName, getDataFolder(), configFile.exists());
        //Commands
        CommandLoader loader = new CommandLoader(this, "NNO-PLUGIN");
        loadCommands(loader);
        //LOG
        JFLog.info(String.format("[%s] Version: %s by %s has been Enabled!", getDescription().getName(), getDescription().getVersion(), getDescription().getAuthors()));
    }

    @Override
    public void onDisable() {
        JFLog.info(String.format("[%s] Has been Disabled!", getDescription().getName()));
    }

    private void loadCommands(CommandLoader loader) {
        reflections.getSubTypesOf(CommandBase.class).forEach(cmd -> {
            Util.sneakyTry(() -> {
                if (!cmd.isAnnotationPresent(Info.class)) {
                    JFLog.warning("Command " + cmd.getSimpleName() + " is missing the required annotation! Skipping...");
                    return;
                }
                Constructor<? extends CommandBase> constructor = cmd.getDeclaredConstructor(NNOPlugin.class);
                loader.register(constructor.newInstance(this));
            });
        });
        loader.load();
    }

    public final Config getPluginConfig() {
        return pluginConfig;
    }
}
