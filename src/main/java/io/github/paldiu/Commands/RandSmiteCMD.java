package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.SplittableRandom;

@Info(name = "randsmite", description = "Smites a random player.", usage = "/<command>")
public class RandSmiteCMD extends CommandBase {
    public NNOPlugin plugin;
    private SplittableRandom random = new SplittableRandom();

    public RandSmiteCMD(NNOPlugin plugin) {
        super("nno.randsmite", true);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player[] players = new Player[Bukkit.getOnlinePlayers().size()];
        Bukkit.getOnlinePlayers().toArray(players);
        final Player target = players[random.nextInt(players.length)];

        broadcast(ChatColor.RED + sender.getName() + " - Playing Smite Roulette...");

        new BukkitRunnable() {
            @Override
            public void run() {
                final Location location = target.getLocation();
                final World world = target.getWorld();
                for (int x = -1; x <= 1; x++) {
                    for (int z = -1; z <= 1; z++) {
                        final Location strike = new Location(world, location.getBlockX() + x, location.getBlockY(), location.getBlockZ() + z);
                        world.strikeLightning(strike);
                        target.setVelocity(new Vector(7, 0, 0));
                    }
                }
                target.sendMessage(ChatColor.RED + "You were randomly chosen by the roulette system! Thank you for playing!");
                broadcast(ChatColor.RED + target.getName() + " was the lucky selection of the Smite Roulette!");
            }
        }.runTaskLater(plugin, 20L * 2L);
    }
}
