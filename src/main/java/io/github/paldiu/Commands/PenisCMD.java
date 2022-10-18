package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.AdvancedColors;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Info(name = "penis", description = "What the...", usage = "/<command>")
public class PenisCMD extends CommandBase {
    public NNOPlugin plugin;

    public PenisCMD(NNOPlugin instance) {
        super("nno.penis", false);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        broadcast(player.getName() + " has jacked off so hard their penis came off!", AdvancedColors.CRIMSON);
        player.damage(6);
        player.sendMessage(ChatColor.YELLOW + "You need to stop jerking off so much. Holy fuck.");
    }
}
