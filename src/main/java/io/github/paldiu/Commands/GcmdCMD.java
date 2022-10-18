package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Info(name = "gcmd", description = "Runs a command as another player. Similar to sudo except it affects everyone.", usage = "/<command> <player> <command>")
public class GcmdCMD extends CommandBase {
    public NNOPlugin plugin;

    public GcmdCMD(NNOPlugin instance) {
        super("nno.gcmd", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 2) {
            return;
        }

        Player target = Bukkit.getServer().getPlayer(args[0]);

        if (target == null) {
            sender.sendMessage(NNOPlugin.PLAYER_NOT_FOUND);
            return;
        }

        String outcommand = "";
        try {
            StringBuilder outcommand_bldr = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                outcommand_bldr.append(args[i]).append(" ");
            }
            outcommand = outcommand_bldr.toString().trim();
        } catch (Throwable ex) {
            sender.sendMessage(ChatColor.GRAY + "Error building command: " + ex.getMessage());
            return;
        }

        try {
            sender.sendMessage("Sending command as " + target.getName() + ": " + outcommand);
            if (Bukkit.getServer().dispatchCommand(target, outcommand)) {
                sender.sendMessage("Command sent.");
            } else {
                sender.sendMessage("Unknown error sending command.");
            }
        } catch (Throwable ex) {
            sender.sendMessage("Error sending command: " + ex.getMessage());
        }
    }
}
