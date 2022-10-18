package io.github.paldiu.player;

import io.github.paldiu.NNOPlugin;
import io.github.paldiu.config.Config;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

public class PlayerData {
    public final static Map<Player, PlayerData> userinfo = new HashMap<>();
    private final String ip_address;
    private final UUID player_uuid;
    private boolean user_frozen = false;
    private boolean in_adminchat = false;
    private boolean mob_thrower_enabled = false;
    private EntityType mob_thrower_creature = EntityType.PIG;
    private double mob_thrower_speed = 4.0;
    private List<LivingEntity> mob_thrower_queue = new ArrayList<LivingEntity>();
    private BukkitTask lockup_schedule_id = null;

    private static final Map<Player, Config> playerConfigMap = new HashMap<>();

    public PlayerData(NNOPlugin plugin, Player player) {
        this.ip_address = player.getAddress().getAddress().getHostAddress();
        this.player_uuid = player.getUniqueId();
    }

    public static PlayerData getPlayerData(NNOPlugin plugin, Player player) {
        PlayerData playerdata = PlayerData.userinfo.get(player);

        if (playerdata == null) {
            playerdata = new PlayerData(plugin, player);
            PlayerData.userinfo.put(player, playerdata);
        }

        return playerdata;
    }

    public static Map<Player, Config> getPlayerConfigMap() {
        return playerConfigMap;
    }

    public boolean isFrozen() {
        return this.user_frozen;
    }

    public void setFrozen(boolean fr) {
        this.user_frozen = fr;
    }

    public void enableMobThrower(EntityType mob_thrower_creature, double mob_thrower_speed) {
        this.mob_thrower_enabled = true;
        this.mob_thrower_creature = mob_thrower_creature;
        this.mob_thrower_speed = mob_thrower_speed;
    }

    public void disableMobThrower() {
        this.mob_thrower_enabled = false;
    }

    public EntityType mobThrowerCreature() {
        return mob_thrower_creature;
    }

    public double mobThrowerSpeed() {
        return mob_thrower_speed;
    }

    public boolean mobThrowerEnabled() {
        return mob_thrower_enabled;
    }

    public void enqueueMob(LivingEntity mob) {
        mob_thrower_queue.add(mob);
        if (mob_thrower_queue.size() > 4) {
            LivingEntity oldmob = mob_thrower_queue.remove(0);
            if (oldmob != null) {
                oldmob.damage(500.0);
            }
        }
    }

    public BukkitTask getLockupScheduleID() {
        return lockup_schedule_id;
    }

    public void setLockupScheduleID(BukkitTask lockup_schedule_id) {
        this.lockup_schedule_id = lockup_schedule_id;
    }

    public void setAdminChat(boolean in_adminchat) {
        this.in_adminchat = in_adminchat;
    }

    public boolean inAdminChat() {
        return in_adminchat;
    }
}
