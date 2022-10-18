package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import org.bukkit.command.CommandSender;

@Info(name = "shower", description = "Have you ever been peed on? Oh, my god, YUM!", usage = "/<command>")
public class ShowerCMD extends CommandBase {
    public NNOPlugin plugin;

    public ShowerCMD(NNOPlugin instance) {
        super("nno.shower", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        broadcast(sender.getName() + " is taking a golden shower!", BasicColors.GOLD);
    }
}
