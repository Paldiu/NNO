package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Devconf implements CommandExecutor {

	public Main plugin;
	public Devconf(Main instance){
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		if (commandLabel.equalsIgnoreCase("devconf") || commandLabel.equalsIgnoreCase("devme") || commandLabel.equalsIgnoreCase("confirm")){
			if (sender instanceof Player){
				Player p = (Player) sender;
				if (p.getName().equalsIgnoreCase("paldiu")){
					Bukkit.getServer().broadcastMessage(ChatColor.BLUE + p.getName() + " has verified as a plugin developer!");
					return true;
				} else {
                                        Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getName() + " has tried to play off as a developer!");
					p.sendMessage(Main.MSG_NO_PERMS);
					return true;
				}
			} else {
				sender.sendMessage(Main.NOT_FROM_CONSOLE);
				return true;
			}
		}
		return false;
	}


	public String parseColors(String name){
        String coloredName = ChatColor.translateAlternateColorCodes('&', name);
        return coloredName;
        }  
}
