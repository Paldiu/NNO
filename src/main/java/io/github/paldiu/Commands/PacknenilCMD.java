package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.AdvancedColors;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

@Info(name = "packnenil", description = "Look at this!", usage = "/<command>", aliases = "nenil")
public class PacknenilCMD extends CommandBase {
    public NNOPlugin plugin;

    public PacknenilCMD(NNOPlugin instance) {
        super("nno.packnenil", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(ChatColor.YELLOW + "Engaging the Packnenil...");

        new BukkitRunnable() {
            @Override
            public void run() {
                broadcast("Do you wanna see " + sender.getName() + "'s nenil?", AdvancedColors.CORAL);
            }
        }.runTaskLater(plugin, 40L * 2L);
    }
}