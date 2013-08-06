package me.Paldiu.NNO;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JFLog
{
    private static final Logger logger = Logger.getLogger("Minecraft-Server");

    private JFLog()
    {
        throw new AssertionError();
    }

    private static void log(Level level, String message, boolean raw)
    {
        logger.log(level, (raw ? "" : "[" + Main.pluginName + "]: ") + message);
    }

    public static void info(String message)
    {
        JFLog.info(message, false);
    }

    public static void info(String message, boolean raw)
    {
        JFLog.log(Level.INFO, message, raw);
    }

    public static void warning(String message)
    {
        JFLog.info(message, false);
    }

    public static void warning(String message, boolean raw)
    {
        JFLog.log(Level.WARNING, message, raw);
    }

    public static void severe(String message)
    {
        JFLog.info(message, false);
    }

    public static void severe(String message, boolean raw)
    {
        JFLog.log(Level.SEVERE, message, raw);
    }

    public static void severe(Throwable ex)
    {
        logger.log(Level.SEVERE, null, ex);
    }
}