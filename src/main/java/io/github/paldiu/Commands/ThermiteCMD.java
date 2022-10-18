package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Info(name = "thermite", description = "Use some thermite.", usage = "/<command>")
public class ThermiteCMD extends CommandBase {
    public NNOPlugin plugin;

    public ThermiteCMD(NNOPlugin instance) {
        super("nno.thermite", false);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        broadcast(p.getName() + " has just stuck thermite up their ass!", BasicColors.RED);
        final Location l = p.getLocation();
        final World w = p.getWorld();
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                final Location explosion = new Location(w, l.getBlockX() + x, l.getBlockY(), l.getBlockZ() + z);
                w.createExplosion(explosion, 0);
            }
        }
    }
}
