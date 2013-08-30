package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import me.Paldiu.NNO.PlayerData;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Tossmob implements CommandExecutor
{
    public Main plugin;
    public Tossmob(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("tossmob"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.tossmob"))
                {
                    if (!Main.plugin.getConfig().getBoolean("tossmob_enabled", false))
                    {
                        p.sendMessage(ChatColor.RED + "Tossmob is currently disabled.");
                        return true;
                    }
            
                    PlayerData playerData = PlayerData.getPlayerData(p);
            
                    EntityType creature = EntityType.PIG;
                    if (args.length >= 1)
                    {
                        if (Util.isStopCommand(args[0]))
                        {
                            playerData.disableMobThrower();
                            p.sendMessage(ChatColor.GREEN + "MobThrower is disabled.");
                            return true;
                        }
    
                        if (args[0].equalsIgnoreCase("list"))
                        {
                            p.sendMessage(ChatColor.GREEN + "Supported mobs: " + StringUtils.join(Util.mobtypes.keySet(), ", "));
                            return true;
                        }
    
                        try
                        {
                            creature = Util.getEntityType(args[0]);
                        }
                        catch (Exception ex)
                        {
                            p.sendMessage(ChatColor.GREEN + args[0] + " is not a supported mob type. Using a pig instead.");
                            p.sendMessage(ChatColor.GREEN + "By the way, you can type /tossmob list to see all possible mobs.");
                            creature = EntityType.PIG;
                        }
                    }
            
                    double speed = 1.0;
                    if (args.length >= 2)
                    {
                        try
                        {
                            speed = Double.parseDouble(args[1]);
                        }
                        catch (NumberFormatException nfex)
                        {
                        }
                    }
            
                    if (speed < 1.0)
                    {
                        speed = 1.0;
                    }
                    else if (speed > 5.0)
                    {
                        speed = 5.0;
                    }
            
                    playerData.enableMobThrower(creature, speed);
                    p.sendMessage(ChatColor.GREEN + "MobThrower is enabled. Creature: " + creature + " - Speed: " + speed + ".");
                    p.sendMessage(ChatColor.GREEN + "Left click while holding a stick to throw mobs!");
                    p.sendMessage(ChatColor.GREEN + "Type '/tossmob off' to disable.");
            
                    p.setItemInHand(new ItemStack(Material.STICK, 1));
            
                    return true;
                }
                else
                {
                    Main.noPermission(sender);
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
