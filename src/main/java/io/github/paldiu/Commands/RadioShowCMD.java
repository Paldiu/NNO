package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.AdvancedColors;
import org.bukkit.command.CommandSender;

@Info(name = "radioshow", description = "The Infinitive Process Radio Show!", usage = "/<command>")
public class RadioShowCMD extends CommandBase {
    public NNOPlugin plugin;

    public RadioShowCMD(NNOPlugin instance) {
        super("nno.radioshow", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        broadcast("The infinitive process radio show, with Paldiu and Smack17!", AdvancedColors.CORNFLOWER);
        broadcast("Some dude you STILL will never ever know, because fuck you!", AdvancedColors.GOLDENROD);
    }
}
