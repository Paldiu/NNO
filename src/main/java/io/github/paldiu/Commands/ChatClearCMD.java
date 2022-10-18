package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Info(name = "chcl", description = "Clears your chat.", usage = "/<command>", aliases = "chclr,clrchat,chatclear")
public class ChatClearCMD extends CommandBase {

    public ChatClearCMD(NNOPlugin plugin) {
        super("nno.chatclear", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;

        for (int x = 0; x <= 80; x++) {
            p.sendMessage("\n");
        }

        p.sendMessage(ChatColor.RED + "Your chat has been cleared!");
    }
}
