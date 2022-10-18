package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@Info(name = "nno", description = "Gets info about this plugin.", usage = "/<command> [help] [admin]")
public class NnoCMD extends CommandBase {
    public NNOPlugin plugin;

    public NnoCMD(NNOPlugin instance) {
        super("nno.nno", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(String.format("[%s] Version: %s by %s - %s", plugin.getDescription().getName(), plugin.getDescription().getVersion(), plugin.getDescription().getAuthors(), plugin.getDescription().getDescription()));
        } else if (args.length == 1) {
            if (args[0].equals("help")) {
                sender.sendMessage(ChatColor.RED + "Commands: ");
                sender.sendMessage(ChatColor.GREEN + "/achgiv");
                sender.sendMessage(ChatColor.GREEN + "/anal");
                sender.sendMessage(ChatColor.GREEN + "/oral");
                sender.sendMessage(ChatColor.GREEN + "/rape");
                sender.sendMessage(ChatColor.GREEN + "/bhrp");
                sender.sendMessage(ChatColor.GREEN + "/chcl");
                sender.sendMessage(ChatColor.GREEN + "/chcln");
                sender.sendMessage(ChatColor.GREEN + "/cuil <0-7 | info>");
                sender.sendMessage(ChatColor.GREEN + "/devconf");
                sender.sendMessage(ChatColor.GREEN + "/ltg");
                sender.sendMessage(ChatColor.GREEN + "/meep");
                sender.sendMessage(ChatColor.GREEN + "/grogger");
                sender.sendMessage(ChatColor.GREEN + "/nno [help]");
                sender.sendMessage(ChatColor.GREEN + "/nope");
                sender.sendMessage(ChatColor.GREEN + "/onsa");
                sender.sendMessage(ChatColor.GREEN + "/packnenil");
                sender.sendMessage(ChatColor.GREEN + "/penis");
                sender.sendMessage(ChatColor.GREEN + "/phyllis");
                sender.sendMessage(ChatColor.GREEN + "/pong");
                sender.sendMessage(ChatColor.GREEN + "/radioshow");
                sender.sendMessage(ChatColor.GREEN + "/ricardo");
                sender.sendMessage(ChatColor.GREEN + "/salmon");
                sender.sendMessage(ChatColor.GREEN + "/shower");
                sender.sendMessage(ChatColor.GREEN + "/sniper");
                sender.sendMessage(ChatColor.GREEN + "/state <confusion | consciousness | illusion | afghanistan>");
                sender.sendMessage(ChatColor.GREEN + "/swiggity");
                sender.sendMessage(ChatColor.GREEN + "/thermite");
                sender.sendMessage(ChatColor.GREEN + "/trenchcoat");
                sender.sendMessage(ChatColor.GREEN + "/virginia");
                sender.sendMessage(ChatColor.GREEN + "/weed");
            }
        } else if (args.length == 2) {
            if ((args[0].equals("help")) && (args[1].equals("admin"))) {
                if (sender.hasPermission("nno.nno.admin")) {
                    sender.sendMessage(ChatColor.RED + "Admin commands: ");
                    sender.sendMessage(ChatColor.GREEN + "/slap <player>");
                    sender.sendMessage(ChatColor.GREEN + "/freeze [player | purge]");
                    sender.sendMessage(ChatColor.GREEN + "/slam <player>");
                    sender.sendMessage(ChatColor.GREEN + "/gold <player>");
                    sender.sendMessage(ChatColor.GREEN + "/rawsay <message>");
                    sender.sendMessage(ChatColor.GREEN + "/jelly <player>");
                    sender.sendMessage(ChatColor.GREEN + "/wildcard <this> ? [that] ?");
                    sender.sendMessage(ChatColor.GREEN + "/gcmd <player> <command>");
                    sender.sendMessage(ChatColor.GREEN + "/adminchat <message>");
                    sender.sendMessage(ChatColor.GREEN + "/adminmode <on | off>");
                    sender.sendMessage(ChatColor.GREEN + "/lockdown <on | off>");
                    sender.sendMessage(ChatColor.GREEN + "/cake");
                    sender.sendMessage(ChatColor.GREEN + "/deafen");
                    sender.sendMessage(ChatColor.GREEN + "/lockup <<player on | off> | all | purge>");
                    sender.sendMessage(ChatColor.GREEN + "/randsmite");
                    sender.sendMessage(ChatColor.GREEN + "/tossmob");
                }
            }
        }
    }
}