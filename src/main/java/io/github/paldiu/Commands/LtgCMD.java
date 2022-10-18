package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@Info(name = "ltg", description = "Try it and see ;)", usage = "/<command>")
public class LtgCMD extends CommandBase {
    public NNOPlugin plugin;

    public LtgCMD(NNOPlugin instance) {
        super("nno.ltg", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        broadcast(ChatColor.GREEN + sender.getName() + " has just lost the game!");
    }
}
