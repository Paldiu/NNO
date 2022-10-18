package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.paldiu.Util;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.CommandSender;

@Info(name = "chatbot", description = "Sends a message as a fake user.", usage = "/<command> <message>")
public class ChatBotCMD extends CommandBase {
    public ChatBotCMD(NNOPlugin plugin) {
        super("nno.chatbot", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 1) return;

        Util.ChatBot((Util.colorise(StringUtils.join(args, " "))));
    }
}
