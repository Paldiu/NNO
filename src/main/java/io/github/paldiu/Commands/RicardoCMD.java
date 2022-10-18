package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Info(name = "ricardo", description = "Ricardo!", usage = "/<command>")
public class RicardoCMD extends CommandBase {
    public NNOPlugin plugin;

    public RicardoCMD(NNOPlugin instance) {
        super("nno.ricardo", false);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        broadcast(p.getName() + "'s real name isn't actually " + p.getName() + ", its really Ricardo!", BasicColors.BLUE);
        p.displayName(Component.text("Ricardo").color(BasicColors.RED.getColor()));
    }
}
