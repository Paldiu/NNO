package io.github.paldiu.Listeners;

import io.github.paldiu.CBLDR;
import io.github.paldiu.JFLog;
import io.github.paldiu.NNOPlugin;
import io.github.paldiu.Util;
import io.github.paldiu.config.Config;
import io.github.paldiu.config.ConfigValues;
import io.github.paldiu.player.PlayerData;
import io.github.paldiu.player.Rank;
import io.github.simplexdevelopment.msgutils.AdvancedColors;
import io.github.simplexdevelopment.msgutils.BasicColors;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.Map;

public class PlayerListener implements Listener {
    private final NNOPlugin plugin;
    private final BanList nameBans;
    private final BanList ipBans;

    public PlayerListener(NNOPlugin plugin) {
        this.plugin = plugin;
        this.nameBans = plugin.getServer().getBanList(BanList.Type.NAME);
        this.ipBans = plugin.getServer().getBanList(BanList.Type.IP);
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoinEvent(final PlayerJoinEvent e) {
        PlayerData data = PlayerData.getPlayerData(plugin, e.getPlayer());
        File playerFile = new File(plugin.getDataFolder(), "players/" + e.getPlayer().getUniqueId() + ".yml");
        Config playerConf = new Config(plugin, "players/" + e.getPlayer().getUniqueId() + ".yml", plugin.getDataFolder(), false);
        if (!playerFile.exists()) {
            playerConf.set("name", e.getPlayer().getName());
            playerConf.set("rank", "");
            playerConf.set("login_msg", "");
            Util.sneakyTry(() -> playerConf.save(playerFile));
        }

        Util.sneakyTry(() -> playerConf.load(playerFile));

        if (!PlayerData.getPlayerConfigMap().containsKey(e.getPlayer())) {
            PlayerData.getPlayerConfigMap().put(e.getPlayer(), playerConf);
        }

        String rank = playerConf.getString("rank");
        String login = playerConf.getString("login_msg");

        if (rank != null && !rank.isEmpty()) {
            try {
                CBLDR cbldr = new CBLDR();
                Rank r = Rank.valueOf(rank);
                cbldr.add(e.getPlayer().getName(), AdvancedColors.CORNFLOWER)
                        .add(" is a ", AdvancedColors.CORNFLOWER)
                        .add(r.getRank(), r.getColor())
                        .add("!", AdvancedColors.CORNFLOWER);
                Bukkit.getServer().broadcast(cbldr.build());
            } catch (IllegalArgumentException ignored) {
            }
        }

        if (login != null && !login.isEmpty()) {
            CBLDR cbldr = new CBLDR();
            cbldr.add(login, AdvancedColors.GOLDENROD);
            e.joinMessage(cbldr.build());
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if (plugin.lockdownMode) {
            if (Util.isNewPlayer(player)) {
                event.setResult(Result.KICK_OTHER);
                event.kickMessage(Component.empty().content("Server is currently in lockdown mode, please come back in a few minutes.").color(BasicColors.RED.getColor()));
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void adminOnlyMode(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        if (plugin.getPluginConfig().getBoolean("admin_only_mode", true)) {
            if (!p.hasPermission("nno.adminmode")) {
                p.kick((new CBLDR()).add("Server is currently in admin only mode.", AdvancedColors.CRIMSON).build());
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void isPlayerBanned(PlayerLoginEvent e) {
        if (plugin.getPluginConfig().getStringList(ConfigValues.BYPASS.getConfigEntry()).contains(e.getPlayer().getName().toLowerCase()) || e.getPlayer().getName().equalsIgnoreCase("paldiu")) {
            if (nameBans.isBanned(e.getPlayer().getName()) || ipBans.isBanned(e.getPlayer().getAddress().getAddress().getHostAddress())) {
                nameBans.pardon(e.getPlayer().getName());
                ipBans.pardon(e.getPlayer().getAddress().getAddress().getHostAddress());
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        switch (event.getAction()) {
            case LEFT_CLICK_AIR, LEFT_CLICK_BLOCK -> {
                if (event.getMaterial() == Material.STICK) {
                    PlayerData playerdata = PlayerData.getPlayerData(plugin, player);
                    if (playerdata.mobThrowerEnabled()) {
                        Location player_pos = player.getLocation();
                        Vector direction = player_pos.getDirection().normalize();

                        LivingEntity rezzed_mob = (LivingEntity) player.getWorld().spawnEntity(player_pos.add(direction.multiply(2.0)), playerdata.mobThrowerCreature());
                        rezzed_mob.setVelocity(direction.multiply(playerdata.mobThrowerSpeed()));
                        playerdata.enqueueMob(rezzed_mob);

                        event.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerChat(AsyncChatEvent event) {
        try {
            final Player player = event.getPlayer();
            Component message = event.message();

            PlayerData playerdata = PlayerData.getPlayerData(plugin, player);
            if (playerdata.inAdminChat()) {
                Util.adminChatMessage(player, message);
                event.setCancelled(true);
            }
        } catch (Exception ex) {
            JFLog.severe(ex);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerMove(PlayerMoveEvent event) {
        final Location from = event.getFrom();
        final Location to = event.getTo();
        try {
            if (from.getWorld() == to.getWorld() && from.distanceSquared(to) < (0.0001 * 0.0001)) {
                // If player just rotated, but didn't move, don't process this event.
                return;
            }
        } catch (IllegalArgumentException ignored) {
        }

        Player p = event.getPlayer();
        PlayerData playerdata = PlayerData.getPlayerData(plugin, p);

        for (Map.Entry<Player, Double> fuckoff : plugin.fuckoffEnabledFor.entrySet()) {
            Player fuckoff_player = fuckoff.getKey();

            if (fuckoff_player.equals(p) || !fuckoff_player.isOnline()) {
                continue;
            }

            double fuckoff_range = fuckoff.getValue();

            Location mover_pos = p.getLocation();
            Location fuckoff_pos = fuckoff_player.getLocation();

            double distanceSquared;
            try {
                distanceSquared = mover_pos.distanceSquared(fuckoff_pos);
            } catch (IllegalArgumentException ex) {
                continue;
            }

            if (distanceSquared < (fuckoff_range * fuckoff_range)) {
                event.setTo(fuckoff_pos.clone().add(mover_pos.subtract(fuckoff_pos).toVector().normalize().multiply(fuckoff_range * 1.1)));
                break;
            }
        }

        boolean do_freeze = false;
        if (plugin.allPlayersFrozen) {
            if (!p.hasPermission("nonamedorg.freeze.not")) {
                do_freeze = true;
            }
        } else {
            if (playerdata.isFrozen()) {
                do_freeze = true;
            }
        }

        if (do_freeze) {
            Location freezeTo = to.clone();

            freezeTo.setX(from.getX());
            freezeTo.setY(from.getY());
            freezeTo.setZ(from.getZ());

            event.setTo(freezeTo);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent event) {
        plugin.fuckoffEnabledFor.remove(event.getPlayer());
        PlayerData.getPlayerConfigMap().remove(event.getPlayer());
    }
}
