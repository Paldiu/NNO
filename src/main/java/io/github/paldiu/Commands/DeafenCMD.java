package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

@Info(name = "deafen", description = "Deafen players with insanely ridiculous sounds.", usage = "/<command>")
public class DeafenCMD extends CommandBase {
    private final Random random = new Random();
    private final NNOPlugin plugin;
    public DeafenCMD(NNOPlugin instance) {
        super("nno.deafen", true);
        this.plugin = instance;
    }

    private Location randomOffset(Location a, double magnitude) {
        return a.clone().add(randomDoubleRange(-1.0, 1.0) * magnitude, randomDoubleRange(-1.0, 1.0) * magnitude, randomDoubleRange(-1.0, 1.0) * magnitude);
    }

    private Double randomDoubleRange(double min, double max) {
        return min + (random.nextDouble() * ((max - min) + 1.0));
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        double STEPS = 10.0;
        for (final Player p : Bukkit.getServer().getOnlinePlayers())
            for (double percent = 0.0; percent <= 1.0; percent += (1.0 / STEPS)) {
                final float pitch = (float) (percent * 2.0);

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        p.playSound(randomOffset(p.getLocation(), 5.0), Sound.values()[random.nextInt(Sound.values().length)], 100.0f, pitch);
                    }
                }.runTaskLater(plugin, Math.round(20.0 * percent * 2.0));
            }
    }
}
