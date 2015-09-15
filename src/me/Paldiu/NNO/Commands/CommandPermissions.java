package me.Paldiu.NNO.Commands;

import org.bukkit.Bukkit;

public class CommandPermissions {
	private String permPrefix = "nno.";
	private String permission;
	
	public static void hasPermission(CommandSender sender, String permission) {
		this.permission = permPrefix + permission;
		if (!sender.hasPermission(permission) && (sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You do not have permission!");
			return true;
		}
		else if (!(sender instanceof Player)){
			continue;
		}
		else {
			continue;
		}
	}
}
