package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import org.bukkit.command.CommandSender;

@Info(name = "state", description = "Change your metaphysical state!", usage = "/<command> <illusion | consciousness | confusion | afghanistan>")
public class StateCMD extends CommandBase {
    public NNOPlugin plugin;

    public StateCMD(NNOPlugin instance) {
        super("nno.state", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 1) {
            return;
        }

        switch (args[0]) {
            case "illusion" -> {
                broadcast(sender.getName() + " now lives in the state of ILLUSION", BasicColors.RED);
            }
            case "confusion" -> {
                broadcast(sender.getName() + " now lives in the state of CONFUSION", BasicColors.RED);
            }
            case "consciousness" -> {
                broadcast(sender.getName() + " now lives in the state of CONSCIOUSNESS", BasicColors.RED);
            }
            case "afghanistan" -> {
                broadcast(sender.getName() + " now lives in the state of AFGHANISTAN", BasicColors.RED);
            }
        }
    }
}
