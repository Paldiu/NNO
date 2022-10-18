package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.paldiu.Util;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@Info(name = "slam", description = "Slams a player into the ground", usage = "/<command> <player>")
public class SlamCMD extends CommandBase {
    public NNOPlugin plugin;

    public SlamCMD(NNOPlugin instance) {
        super("nno.slam", true);
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

        broadcast(ChatColor.RED + sender.getName() + " has slammed " + target.getName() + " into the ground.");
        target.setGameMode(GameMode.SURVIVAL);
        target.getInventory().clear();
        Location playerLocation = target.getLocation();
        playerLocation.setY(100);
        target.teleport(playerLocation);
        playerLocation.setY(target.getLocation().getY() - 1);
        target.setHealth(0);
        target.setVelocity(new Vector(0, -10, 0));
        Util.ChatBot(sender.getName() + ": Slammed " + target.getName() + " into the ground.");
    }
}