package io.github.paldiu.config;

import org.jetbrains.annotations.NotNull;

public enum ConfigValues {
    BYPASS("bypass_bans"),
    ADMIN_MODE("admin_only_mode"),
    TOSSMOB("tossmob_enabled"),
    BLOCKED_CMDS("blocked_commands");

    final String configEntry;

    ConfigValues(@NotNull String configEntry) {
        this.configEntry = configEntry;
    }

    public String getConfigEntry() {
        return configEntry;
    }
}