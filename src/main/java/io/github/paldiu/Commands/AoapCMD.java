/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

@Info(name = "aoap", description = "Anatomy of a cockslap.", usage = "/<command>")
public class AoapCMD extends CommandBase {

    public AoapCMD(NNOPlugin plugin) {
        super("nno.aoap", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            ItemStack bookStack = new ItemStack(Material.WRITTEN_BOOK, 1);

            BookMeta book = (BookMeta) bookStack.getItemMeta().clone();
            book.setAuthor(ChatColor.DARK_GRAY + "No" + ChatColor.AQUA + "Named" + ChatColor.DARK_GRAY + "Org");
            book.setTitle("The Anatomy Of A Cockslap");
            book.addPages(Component.empty().content("#1: Slapping ones cock with your hand."),
                    Component.empty().content("#2: Slapping ones face with your cock."),
                    Component.empty().content("#3: Slapping ones cock with your own."));
            bookStack.setItemMeta(book);

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.getInventory().addItem(bookStack);
            }
        }
    }
}
