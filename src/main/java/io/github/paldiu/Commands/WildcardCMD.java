package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.paldiu.config.ConfigValues;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Info(name = "wildcard", description = "Runs a command for every user in the server. Use ? to substitute the players username.", usage = "/<command> ? ? ? ?")
public class WildcardCMD extends CommandBase {
    private final NNOPlugin plugin;

    public WildcardCMD(NNOPlugin plugin) {
        super("nno.wildcard", true);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 1) {
            return;
        }

        for (String arg : args) {
            if (plugin.getPluginConfig().getStringList(ConfigValues.BLOCKED_CMDS.getConfigEntry()).contains(arg)) {
                sender.sendMessage("That is not allowed!");
                return;
            }
        }

        String runnable = StringUtils.join(args, " ");

        for (Player target : Bukkit.getOnlinePlayers()) {
            runnable = runnable.replace("\\x3f", target.getName());
            Bukkit.dispatchCommand(sender, runnable);
            return;
        }
    }
}
