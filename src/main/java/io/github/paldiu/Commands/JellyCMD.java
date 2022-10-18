package io.github.paldiu.Commands;

import io.github.paldiu.CBLDR;
import io.github.paldiu.NNOPlugin;
import io.github.paldiu.Util;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.AdvancedColors;
import io.github.simplexdevelopment.msgutils.BasicColors;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.SplittableRandom;

@Info(name = "jelly", description = "Ban those pesky people with style!", usage = "/<command> <player>")
public class JellyCMD extends CommandBase {

    private SplittableRandom random = new SplittableRandom();
    public List<String> message1 = Arrays.asList("Whats the difference between jelly and jam?",
            "Whats the difference between a goat and a ram?",
            "Whats the difference between you and a refrigerator?",
            "Whats the difference between your and you're?",
            "Whats the difference between pushing and shoving?",
            "Whats the difference between my dick and my ban hammer?");

    private final NNOPlugin plugin;

    public JellyCMD(NNOPlugin instance) {
        super("nno.jelly", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 1) {
            return;
        }

        final Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
        if (targetPlayer != null) {
            final String ban_message = message1.get(random.nextInt(message1.size()));
            broadcast("Hey " + targetPlayer.getName() + ", " + ban_message, BasicColors.RED);
            Util.ChatBot(sender.getName() + ": Jelly'd " + targetPlayer.getName() + ".");

            new BukkitRunnable() {
                @Override
                public void run() {
                    switch (ban_message) {
                        case "Whats the difference between jelly and jam?" -> broadcast("I can't jelly my banhammer up your ass.", BasicColors.RED);
                        case "Whats the difference between a goat and a ram?" -> broadcast("I can't goat my banhammer down your throat.", BasicColors.RED);
                        case "Whats the difference between you and a refrigerator?" -> {
                            List<String> lolOutput = Arrays.asList("Who cares? No matter the outcome you're still getting banned anyway.",
                                    "A refrigerator can still run after getting hit with the ban hammer.");
                            String variable = lolOutput.get((new Random()).nextInt(lolOutput.size()));
                            broadcast(variable, BasicColors.RED);
                        }
                        case "Whats the difference between you and you're?" -> broadcast("My ban hammer is going up YOUR ass because YOU'RE a dickhead.", BasicColors.RED);
                        case "Whats the difference between pushing and shoving?" -> broadcast("I am not violently pushing a ban hammer up your ass.", BasicColors.RED);
                        case "Whats the difference between my cock and my ban hammer?" -> broadcast("I'm not about to shove my cock up your ass.", BasicColors.RED);
                    }
                }
            }.runTaskLater(plugin, 40L);

            new BukkitRunnable() {
                @Override
                public void run() {
                    targetPlayer.kick((new CBLDR()).add("GTFO!", AdvancedColors.CRIMSON).build());
                }
            }.runTaskLater(plugin, 80L);
        } else {
            sender.sendMessage(NNOPlugin.PLAYER_NOT_FOUND);
        }
    }

}