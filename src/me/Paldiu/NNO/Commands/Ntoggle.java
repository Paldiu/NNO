package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ntoggle implements CommandExecutor
{
    
    public Main plugin;

	public Ntoggle(Main instance){
		plugin = instance;
	}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("ntoggle") || commandLabel.equalsIgnoreCase("ntg"))
        {
        Player p = (Player) sender;
        {
            if(p.getName().equalsIgnoreCase("smack17") || p.getName().equalsIgnoreCase("Paldiu") || p.getName().equalsIgnoreCase("bees_knees") || p.getName().equalsIgnoreCase("dethplaque"))
            {
        Bukkit.getServer().getPluginManager().disablePlugin(plugin);
        return true;
            }
            else
            {
                sender.sendMessage(Main.ONLY_SUPERPOSITION);
            }
        }
    }
        return true;
    }    
}