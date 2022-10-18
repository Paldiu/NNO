package io.github.paldiu.config;

import io.github.paldiu.NNOPlugin;
import io.github.paldiu.Util;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class Config extends YamlConfiguration {
    private final File configFile;

    public Config(NNOPlugin plugin, String fileName, File parentDirectory, boolean copyDefaults) {
        if (!fileName.endsWith(".yml")) fileName += ".yml";

        configFile = new File(parentDirectory, fileName);
        if (!configFile.exists()) configFile.mkdirs();

        if (copyDefaults) {
            if (plugin.getResource(fileName) != null) plugin.saveResource(fileName, true);
        }

        Util.sneakyTry(() -> load(configFile));
    }

    public File getConfigFile() {
        return configFile;
    }
}
