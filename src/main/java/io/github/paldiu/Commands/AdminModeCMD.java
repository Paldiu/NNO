package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.paldiu.Util;
import io.github.paldiu.config.ConfigValues;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Info(name = "adminmode", description = "Enables admin-only mode for the server.", usage = "/<command> <on | off>", aliases = "amtoggle")
public class AdminModeCMD extends CommandBase {
    public NNOPlugin plugin;

    public AdminModeCMD(NNOPlugin plugin) {
        super("nno.adminmode", true);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 1) {
            return;
        }

        if (args[0].equalsIgnoreCase("off")) {
            plugin.getPluginConfig().set(ConfigValues.ADMIN_MODE.getConfigEntry(), false);
            broadcast(ChatColor.GREEN + sender.getName() + " - Opening the server to all players.");
        } else if (args[0].equalsIgnoreCase("on")) {
            plugin.getPluginConfig().set(ConfigValues.ADMIN_MODE.getConfigEntry(), true);
            broadcast(ChatColor.RED + sender.getName() + " - Closing the server to non-admins.");
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!player.hasPermission("nonamedorg.adminmode.join")) {
                    player.kick(Component.empty().content("Server is now closed to non-admins."));
                }
            }
        }
    }
}