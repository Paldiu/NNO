package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import org.bukkit.command.CommandSender;

@Info(name = "lockdown", description = "Lock down the server from new players.", usage = "/<command> <on | off>")
public class LockdownCMD extends CommandBase {
    public NNOPlugin plugin;

    public LockdownCMD(NNOPlugin instance) {
        super("nno.lockdown", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 1) {
            return;
        }

        if (args[0].equalsIgnoreCase("on")) {
            plugin.lockdownMode = true;
            broadcast(sender.getName() + " - Locking down the server", BasicColors.RED);
            broadcast("While in lockdown mode, new players cannot join.", BasicColors.RED);
        } else if (args[0].equalsIgnoreCase("off")) {
            plugin.lockdownMode = false;
            broadcast(sender.getName() + " - Unlocking the server", BasicColors.GREEN);
            broadcast("New players are now free to join.", BasicColors.GREEN);
        }
    }
}
