package me.Paldiu.NNO.Commands;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Jelly implements CommandExecutor {

    public Main plugin;
    private Random random = new Random();
    public List<String> message1 = Arrays.asList("whats the difference between jelly and jam?", "whats the difference between a goat and a ram?", "whats the difference between you and a refrigerator?", "whats the difference between your and you're?", "whats the difference between pushing and shoving?", "whats the difference between my dick and my banhammer?");
    public Jelly(Main instance){
            plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if(commandLabel.equalsIgnoreCase("jelly"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (sender.hasPermission("nonamedorg.jelly"))
                {
                    if (args.length != 1)
                    {
                        return false;
                    }
            
                    else if (args.length == 1)
                    {
                        final Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
                        if (targetPlayer != null)
                        {
                           final String ban_message = message1.get(random.nextInt(message1.size()));
                           Util.bcastMsg(ChatColor.RED + "Hey " + targetPlayer.getName() + ", " + ban_message);
            
                           new BukkitRunnable()
                           {
                               @Override
                               public void run()
                               {
                                   switch (ban_message) 
                                   {
                                       case "whats the difference between jelly and jam?":
                                           Util.bcastMsg(ChatColor.RED + "I can't jelly my banhammer up your ass.");
                                           break;
                                       case "whats the difference between a goat and a ram?":
                                           Util.bcastMsg(ChatColor.RED + "I can't goat my banhammer down your throat.");
                                           break;
                                       case "whats the difference between you and a refrigerator?":
                                           List<String> lolOutput = Arrays.asList("Who gives a fuck? No matter the outcome you'll still get banned anyway.", "A refrigerator doesn't run when I chase it when my banhammer.");
                                           String variable = lolOutput.get((new Random()).nextInt(lolOutput.size()));
                                           Util.bcastMsg(ChatColor.RED + variable);
                                           break;
                                       case "whats the difference between you and you're?":
                                           Util.bcastMsg(ChatColor.RED + "I can't shove my banhammer up you're ass.");
                                           break;
                                       case "whats the difference between pushing and shoving?":
                                           Util.bcastMsg(ChatColor.RED + "I can't violently push a banhammer up your ass.");
                                           break;
                                       case "whats the difference between my dick and my banhammer?":
                                           Util.bcastMsg(ChatColor.RED + "I'm not about to shove my dick up your ass.");
                                           break;
                                   }
                               } 
                           }.runTaskLater(plugin, 40L);
            
                           new BukkitRunnable()
                           {
                               @Override
                               public void run()
                               {
                                   targetPlayer.kickPlayer(ChatColor.RED + "GTFO.");
                               }
                           }.runTaskLater(plugin, 80L);
                           return true;
                        }
                        else
                        {
                            p.sendMessage(Main.PLAYER_NOT_FOUND);
                            return true;
                        }
                    }
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