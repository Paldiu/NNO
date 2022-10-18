package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@Info(name = "trenchcoat", description = "Put on a trenchcoat.", usage = "/<command> [player]")
public class TrenchcoatCMD extends CommandBase {
    public NNOPlugin plugin;

    public TrenchcoatCMD(NNOPlugin instance) {
        super("nno.trenchcoat", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            final Player target = Bukkit.getServer().getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(NNOPlugin.PLAYER_NOT_FOUND);
                return;
            }

            broadcast(ChatColor.BLUE + sender.getName() + " is putting a trenchcoat on " + target.getName());

            new BukkitRunnable() {
                @Override
                public void run() {
                    broadcast(ChatColor.GREEN + sender.getName() + " has put a trenchcoat on " + target.getName());
                }
            }.runTaskLater(plugin, 40L * 2L);

            return;
        }

        broadcast(ChatColor.BLUE + sender.getName() + " is putting on a trenchcoat!");

        new BukkitRunnable() {
            @Override
            public void run() {
                broadcast(ChatColor.GREEN + sender.getName() + " has put on a trenchcoat!");
            }
        }.runTaskLater(plugin, 40L * 2L);
    }
}