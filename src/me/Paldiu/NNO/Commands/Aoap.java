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
                    ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
                    BookMeta bm = (BookMeta) book.getItemMeta();
                    bm.setAuthor(ChatColor.DARK_GRAY + "No" + ChatColor.AQUA + "Named" + ChatColor.DARK_GRAY + "Org");
                    bm.setTitle("The Anatomy Of A Cockslap");
                    bm.setPage(1, "#1: Slapping ones cock with your hand, #2: Slapping ones face with your cock, or #3: Slapping ones cock with your own.");
                    p.getInventory().setItem(p.getInventory().firstEmpty(), book);
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
