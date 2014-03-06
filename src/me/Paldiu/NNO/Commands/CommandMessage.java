package me.Paldiu.NNO.Commands;

import org.bukkit.command.CommandSender;

public enum CommandMessage {
	Deny("[NNO] You do not have permission for this command, if you believe this is an error please fill out a bug report on our forums."),
	Error("[NNO] There was an error while processing this command; Please check the syntax used, and if it persists fill out a bug report on our forums."),
	NonExist("[NNO] That command does not exist.");

	private final String Message;

	CommandMessage(String Message) {
		this.Message = Message;
	}

	public String getMessage() {
		return Message;
	}

	public static void sendPlayerMessage(CommandSender sender, CommandMessage message) {
		sender.sendMessage(message.getMessage());
	}
}
