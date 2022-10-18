package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.paldiu.Util;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Info(name = "whip", description = "Whip a naughty player.", usage = "/<command> <player>")
public class WhipCMD extends CommandBase {
    public NNOPlugin plugin;

    public WhipCMD(NNOPlugin instance) {
        super("nno.whip", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 1) {
            return;
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);

        if (target == null) {
            sender.sendMessage(NNOPlugin.PLAYER_NOT_FOUND);
            return;
        }

        broadcast(ChatColor.RED + target.getName() + " has been a naughty boy.");
        Util.ChatBot(sender.getName() + ": Whipping " + target.getName() + ".");
        target.damage(8);
        target.sendMessage(ChatColor.GRAY + "You have been whipped.");
    }
}

