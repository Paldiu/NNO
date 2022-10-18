package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.paldiu.Util;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@Info(name = "slap", description = "Slap a player who is acting a fool.", usage = "/<command> <player>")
public class SlapCMD extends CommandBase {
    public NNOPlugin plugin;

    public SlapCMD(NNOPlugin instance) {
        super("nno.slap", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 1) {
            return;
        }

        Player target = Bukkit.getServer().getPlayer(args[0]);

        if (target == null) {
            sender.sendMessage(NNOPlugin.PLAYER_NOT_FOUND);
            return;
        }

        broadcast(ChatColor.RED + target.getName() + " was caught acting sus!");
        Location newLocation = target.getLocation();
        newLocation.setY(132);
        Util.ChatBot(sender.getName() + ": Slapping " + target.getName() + ".");
        target.teleport(newLocation);
        target.setGameMode(GameMode.SURVIVAL);
        target.getInventory().clear();
        final Location target_pos = target.getLocation();
        final World world = target.getWorld();
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                final Location strike_pos = new Location(world, target_pos.getBlockX() + x, target_pos.getBlockY(), target_pos.getBlockZ() + z);
                for (int i = 0; i < 2; i++) {
                    world.strikeLightning(strike_pos);
                }
            }
        }
        target.setVelocity(new Vector(0, 10, 0));
    }
}
