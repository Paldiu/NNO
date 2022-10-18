package io.github.paldiu.Commands;

import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@Info(name = "weed", description = "Smoke some weed!", usage = "/<command>")
public class WeedCMD extends CommandBase {
    public NNOPlugin plugin;

    public WeedCMD(NNOPlugin instance) {
        super("nno.weed", false);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;

        broadcast(ChatColor.DARK_GREEN + p.getName() + " is high as fuck!");
        p.sendMessage(ChatColor.RED + "YOU JUST SMOKED HALF A FUCKING POUND YOU CRAZY FUCKER");
        p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 12000, 200));
        p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 12000, 200));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 12000, 200));
    }
}
