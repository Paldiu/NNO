package me.Paldiu.NNO.Commands;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import me.Paldiu.NNO.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;

public class CommandRegister
{
    private static CommandMap cmap = getCommandMap();
    private static final ArrayList<String> commands = new ArrayList<>();

    public CommandRegister()
    {
        registerCommands();
    }
    
    public static void unregisterCommands()
    {
        for(String name : commands)
        {
            Command cmd = cmap.getCommand(name);
            cmd.unregister(cmap);
        }
    }

    public static void registerCommands()
    {
        try
        {
            Pattern PATTERN = Pattern.compile("me/Paldiu/NNO/Commands/(Command_[^\\$]+)\\.class");
            CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
            if (codeSource != null)
            {
                ZipInputStream zip = new ZipInputStream(codeSource.getLocation().openStream());
                ZipEntry zipEntry;
                while ((zipEntry = zip.getNextEntry()) != null)
                {
                    String entryName = zipEntry.getName();
                    Matcher matcher = PATTERN.matcher(entryName);
                    if (matcher.find())
                    {
                        try
                        {
                            Class<?> commandClass = Class.forName("me.Paldiu.NNO.Commands." + matcher.group(1));
                            if (commandClass.isAnnotationPresent(CommandParameters.class))
                            {
                                Annotation annotation = commandClass.getAnnotation(CommandParameters.class);
                                CommandParameters params = (CommandParameters) annotation;
                                CommandController command = new BlankCommand(params.name(), params.usage(), params.description(), Arrays.asList(params.aliases().split(", ")), params.rank(), commandClass);
                                command.register();
                                commands.add(params.name());
                            }
                            else
                            {
                                Constructor construct = commandClass.getConstructor();
                                CommandController command = (CommandController) construct.newInstance();
                                command.register();
                                commands.add(command.command);
                            }
                        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
                        {
                            Bukkit.broadcastMessage("" + ex);
                        }
                    }
                }
            }
        } catch (Exception ex)
        {
            Main.plugin.getLogger().severe(ex.getLocalizedMessage());
        }
    }

    public static boolean isNNOCommand(String name)
    {
        return CommandRegistry.commands.contains(name.toLowerCase());
    }

    private static CommandMap getCommandMap()
    {
        if (cmap == null)
        {
            try
            {
                final Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
                f.setAccessible(true);
                cmap = (CommandMap) f.get(Bukkit.getServer());
                return getCommandMap();
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
        else if (cmap != null)
        {
            return cmap;
        }
        return getCommandMap();
    }

}
