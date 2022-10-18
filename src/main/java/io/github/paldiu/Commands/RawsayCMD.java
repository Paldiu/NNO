package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.CommandSender;

@Info(name = "rawsay", description = "Sends a raw string to the server broadcasting system.", usage = "/<command> <message>")
public class RawsayCMD extends CommandBase {
    public NNOPlugin plugin;

    public RawsayCMD(NNOPlugin instance) {
        super("nno.rawsay", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 0) {
            broadcast(StringUtils.join(args, " "), BasicColors.WHITE);
        }
    }
}
