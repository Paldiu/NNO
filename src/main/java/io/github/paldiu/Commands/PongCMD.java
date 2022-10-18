package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@Info(name = "pong", description = "Alternative /ping command.", usage = "/<command>")
public class PongCMD extends CommandBase {
    public NNOPlugin plugin;

    public PongCMD(NNOPlugin instance) {
        super("nno.pong", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        broadcast(ChatColor.YELLOW + "I heard " + sender.getName() + " likes little Asian boys.");
    }
}
