package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.paldiu.Util;
import io.github.paldiu.player.PlayerData;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

@Info(name = "lockup", description = "Locks a player in the game by constantly opening and closing their inventory menu.", usage = "/<command> <player | all | purge> [on | off | halt | stop]")
public class LockupCMD extends CommandBase {
    public NNOPlugin plugin;

    public LockupCMD(NNOPlugin instance) {
        super("nno.lockup", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("all")) {
                broadcast(ChatColor.RED + sender.getName() + " - Locking up all players");

                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    startLockup(player);
                }
                sender.sendMessage("Locked up all players.");
                Util.ChatBot(sender.getName() + ": Locked up all players.");
            } else if (args[0].equalsIgnoreCase("purge")) {
                broadcast(sender.getName() + " - Unlocking all players", BasicColors.RED);
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    cancelLockup(player);
                }

                sender.sendMessage("Unlocked all players.");
                Util.ChatBot(sender.getName() + ": Unlocked all players.");
            }
        } else if (args.length == 2) {
            if (args[1].equalsIgnoreCase("on")) {
                final Player player = Bukkit.getServer().getPlayer(args[0]);

                broadcast(ChatColor.RED + sender.getName() + " - Locking up " + player.getName());
                startLockup(player);
                sender.sendMessage("Locked up " + player.getName() + ".");
                Util.ChatBot(sender.getName() + ": Locked up " + player.getName() + ".");
            } else if (Util.isStopCommand(args[1])) {
                final Player player = Bukkit.getServer().getPlayer(args[0]);

                broadcast(ChatColor.RED + sender.getName() + " - Unlocking " + player.getName());
                cancelLockup(player);
                Util.ChatBot(sender.getName() + ": Unlocked " + player.getName() + ".");
                sender.sendMessage("Unlocked " + player.getName() + ".");
            }
        }
    }

    private void cancelLockup(@NotNull PlayerData playerdata) {
        BukkitTask lockupScheduleID = playerdata.getLockupScheduleID();
        if (lockupScheduleID != null) {
            lockupScheduleID.cancel();
            playerdata.setLockupScheduleID(null);
        }
    }

    private void cancelLockup(final Player player) {
        cancelLockup(PlayerData.getPlayerData(plugin, player));
    }

    private void startLockup(final Player player) {
        final PlayerData playerdata = PlayerData.getPlayerData(plugin, player);

        cancelLockup(playerdata);

        playerdata.setLockupScheduleID(new BukkitRunnable() {
            @Override
            public void run() {
                if (player.isOnline()) {
                    player.openInventory(player.getInventory());
                } else {
                    cancelLockup(playerdata);
                }
            }
        }.runTaskTimer(plugin, 0L, 5L));
    }
}
