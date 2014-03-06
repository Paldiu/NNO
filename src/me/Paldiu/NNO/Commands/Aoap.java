/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Aoap implements CommandExecutor
{
    public Main plugin;
    public Aoap(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("aoap"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.aoap"))
                {
                    ItemStack bookStack = new ItemStack(Material.WRITTEN_BOOK);

                    BookMeta book = (BookMeta) bookStack.getItemMeta().clone();
                    book.setAuthor(ChatColor.DARK_GRAY + "No" + ChatColor.AQUA + "Named" + ChatColor.DARK_GRAY + "Org");
                    book.setTitle("The Anatomy Of A Cockslap");
                    book.addPage("#1: Slapping ones cock with your hand, #2: Slapping ones face with your cock, or #3: Slapping ones cock with your own.");
                    bookStack.setItemMeta(book);

                    for (Player player : TotalFreedomMod.server.getOnlinePlayers())
                    {
                        if (player.getInventory().contains(Material.WRITTEN_BOOK))
                        {
                            continue;
                        }

                        player.getInventory().addItem(bookStack);
                    }
                }
                else
                {
                    Main.noPermission(p);
                }
            }
            else
            {
                sender.sendMessage(Main.NOT_FROM_CONSOLE);
            }
            
            return true;
        }
        
        return false;
    }
}
