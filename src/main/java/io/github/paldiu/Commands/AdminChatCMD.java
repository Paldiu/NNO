package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.paldiu.Util;
import io.github.paldiu.player.PlayerData;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import net.kyori.adventure.text.Component;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Info(name = "adminchat", description = "Sends a message to admin chat. You can toggle your default chat mode by using the command by itself.", usage = "/<command> [text]", aliases = "o,ac")
public class AdminChatCMD extends CommandBase {
    private final NNOPlugin plugin;

    public AdminChatCMD(NNOPlugin plugin) {
        super("nno.adminchat", true);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof Player p) {
            if (args.length == 0) {
                PlayerData userinfo = PlayerData.getPlayerData(plugin, p);
                userinfo.setAdminChat(!userinfo.inAdminChat());
                p.sendMessage(ChatColor.GRAY + "Toggled Admin Chat " + (userinfo.inAdminChat() ? "on" : "off") + ".");
            } else {
                Util.adminChatMessage(sender, Component.text(StringUtils.join(args, " ")));
            }
        } else {
            if (args.length == 0) {
                sender.sendMessage("Only in-game players can toggle admin chat.");
            } else {
                Util.adminChatMessage(sender, Component.text(StringUtils.join(args, " ")));
            }
        }
    }
}
