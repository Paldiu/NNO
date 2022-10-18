package io.github.paldiu;

import io.github.simplexdevelopment.msgutils.AdvancedColors;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class CBLDR {
    private Component component;

    public CBLDR() {
        this.component = Component.empty();
    }

    @Contract("_, _ -> this")
    public CBLDR add(@NotNull String message, @NotNull AdvancedColors color) {
        this.component = component.append(Component.text(message).color(color.getColor()));
        return this;
    }

    public Component build() {
        return component;
    }
}
