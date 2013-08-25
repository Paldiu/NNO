package me.Paldiu.NNO.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.ChatColor;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Weed implements CommandExecutor
{
    public Main plugin;
    public Weed(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("weed"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.weed"))
                {
                    Util.bcastMsg(ChatColor.DARK_GREEN + p.getName() + " is high as fuck!");
                    p.sendMessage(ChatColor.RED + "YOU JUST SMOKED HALF A FUCKING POUND YOU CRAZY FUCKER");
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 12000, 200));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 12000, 200));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 12000, 200));
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
        return true;
    }
}
