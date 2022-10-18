package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@Info(name = "sniper", description = "Try it out!", usage = "/<command>")
public class SniperCMD extends CommandBase {
    public NNOPlugin plugin;

    public SniperCMD(NNOPlugin instance) {
        super("nno.sniper", false);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        broadcast("Snipers, take him out.", BasicColors.RED);
        p.sendMessage(ChatColor.YELLOW + "The number you have dialed is not in service. Please hang up and try again.");
        p.setVelocity(new Vector(100, 35, 100));
        p.setHealth(0);
    }
}
