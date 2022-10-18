package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Info(name = "virginia", description = "West Virginia, mountain mama...", usage = "/<command> [player]")
public class VirginiaCMD extends CommandBase {

    public NNOPlugin plugin;

    public VirginiaCMD(NNOPlugin instance) {
        super("nno.virginia", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);

            if (targetPlayer == null) {
                sender.sendMessage(NNOPlugin.PLAYER_NOT_FOUND);
                return;
            }
            broadcast(targetPlayer.getName() + "!!! Hanging out with little boys in spandex I see!!!", BasicColors.BLUE);
            return;
        }

        broadcast(sender.getName() + "!!! Hanging out with little boys in spandex I see!!!", BasicColors.GREEN);
    }
}