
package me.Paldiu.NNO.Commands;

import org.bukkit.Bukkit;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandPermissions {
	private String permPrefix = "nno.";
	private String permission;
	private String defaultLevel = false;
	private final JavaPlugin plugin;
	private final String fileName;
	private File permissionsFile;
	private FileConfiguration fileConfig;
	
	public static void CommandPermissions(JavaPlugin plugin, String fileName) {
		if (plugin == null) {
			throw new IllegalArgumentException("Plugin cannot be null!");
		}
		if (!plugin.isInitialized()) {
			throw new IllegalArgumentException("Plugin must be initialized");
		}
		this.plugin = plugin;
		this.fileName = fileName;
		File dataFolder = plugin.getDataFolder();
		if (dataFolder == null) {
			throw new IllegalStateException();
		}
		this.permissionsFile = new File(plugin.getDataFolder(), fileName());
	}
	
	public void reloadPermissions()
    {
        fileConfiguration = YamlConfiguration.loadConfiguration(permissionsFile);

        // Look for defaults in the jar
        InputStream defConfigStream = plugin.getResource(fileName);
        if(defConfigStream != null)
        {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            fileConfiguration.setDefaults(defConfig);
        }
    }

    public FileConfiguration getPermissions()
    {
        if(fileConfiguration == null)
        {
            this.reloadPermissions();
        }
        return fileConfiguration;
    }

    public void savePermissions() {
        if(fileConfiguration == null || permissionsFile == null) {
            return;
        } 
        else {
            try	{
                getPermissions().save(permissionsFile);
            } 
            catch(IOException ex) {
                plugin.getLogger().log(Level.SEVERE, "Could not save permissions to " + permissionsFile, ex);
            }
        }
    }

    public void saveDefaultPermissions()
    {
        if(!permissionsFile.exists())
        {
            this.plugin.saveResource(fileName, false);
        }
    }

	public static void hasPermission(CommandSender sender, String permission) {
		this.permission = permPrefix + permission;
		if (!sender.hasPermission(this.permission) && (sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
			return true;
		}
		else if (!(sender instanceof Player)){
			continue;
		}
		else {
			continue;
		}
	}
	
	private void writePermissions()
	{
		Pattern cls = Pattern.compile("me/Paldiu/NNO/Commands/(Command_[^\\$]+)\\.class");
		CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
            if (codeSource != null)
            {
                ZipInputStream zip = new ZipInputStream(codeSource.getLocation().openStream());
                ZipEntry zipEntry;
                while ((zipEntry = zip.getNextEntry()) != null)
                {
                    String entryName = zipEntry.getName();
                    Matcher matcher = cls.matcher(entryName);
                    if (matcher.find())
                    {
                        if (matcher.find())
                        {
                            try
                            {
                                Class<?> commandClass = Class.forName("me.Paldiu.NNO.Commands." + matcher.group(1));
                                if (commandClass.isAnnotationPresent(CommandParameters.class))
                                {
                                    String permission = permPrefix + commandClass.toString();
                    	            getPermissions().addEntry("nno.*: ").append("default: false");
                            	    getPermissions().addEntry(permission + ": ").append("default: " + defaultLevel);
                                }
                                else
                                {
                                    throw new Exception("Unknown exception occurred.");
                                    continue;
                                }
                            } 
                            catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
                            {
                                Bukkit.broadcastMessage("" + ex);
                            }
                        }
                    }
                }
            }
	}
}
