package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@Info(name = "meep", description = "Meep some shit.", usage = "/<command>")
public class MeepCMD extends CommandBase {
    public NNOPlugin plugin;

    public MeepCMD(NNOPlugin instance) {
        super("nno.meep", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        broadcast(ChatColor.GREEN + sender.getName() + " has just MEEPED THE FUCK OUT OF EVERYTHING.");
    }
}