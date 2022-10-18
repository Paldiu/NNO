package io.github.paldiu;

import io.github.paldiu.config.Config;
import io.github.paldiu.player.PlayerData;
import io.github.paldiu.player.Rank;
import io.github.simplexdevelopment.msgutils.BasicColors;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creature;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Util {
    public static final Map<String, EntityType> mobtypes = new HashMap<String, EntityType>();
    public static final List<String> STOP_COMMANDS = Arrays.asList("stop", "off", "end", "halt", "die");
    public static boolean method_crash = false;

    static {
        for (EntityType entity_type : EntityType.values()) {
            try {
                if (entity_type.getEntityClass() != null) {
                    if (Creature.class.isAssignableFrom(entity_type.getEntityClass())) {
                        mobtypes.put(entity_type.name().toLowerCase(), entity_type);
                    }
                }
            } catch (Exception ignored) {
            }
        }
    }

    private Util() {
        throw new AssertionError();
    }

    public static void sneakyTry(Sneaky sneak) {
        try {
            sneak.accept();
        } catch (Exception ex) {
            Bukkit.getLogger().severe(ex.getMessage());
        }
    }

    public static String formatLocation(Location in_loc) {
        return String.format("%s: (%d, %d, %d)",
                in_loc.getWorld().getName(),
                Math.round(in_loc.getX()),
                Math.round(in_loc.getY()),
                Math.round(in_loc.getZ()));
    }

    public static void ChatBot(String message) {
        JFLog.info(message, true);

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("nonamedorg.adminchat.view")) {
                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "BOT" + ChatColor.WHITE + ChatColor.DARK_GRAY + "] " + ChatColor.YELLOW + "ChatBot" + ChatColor.RESET + ": " + ChatColor.DARK_AQUA + message);
            }
        }
    }

    public static boolean isNewPlayer(Player player) {
        OfflinePlayer[] offlinePlayers = Bukkit.getServer().getOfflinePlayers();
        boolean newPlayer = true;
        for (OfflinePlayer offlinePlayer : offlinePlayers) {
            if (offlinePlayer.getName().equalsIgnoreCase(player.getName())) {
                newPlayer = false;
            }
        }
        return newPlayer;
    }

    public static boolean isStopCommand(String command) {
        return STOP_COMMANDS.contains(command.toLowerCase());
    }

    public static void adminChatMessage(CommandSender sender, Component message) {
        Component name = Component.text(sender.getName() + " ").append(getPrefix(sender));
        JFLog.info("[ADMIN] " + name + ": " + message);

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("nno.adminchat")) {
                player.sendMessage(Rank.OPENER
                        .append(Component.text("ADMIN")
                                .color(BasicColors.AQUA.getColor()))
                        .append(Rank.CLOSER)
                        .append(Rank.RESET_WITH_SPACE)
                        .append(Component.text(sender.getName() + " ")
                                .color(BasicColors.DARK_RED.getColor()))
                        .append(getPrefix(sender))
                        .append(Rank.RESET)
                        .append(Component.text(": "))
                        .append(message.color(BasicColors.AQUA.getColor())));
            }
        }
    }

    public static @NotNull Component getPrefix(CommandSender sender) {
        Component prefix = Component.empty();
        if (sender instanceof Player player) {
            Config playerConf = PlayerData.getPlayerConfigMap().get(player);
            String rank = playerConf.getString("rank");
            if (rank != null && !rank.isEmpty()) {
                try {
                    Rank r = Rank.valueOf(rank);
                    prefix = Rank.OPENER
                            .append(Component.text(r.getRank()).color(r.getTextColor()))
                            .append(Rank.CLOSER);
                } catch (IllegalArgumentException ignored) {
                }
            }
        } else {
            prefix = Component.text("(Console)").color(BasicColors.DARK_PURPLE.getColor());
        }

        return prefix.append(Rank.RESET);
    }

    public static EntityType getEntityType(String mobname) throws Exception {
        mobname = mobname.toLowerCase().trim();

        if (!Util.mobtypes.containsKey(mobname)) {
            throw new Exception();
        }

        return Util.mobtypes.get(mobname);
    }

    public static String colorise(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    @FunctionalInterface
    public interface Sneaky {
        void accept() throws Exception;
    }
}
