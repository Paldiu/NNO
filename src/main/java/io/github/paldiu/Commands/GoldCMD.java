package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.paldiu.Util;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@Info(name = "gold", description = "For those pesky Skyfans.", usage = "/<command> <player>")
public class GoldCMD extends CommandBase {
    public NNOPlugin plugin;

    public GoldCMD(NNOPlugin instance) {
        super("nno.gold", true);
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

            broadcast(ChatColor.RED + sender.getName() + " - GOLD'ing " + target.getName() + ".");

            new BukkitRunnable() {
                @Override
                public void run() {
                    target.setHealth(0);
                    target.sendMessage(ChatColor.RED + "IT'S GOLD NOT BUDDER OR BUTTER YOU SKYFAG");
                    broadcast(ChatColor.RED + target.getName() + " is a Sky fan -_-");
                    Util.ChatBot(sender.getName() + " has used /gold on " + target.getName() + ".");
                }
            }.runTaskLater(plugin, 5L * 2L);
        } else {
            sender.sendMessage(NNOPlugin.NOT_ENOUGH_ARGS);
        }
    }
}
