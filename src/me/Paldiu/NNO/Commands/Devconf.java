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

        @Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		if (commandLabel.equalsIgnoreCase("devconf") || commandLabel.equalsIgnoreCase("devme") || commandLabel.equalsIgnoreCase("confirm")){
			if (sender instanceof Player){
				Player p = (Player) sender;
                                Player sender_p = Bukkit.getServer().getPlayer("smack17");
				if (Main.plugin.getConfig().getStringList("ranks.developer").contains(p.getName().toLowerCase())){
					Bukkit.getServer().broadcastMessage(ChatColor.BLUE + p.getName() + " has verified as a plugin developer!");
                                        Bukkit.getServer().dispatchCommand(sender_p, "pex user " + p.getName() + " prefix add \"&8[&5Dev&8] &r\"");
					return true;
				} else {
                                        Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getName() + " has tried to play off as a developer!");
					Main.noPermission(p);
					return true;
				}
			} else {
				sender.sendMessage(Main.NOT_FROM_CONSOLE);
				return true;
			}
		}
		return false;
	}
}