package io.github.paldiu.player;

import io.github.simplexdevelopment.msgutils.AdvancedColors;
import io.github.simplexdevelopment.msgutils.BasicColors;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.jetbrains.annotations.NotNull;

public enum Rank {
    MODERATOR("Mod", AdvancedColors.AMETHYST),
    ADMIN("Admin", AdvancedColors.WHEAT),
    CO_OWNER("Co-Owner", AdvancedColors.CHARTREUSE),
    OWNER("Owner", AdvancedColors.TURQUOISE),
    DEVELOPER("Dev", AdvancedColors.STEEL_BLUE);

    public static final Component OPENER = Component.empty().content("[").color(BasicColors.DARK_GRAY.getColor());
    public static final Component CLOSER = Component.empty().content("]").color(BasicColors.DARK_GRAY.getColor());
    public static final Component RESET = Component.empty().color(BasicColors.WHITE.getColor());
    public static final Component RESET_WITH_SPACE = Component.empty().content(" ").color(BasicColors.WHITE.getColor());

    final @NotNull String rankName;
    final @NotNull AdvancedColors rankColor;

    Rank(@NotNull String rankName, @NotNull AdvancedColors rankColor) {
        this.rankName = rankName;
        this.rankColor = rankColor;
    }

    @NotNull
    public String getRank() {
        return rankName;
    }

    @NotNull
    public AdvancedColors getColor() {
        return rankColor;
    }

    @NotNull
    public TextColor getTextColor() {
        return rankColor.getColor();
    }
}