package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gcmd implements CommandExecutor
{
    //Thanks to StephenLawson and Prozza for this!
    public Main plugin;
    public Gcmd(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("gcmd"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.gcmd"))
                {
                    if (args.length < 2)
                    {
                        return false;
                    }
                    
                    Player target = Bukkit.getServer().getPlayer(args[0]);

                    String outcommand = "";
                    try
                    {
                        StringBuilder outcommand_bldr = new StringBuilder();
                        for (int i = 1; i < args.length; i++)
                        {
                            outcommand_bldr.append(args[i]).append(" ");
                        }
                        outcommand = outcommand_bldr.toString().trim();
                    }
                    catch (Throwable ex)
                    {
                        sender.sendMessage(ChatColor.GRAY + "Error building command: " + ex.getMessage());
                        return true;
                    }

                    try
                    {
                        p.sendMessage("Sending command as " + target.getName() + ": " + outcommand);
                        if (Bukkit.getServer().dispatchCommand(target, outcommand))
                        {
                            p.sendMessage("Command sent.");
                        }
                        else
                        {
                            p.sendMessage("Unknown error sending command.");
                        }
                    }
                    catch (Throwable ex)
                    {
                        p.sendMessage("Error sending command: " + ex.getMessage());
                    }
            
                    return true;
                }
                else
                {
                    Main.noPermission(p);
                    return true;
                }
            }
            else
            {
            if (args.length < 2)
                {
                    return false;
                }

                Player target = Bukkit.getServer().getPlayer(args[0]);

                String outcommand = "";
                try
                {
                    StringBuilder outcommand_bldr = new StringBuilder();
                    for (int i = 1; i < args.length; i++)
                    {
                        outcommand_bldr.append(args[i]).append(" ");
                    }
                    outcommand = outcommand_bldr.toString().trim();
                }
                catch (Throwable ex)
                {
                    sender.sendMessage(ChatColor.GRAY + "Error building command: " + ex.getMessage());
                    return true;
                }

                try
                {
                    sender.sendMessage("Sending command as " + target.getName() + ": " + outcommand);
                    if (Bukkit.getServer().dispatchCommand(target, outcommand))
                    {
                        sender.sendMessage("Command sent.");
                    }
                    else
                    {
                        sender.sendMessage("Unknown error sending command.");
                    }
                }
                catch (Throwable ex)
                {
                    sender.sendMessage("Error sending command: " + ex.getMessage());
                }
        
                return true;
            }
        }
        return true;
    }
}
