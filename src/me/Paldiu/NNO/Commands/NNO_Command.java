package me.Paldiu.NNO.Commands;

import java.util.Collection;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Log;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.Paldiu.NNO.Main;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class TFM_Command
{
    public static final String noPermission = ChatColor.RED + "You do not have permission to use this command.";
    public static final String senderNotPlayer = "This command may not be used from the console.";
    public static final String unknownPlayer = ChatColor.RED + "Player not found.";
    protected Main plugin;
    protected Server server;
    private CommandSender commandSender;
    private Class<?> commandClass;

    public NNO_Command()
    {
    }

    abstract public boolean run(final CommandSender sender, final Player p, final Command cmd, final String cmdLbl, final String[] args, final boolean senderIsConsole);

    public void setup(final Main plugin, final CommandSender commandSender, final Class<?> commandClass)
    {
        this.plugin = plugin;
        this.server = plugin.getServer();
        this.commandSender = commandSender;
        this.commandClass = commandClass;
    }

    public void playerMsg(final CommandSender sender, final String message, final ChatColor color)
    {
        if (sender == null)
        {
            return;
        }
        sender.sendMessage(color + message);
    }

    public void playerMsg(final String message, final ChatColor color)
    {
        playerMsg(commandSender, message, color);
    }

    public void playerMsg(final CommandSender sender, final String message)
    {
        playerMsg(sender, message, ChatColor.GRAY);
    }

    public void playerMsg(final String message)
    {
        playerMsg(commandSender, message);
    }

    public boolean senderHasPermission()
    {
        final CommandPermissions permissions = commandClass.getAnnotation(CommandPermissions.class);

        if (permissions == null)
        {
            TFM_Log.warning(commandClass.getName() + " is missing permissions annotation.");
            return true;
        }

        boolean isMod = NNO_Admins.isPlayerMod(commandSender);
        boolean isAdmin = false;

        if (isMod)
        {
            isAdmin = NNO_Admins.isAdmin(commandSender);
        }

        final PermissionLevel permLevel = permissions.level();
        final SenderType senderType = permissions.source();
        final boolean blockHostConsole = permissions.blockHostConsole();

        if (!(commandSender instanceof Player))
        {
            if (senderType == SenderType.player)
            {
                return false;
            }

            if (permLevel == PermissionLevel.ADMIN && !isAdmin)
            {
                return false;
            }

            if (blockHostConsole && NNO_Util.isConsole(commandSender.getName()))
            {
                return false;
            }

            return true;
        }
// THISTHISTHISTHISTHISENDLINE
        final Player senderPlayer = (Player) commandSender;

        if (source == SourceType.ONLY_CONSOLE)
        {
            return false;
        }

        if (level == AdminLevel.SENIOR)
        {
            if (!isSenior)
            {
                return false;
            }

            if (!TFM_PlayerData.getPlayerData(senderPlayer).isSuperadminIdVerified())
            {
                return false;
            }

            return true;
        }

        if (level == AdminLevel.SUPER && !isSuper)
        {
            return false;
        }

        if (level == AdminLevel.OP && !senderPlayer.isOp())
        {
            return false;
        }

        return true;
    }

    public Player getPlayer(final String partialName)
    {
        return getPlayer(partialName, false);
    }

    public Player getPlayer(final String partialName, final boolean exact)
    {
        if (partialName == null || partialName.isEmpty())
        {
            return null;
        }

        final Collection<? extends Player> players = server.getOnlinePlayers();

        // Check exact matches first.
        for (final Player player : players)
        {
            if (partialName.equalsIgnoreCase(player.getName()))
            {
                return player;
            }
        }

        if (exact)
        {
            return null;
        }

        // Then check partial matches in name.
        for (final Player player : players)
        {
            if (player.getName().toLowerCase().contains(partialName.toLowerCase()))
            {
                return player;
            }
        }

        // Then check partial matches in display name.
        for (final Player player : players)
        {
            if (player.getDisplayName().toLowerCase().contains(partialName.toLowerCase()))
            {
                return player;
            }
        }

        return null;
    }
}
