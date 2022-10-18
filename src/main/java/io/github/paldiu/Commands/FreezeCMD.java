package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.paldiu.player.PlayerData;
import io.github.paldiu.Util;
import io.github.simplexdevelopment.cl.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FreezeCMD extends CommandBase {
    public NNOPlugin plugin;

    public FreezeCMD(NNOPlugin instance) {
        super("nno.freeze", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (args.length == 0) {
            plugin.allPlayersFrozen = !plugin.allPlayersFrozen;

            if (plugin.allPlayersFrozen) {
                broadcast(ChatColor.AQUA + sender.getName() + " - Freezing all players");
                plugin.allPlayersFrozen = true;

                if (plugin.freezePurgeTask != null) {
                    plugin.freezePurgeTask.cancel();
                }
                plugin.freezePurgeTask = new BukkitRunnable() {
                    @Override
                    public void run() {
                        broadcast(ChatColor.AQUA + "FreezeTimer - Unfreezing all players");
                        plugin.allPlayersFrozen = false;
                    }
                }.runTaskLater(plugin, 20L * 60L * 5L);

                sender.sendMessage(ChatColor.GRAY + "Players are now frozen.");
            } else {
                broadcast(ChatColor.AQUA + sender.getName() + " - Unfreezing all players");
                plugin.allPlayersFrozen = false;
                if (plugin.freezePurgeTask != null) {
                    plugin.freezePurgeTask.cancel();
                }
                sender.sendMessage(ChatColor.GRAY + "Players are now free to move.");
            }
        } else {
            if (args[0].toLowerCase().equals("purge")) {
                plugin.allPlayersFrozen = false;
                if (plugin.freezePurgeTask != null) {
                    plugin.freezePurgeTask.cancel();
                }

                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    PlayerData playerdata = PlayerData.getPlayerData(plugin, player);
                    playerdata.setFrozen(false);
                }

                broadcast(ChatColor.AQUA + sender.getName() + " - Lifting all global and player freezes");
            } else {
                Player player = Bukkit.getServer().getPlayer(args[0]);

                if (player == null) {
                    sender.sendMessage(NNOPlugin.PLAYER_NOT_FOUND);
                    return;
                }

                PlayerData playerdata = PlayerData.getPlayerData(plugin, player);
                playerdata.setFrozen(!playerdata.isFrozen());

                sender.sendMessage(ChatColor.GRAY + player.getName() + " has been " + (playerdata.isFrozen() ? "frozen" : "unfrozen") + ".");
                Util.ChatBot(sender.getName() + ": " + (playerdata.isFrozen() ? "froze" : "unfroze") + player.getName() + ".");
                player.sendMessage(ChatColor.AQUA + "You have been " + (playerdata.isFrozen() ? "frozen" : "unfrozen") + ".");
            }
        }
    }

    private final List<String> arguments = new ArrayList<>(){{add("purge");}};

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        final List<String> completions = new ArrayList<>();
        Bukkit.getOnlinePlayers().stream().map(Player::getName).forEach(arguments::add);

        if (args.length == 1) {
            StringUtil.copyPartialMatches(args[0], arguments, completions);
        }

        Collections.sort(completions);
        return completions;
    }
}