package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@Info(name = "salmon", description = "Ever been slapped by a fish?", usage = "/<command>")
public class SalmonCMD extends CommandBase {
    public NNOPlugin plugin;

    public SalmonCMD(NNOPlugin instance) {
        super("nno.salmon", false);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;

        p.setVelocity(new Vector(7, 2, 7));
        broadcast(ChatColor.RED + p.getName() + " was slapped by a wet salmon.");
        p.setMaxHealth(20);
        p.setHealth(20);
        p.damage(3);
    }
}
