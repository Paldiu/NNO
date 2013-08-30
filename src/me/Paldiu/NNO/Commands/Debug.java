/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package me.Paldiu.NNO.Commands;

import java.lang.reflect.Field;
import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Debug implements CommandExecutor
{
    public Main plugin;
    public Debug(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("debug"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (Main.plugin.getConfig().getStringList("developers").contains(p.getName()))
                {
                    if (args.length < 3)
                    {
                        return false;
                    }

                    try
                    {
                        String className = args[0];
                        String fieldName = args[1];
                        String newValue = StringUtils.join(ArrayUtils.subarray(args, 2, args.length), " ");

                        if (className.equalsIgnoreCase("_"))
                        {
                            className = "me.Paldiu.NNO.Main";
                        }

                        setStaticValue(className, fieldName, newValue);

                        sender.sendMessage("Debug: OK");
                    }
                    catch (Exception ex)
                    {
                        sender.sendMessage(ex.getMessage());
                    }

                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void setStaticValue(final String className, final String fieldName, final String newValueString) throws Exception
    {
        Class<?> forName = Class.forName(className);
        if (forName != null)
        {
            final Field field = forName.getDeclaredField(fieldName);
            if (field != null)
            {
                Object newValue;

                Class<?> type = field.getType();
                if (type.isPrimitive())
                {
                    if (type.getName().equals("int"))
                    {
                        newValue = Integer.parseInt(newValueString);
                    }
                    else if (type.getName().equals("double"))
                    {
                        newValue = Double.parseDouble(newValueString);
                    }
                    else if (type.getName().equals("boolean"))
                    {
                        newValue = Boolean.parseBoolean(newValueString);
                    }
                    else
                    {
                        throw new Exception("Unknown primitive field type.");
                    }
                }
                else
                {
                    if (type.isAssignableFrom(Integer.class))
                    {
                        newValue = new Integer(newValueString);
                    }
                    else if (type.isAssignableFrom(Double.class))
                    {
                        newValue = new Double(newValueString);
                    }
                    else if (type.isAssignableFrom(Boolean.class))
                    {
                        newValue = Boolean.valueOf(newValueString);
                    }
                    else if (type.isAssignableFrom(String.class))
                    {
                        newValue = newValueString;
                    }
                    else
                    {
                        throw new Exception("Unknown complex field type.");
                    }
                }

                field.setAccessible(true);

                final Object oldValue = field.get(Class.forName(className));
                if (oldValue != null)
                {
                    field.set(oldValue, newValue);
                }

                field.setAccessible(false);
            }
        }
    }
}
