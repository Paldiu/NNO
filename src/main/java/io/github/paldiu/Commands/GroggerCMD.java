package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@Info(name = "grogger", description = "Throwback command", usage = "/<command>")
public class GroggerCMD extends CommandBase {
    private final NNOPlugin plugin;

    public GroggerCMD(NNOPlugin plugin) {
        super("nno.grogger", true);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        broadcast(ChatColor.RED + sender.getName() + " is a horny grogger!");
    }
}
