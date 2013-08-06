/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.Paldiu.NNO.Commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import me.Paldiu.NNO.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;

public class Anal implements CommandExecutor
{
    public Main plugin;
    public Anal(Main instance)
    {
        plugin = instance;
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("anal")){
			if (sender instanceof Player){
				Player p = (Player) sender;
				if (args.length != 1){
                                    p.sendMessage("Not enough arguments! Please specify a player.");
				}
                                else if (args.length == 1){
					if (sender.hasPermission("nonamedorg.anal")){
						Player target = Bukkit.getServer().getPlayer(args[0]);
						if (target != null){
							Bukkit.getServer().broadcastMessage(ChatColor.RED + sender.getName() + " wants to fuck " + target.getName() + " anally!");
                                                        p.teleport(target);
							return true;
						} else {
							p.sendMessage(Main.PLAYER_NOT_FOUND);
							return true;
						}
					} else {
						p.sendMessage(Main.MSG_NO_PERMS);
						return true;
					}
				}

			} else {
				sender.sendMessage(Main.NOT_FROM_CONSOLE);
				return true;
			}
		}
                
                if(commandLabel.equalsIgnoreCase("oral")){
			if (sender instanceof Player){
				Player p = (Player) sender;
				if (args.length != 1){
                                    p.sendMessage("Not enough arguments! Please specify a player.");
				}
                                else if (args.length == 1){
					if (sender.hasPermission("nonamedorg.anal")){
						Player target = Bukkit.getServer().getPlayer(args[0]);
						if (target != null){
							Bukkit.getServer().broadcastMessage(ChatColor.BLUE + sender.getName() + " wants to oral to " + target.getName() + "!");
                                                        p.teleport(target);
							return true;
						} else {
							p.sendMessage(Main.PLAYER_NOT_FOUND);
							return true;
						}
					} else {
						p.sendMessage(Main.MSG_NO_PERMS);
						return true;
					}
				}

			} else {
				sender.sendMessage(Main.NOT_FROM_CONSOLE);
				return true;
			}
		}
                
                if(commandLabel.equalsIgnoreCase("rape")){
			if (sender instanceof Player){
				Player p = (Player) sender;
				if (args.length != 1){
                                    p.sendMessage("Not enough arguments! Please specify a player.");
				}
                                else if (args.length == 1){
					if (sender.hasPermission("nonamedorg.anal")){
						Player target = Bukkit.getServer().getPlayer(args[0]);
						if (target != null){
							Bukkit.getServer().broadcastMessage(ChatColor.GREEN + sender.getName() + ": Raping " + target.getName() + "...");
                                                        p.teleport(target);
							return true;
						} else {
							p.sendMessage(Main.PLAYER_NOT_FOUND);
							return true;
						}
					} else {
						p.sendMessage(Main.MSG_NO_PERMS);
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
}