package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Info(name = "nope", description = "When you need to get the fuck outta there as fast as possible.", usage = "/<command>")
public class NopeCMD extends CommandBase {
    public NNOPlugin plugin;

    public NopeCMD(NNOPlugin instance) {
        super("nno.nope", false);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        player.kick(Component.text("NOPE").color(BasicColors.RED.getColor()));
        broadcast(player.getName() + " has just NOPED the fuck out of the server.", BasicColors.RED);
    }
}
