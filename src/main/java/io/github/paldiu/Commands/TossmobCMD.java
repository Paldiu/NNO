package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.paldiu.Util;
import io.github.paldiu.config.ConfigValues;
import io.github.paldiu.player.PlayerData;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Info(name = "tossmob", description = "Toss some mobs!", usage = "/<command> <[list | stop | off] | mobType> <0 - 5>")
public class TossmobCMD extends CommandBase {
    public NNOPlugin plugin;

    public TossmobCMD(NNOPlugin instance) {
        super("nno.tossmob", false);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (!plugin.getPluginConfig().getBoolean(ConfigValues.TOSSMOB.getConfigEntry(), false)) {
            p.sendMessage(ChatColor.RED + "Tossmob is currently disabled.");
            return;
        }

        PlayerData playerData = PlayerData.getPlayerData(plugin, p);

        EntityType creature = EntityType.PIG;
        if (args.length >= 1) {
            if (Util.isStopCommand(args[0])) {
                playerData.disableMobThrower();
                p.sendMessage(ChatColor.GREEN + "MobThrower is disabled.");
                return;
            }

            if (args[0].equalsIgnoreCase("list")) {
                p.sendMessage(ChatColor.GREEN + "Supported mobs: " + StringUtils.join(Util.mobtypes.keySet(), ", "));
                return;
            }

            try {
                creature = Util.getEntityType(args[0]);
            } catch (Exception ex) {
                p.sendMessage(ChatColor.GREEN + args[0] + " is not a supported mob type. Using a pig instead.");
                p.sendMessage(ChatColor.GREEN + "By the way, you can type /tossmob list to see all possible mobs.");
                creature = EntityType.PIG;
            }
        }

        double speed = 1.0;
        if (args.length >= 2) {
            try {
                speed = Double.parseDouble(args[1]);
            } catch (NumberFormatException nfex) {
            }
        }

        if (speed < 1.0) {
            speed = 1.0;
        } else if (speed > 5.0) {
            speed = 5.0;
        }

        playerData.enableMobThrower(creature, speed);
        p.sendMessage(ChatColor.GREEN + "MobThrower is enabled. Creature: " + creature + " - Speed: " + speed + ".");
        p.sendMessage(ChatColor.GREEN + "Left click while holding a stick to throw mobs!");
        p.sendMessage(ChatColor.GREEN + "Type '/tossmob off' to disable.");

        p.getInventory().setItemInMainHand(new ItemStack(Material.STICK, 1));
    }
}
