package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.BasicColors;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Info(name = "dragon", description = "Do you like dragons?", usage = "/<command>")
public class DragonCMD extends CommandBase {
    public NNOPlugin plugin;
    private Random random = new Random();
    private Server server = Bukkit.getServer();

    public DragonCMD(NNOPlugin instance) {
        super("nno.dragon", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) return;

        if (args.length == 0) {
            sender.sendMessage(msg("Dragons D:", BasicColors.RED));
        }

        if (args.length == 1) {
            Player target = server.getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(NNOPlugin.PLAYER_NOT_FOUND);
                return;
            }

            final Location target_pos = target.getLocation().clone();
            final World world = target.getWorld();
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    final Location strike_pos = new Location(world, target_pos.getBlockX() + x, target_pos.getBlockY(), target_pos.getBlockZ() + z);
                    for (int i = 0; i < 2; i++) {
                        world.strikeLightning(strike_pos);
                    }
                }
            }

            target.sendMessage(msg("DRAGONS BITCH!", BasicColors.RED));
        }
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        final List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            StringUtil.copyPartialMatches(args[0], Bukkit.getOnlinePlayers().stream().map(Player::getName).toList(), completions);
        }
        Collections.sort(completions);
        return completions;
    }
}