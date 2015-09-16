package net.camtech.fopmremastered.commands;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.camtech.fopmremastered.FOPMR_Rank.Rank;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
//thanks to Camzie99 for this!

public class BlankCommand extends CommandController
{
    Class cls;
    Object object;

    public BlankCommand(String name, String usage, String description, List<String> aliases, CommandPermission permission, Class cls) throws NoSuchMethodException
    {
        super(name, usage, description, aliases, rank);
        this.cls = cls;
        try
        {
            this.object = cls.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
        {
            Logger.getLogger(BlankCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        try
        {
            return (boolean) cls.getMethod("onCommand", CommandSender.class, Command.class, String.class, String[].class).invoke(object, sender, cmd, label, args);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
        {
            Logger.getLogger(BlankCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
