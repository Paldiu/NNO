package io.github.paldiu.Commands;

import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Info(name = "grantachievement", description = "Grants yourself or another player all advancements.", usage = "/<command> [player]", aliases = "achgive,grantadv")
public class GrantAchievementCMD extends CommandBase {
    private final List<String> advancements = new ArrayList<>() {{
        add("adventure/adventuring_time");
        add("adventure/kill_a_mob");
        add("adventure/kill_all_mobs");
        add("adventure/root");
        add("adventure/shoot_arrow");
        add("adventure/sleep_in_bed");
        add("adventure/sniper_duel");
        add("adventure/summon_iron_golem");
        add("adventure/throw_trident");
        add("adventure/totem_of_undying");
        add("adventure/trade");
        add("adventure/very_very_frightening");
        add("end/dragon_breath");
        add("end/dragon_egg");
        add("end/elytra");
        add("end/enter_end_gateway");
        add("end/find_end_city");
        add("end/kill_dragon");
        add("end/respawn_dragon");
        add("end/root");
        add("husbandry/balanced_diet");
        add("husbandry/break_diamond_hoe");
        add("husbandry/bred_all_animals");
        add("husbandry/breed_an_animal");
        add("husbandry/plant_seed");
        add("husbandry/root");
        add("husbandry/tactical_fishing");
        add("husbandry/tame_an_animal");
        add("nether/all_effects");
        add("nether/all_potions");
        add("nether/brew_potion");
        add("nether/create_beacon");
        add("nether/create_full_beacon");
        add("nether/fast_travel");
        add("nether/find_fortress");
        add("nether/get_wither_skull");
        add("nether/obtain_blaze_rod");
        add("nether/return_to_sender");
        add("nether/root");
        add("nether/summon_wither");
        add("nether/uneasy_alliance");
        add("story/cure_zombie_villager");
        add("story/deflect_arrow");
        add("story/enchant_item");
        add("story/enter_the_end");
        add("story/enter_the_nether");
        add("story/follow_ender_eye");
        add("story/form_obsidian");
        add("story/iron_tools");
        add("story/lava_bucket");
        add("story/mine_diamond");
        add("story/mine_stone");
        add("story/obtain_armor");
        add("story/root");
        add("story/shiny_gear");
        add("story/smelt_iron");
        add("story/upgrade_tools");
    }};

    public GrantAchievementCMD() {
        super("nno.grantachievement", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) return;

        if (args.length == 1) {
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(Component
                        .empty()
                        .content("That user does not exist!")
                        .color(TextColor.color(75, 75, 75)));
                return;
            }
            loopCall(target);
        }

        if (args.length == 0) {
            if (sender instanceof Player player) {
                loopCall(player);
            }
        }
    }

    private void loopCall(Player player) {
        for (String adv : advancements) {
            AdvancementProgress prog = player.getAdvancementProgress(Objects.requireNonNull(getAdvancement(adv)));

            if (prog.isDone()) continue;

            for (String criterion : prog.getRemainingCriteria()) {
                prog.awardCriteria(criterion);
            }
        }
    }

    @Nullable
    private Advancement getAdvancement(@NotNull String advancement) {
        return Bukkit.getServer().getAdvancement(Objects.requireNonNull(NamespacedKey.minecraft(advancement)));
    }
}
