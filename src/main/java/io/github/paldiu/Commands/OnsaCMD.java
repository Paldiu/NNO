package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@Info(name = "onsa", description = "Onion sandwich", usage = "/<command>")
public class OnsaCMD extends CommandBase {
    public NNOPlugin plugin;

    public OnsaCMD(NNOPlugin instance) {
        super("nno.onsa", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        broadcast(ChatColor.RED + sender.getName() + ": Preparing an Onion Sandwich...");
    }
}