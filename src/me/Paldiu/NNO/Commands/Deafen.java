package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Deafen implements CommandExecutor
{
    public Main plugin;
    public Deafen(Main instance)
    {
        plugin = instance;
    }
    
    private static final Random random = new Random();
    public static final double STEPS = 10.0;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player player = (Player) sender;
        for (final Player p : Bukkit.getServer().getOnlinePlayers())
        if (commandLabel.equalsIgnoreCase("deafen"))
        {
            if (player.hasPermission("nonamedorg.deafen"))
            for (double percent = 0.0; percent <= 1.0; percent += (1.0 / STEPS))
            {
                final float pitch = (float) (percent * 2.0);

                new BukkitRunnable()
                {
                    @Override
                    public void run()
                    {
                        p.playSound(randomOffset(p.getLocation(), 5.0), Sound.values()[random.nextInt(Sound.values().length)], 100.0f, pitch);
                    }
                }.runTaskLater(plugin, Math.round(20.0 * percent * 2.0));
            }
            else
            {
                Main.noPermission(p);
                return true;
            }
        }

        return true;
    }

    private static Location randomOffset(Location a, double magnitude)
    {
        return a.clone().add(randomDoubleRange(-1.0, 1.0) * magnitude, randomDoubleRange(-1.0, 1.0) * magnitude, randomDoubleRange(-1.0, 1.0) * magnitude);
    }

    private static Double randomDoubleRange(double min, double max)
    {
        return min + (random.nextDouble() * ((max - min) + 1.0));
    }
}