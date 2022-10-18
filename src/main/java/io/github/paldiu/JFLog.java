package io.github.paldiu;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JFLog
{
    private static final Logger logger = Logger.getLogger("Minecraft-Server");

    private JFLog()
    {
        throw new AssertionError();
    }

    private static void log(String message, boolean raw)
    {
        logger.log(Level.INFO, (raw ? "" : "[" + NNOPlugin.pluginName + "]: ") + message);
    }

    public static void info(String message)
    {
        JFLog.info(message, false);
    }

    public static void info(String message, boolean raw)
    {
        JFLog.log(message, raw);
    }

    public static void warning(String message)
    {
        JFLog.info(message, false);
    }

    public static void severe(Throwable ex)
    {
        logger.log(Level.SEVERE, null, ex);
    }
}