package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import org.bukkit.command.CommandSender;

@Info(name = "bhrp", description = "Bohemian Rhapsody", usage = "/<command>")
public class BhrpCMD extends CommandBase {
    public BhrpCMD(NNOPlugin plugin) {
        super("nno.bhrp", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        broadcast("Is this the real life?", BasicColors.PURPLE);
        broadcast("Is this just fantasy?", BasicColors.PURPLE);
        broadcast("Caught in a landslide", BasicColors.PURPLE);
        broadcast("No escape from reality...", BasicColors.PURPLE);
    }
}