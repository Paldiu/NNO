package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

@Info(name = "blocktrail", description = "Activates a rainbow block trail. The blocks are permanent.", usage = "/<command> <on | off>", aliases = "trail,bt")
public class BlockTrailCMD extends CommandBase {
    public NNOPlugin plugin;
    private Server server = Bukkit.getServer();
    private Random random = new Random();

    public BlockTrailCMD(NNOPlugin instance) {
        super("nno.blocktrail", false);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if (args.length == 1) {
            if ((args[0].equals("on"))) {
                TrailMixSet(player);
            } else if (args[0].equals("off")) {
                player.kick(Component.text("Block trail has been disabled. Please log in again for the changes to take effect.").color(BasicColors.RED.getColor()));
            }
        }
    }

    public void TrailMixSet(Player player) {
        final Location location = player.getLocation().clone();
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                location.setX(random.nextInt(location.getBlockX() + x));
                location.setZ(random.nextInt(location.getBlockZ() + z));
                player.teleport(location);
            }
        }
    }
}
