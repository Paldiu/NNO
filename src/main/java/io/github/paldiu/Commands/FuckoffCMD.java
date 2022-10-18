package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Info(name = "fuckoff", description = "Keep those pesky players away!", usage = "/<command> [on] [5 -> 100]")
public class FuckoffCMD extends CommandBase {
    public NNOPlugin plugin;

    public FuckoffCMD(NNOPlugin instance) {
        super("nno.fuckoff", false);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 1) return;

        Player p = (Player) sender;

        boolean fuckoff_enabled = false;
        double fuckoff_range = 10.0;

        if (args[0].equalsIgnoreCase("on")) {
            fuckoff_enabled = true;

            if (args.length >= 2) {
                try {
                    fuckoff_range = Math.max(5.0, Math.min(100.0, Double.parseDouble(args[1])));
                } catch (NumberFormatException ignored) {
                }
            }
        }

        plugin.fuckoffEnabledFor.remove(p);

        if (fuckoff_enabled) {
            plugin.fuckoffEnabledFor.put(p, fuckoff_range);
        }

        p.sendMessage("Fuckoff " + (fuckoff_enabled ? ("enabled. Range: " + fuckoff_range + ".") : "disabled."));

    }
}
