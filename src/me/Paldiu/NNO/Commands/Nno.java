package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Nno implements CommandExecutor {

	public Main plugin;

	public Nno(Main instance){
		plugin = instance;
	}

        @Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		if (commandLabel.equalsIgnoreCase("nno") || commandLabel.equalsIgnoreCase("orangepenis")){
			if (sender.hasPermission("nonamedorg.nno")){
				sender.sendMessage(String.format("[%s] Version: %s by %s - %s", plugin.getDescription().getName(), plugin.getDescription().getVersion(), plugin.getDescription().getAuthors(), plugin.getDescription().getDescription()));
				return true;
			} else {
				Main.noPermission(null);
				return true;
			}
		}
		return false;
	}

}