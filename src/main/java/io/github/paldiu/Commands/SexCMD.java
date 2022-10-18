/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Info(name = "sex", description = "Sex another user", usage = "/<command> <target>")
public class SexCMD extends CommandBase {
    public NNOPlugin plugin;

    public SexCMD(NNOPlugin instance) {
        super("nno.sex", false);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (args.length < 1) {
            p.sendMessage("Not enough arguments! Please specify a player.");
            return;
        }

        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                if (!target.hasPermission("nno.sex.exempt")) {
                    broadcast(sender.getName() + " wants to fuck " + target.getName() + "!", BasicColors.RED);
                    p.teleport(target);
                } else {
                    p.sendMessage(ChatColor.RED + "Error: That player has teleportion disabled.");
                }
            } else {
                p.sendMessage(NNOPlugin.PLAYER_NOT_FOUND);
            }
        }

        if (args.length == 2) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                if (!target.hasPermission("nno.sex.exempt")) {
                    switch (args[1]) {
                        case "anal" -> {
                            broadcast(sender.getName() + " wants to fuck " + target.getName() + " in the ass!", BasicColors.RED);
                            p.teleport(target);
                        }
                        case "oral" -> {
                            broadcast(sender.getName() + " wants to fuck " + target.getName() + " in the mouth!", BasicColors.RED);
                            p.teleport(target);
                        }
                        case "rape" -> {
                            broadcast(sender.getName() + " is going to RAPE " + target.getName() + "!", BasicColors.RED);
                            p.teleport(target);
                        }
                        default -> {
                            broadcast(sender.getName() + " wants to fuck " + target.getName() + "!", BasicColors.RED);
                            p.teleport(target);
                        }
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Error: That player has teleportion disabled.");
                }
            } else {
                p.sendMessage(NNOPlugin.PLAYER_NOT_FOUND);
            }
        }
    }

    private final List<String> arguments = List.of("anal", "oral", "rape");

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            StringUtil.copyPartialMatches(args[0], Bukkit.getOnlinePlayers().stream().map(Player::getName).toList(), completions);
        }

        if (args.length == 2) {
            StringUtil.copyPartialMatches(args[1], arguments, completions);
        }

        Collections.sort(completions);

        return completions;
    }
}