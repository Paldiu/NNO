package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Virginia implements CommandExecutor {

	public Main plugin;

	public Virginia(Main instance){
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		if(commandLabel.equalsIgnoreCase("virginia") || commandLabel.equalsIgnoreCase("virg") || commandLabel.equalsIgnoreCase("spandex") || commandLabel.equalsIgnoreCase("vir")){
			if (sender instanceof Player){
				Player player = (Player) sender;
				if (args.length == 0){
					if (sender.hasPermission("nonamedorg.virginia")){
						Bukkit.getServer().broadcastMessage(ChatColor.GREEN + sender.getName() + "!!! Hanging out with little boys in spandex I see!!!");
					} else {
						player.sendMessage(Main.MSG_NO_PERMS);
						return true;
					}
				}
				if (args.length == 1){
					if (sender.hasPermission("nonamedorg.virginia.other")){
						Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
						if (targetPlayer != null){
							Bukkit.getServer().broadcastMessage(ChatColor.BLUE + targetPlayer.getName() + "!!! Hanging out with little boys in spandex I see!!!");
							return true;
						} else {
							player.sendMessage(Main.PLAYER_NOT_FOUND);
							return true;
						}
					} else {
						player.sendMessage(Main.MSG_NO_PERMS);
						return true;
					}
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