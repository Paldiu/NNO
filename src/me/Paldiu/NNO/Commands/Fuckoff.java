package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fuckoff implements CommandExecutor
{
    public Main plugin;
    public Fuckoff(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("fuckoff"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.fuckoff"))
                {
                    if (args.length < 1)
                    {
                        return false;
                    }
            
                    boolean fuckoff_enabled = false;
                    double fuckoff_range = 10.0;
            
                    if (args[0].equalsIgnoreCase("on"))
                    {
                        fuckoff_enabled = true;
            
                        if (args.length >= 2)
                        {
                            try
                            {
                                fuckoff_range = Math.max(5.0, Math.min(100.0, Double.parseDouble(args[1])));
                            }
                            catch (NumberFormatException ex)
                            {
                            }
                        }
                    }
    
                    if (Main.fuckoffEnabledFor.containsKey(p))
                    {
                        Main.fuckoffEnabledFor.remove(p);
                    }
            
                    if (fuckoff_enabled)
                    {
                        Main.fuckoffEnabledFor.put(p, new Double(fuckoff_range));
                    }
            
                    p.sendMessage("Fuckoff " + (fuckoff_enabled ? ("enabled. Range: " + fuckoff_range + ".") : "disabled."));
            
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
                sender.sendMessage(Main.NOT_FROM_CONSOLE);
                return true;
            }
        }
        return false;
    }
}
