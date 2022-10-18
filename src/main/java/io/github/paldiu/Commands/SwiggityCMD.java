package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;

@Info(name = "swiggity", description = "Swiggity swooty!", usage = "/<command>", aliases = "swig")
public class SwiggityCMD extends CommandBase {
    private final NNOPlugin plugin;

    public SwiggityCMD(NNOPlugin instance) {
        super("nno.swiggity", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        broadcast("Swiggity swoner " + sender.getName() + " has a boner!", BasicColors.GREEN);
    }
}