package io.github.paldiu.Commands;

import io.github.paldiu.CBLDR;
import io.github.paldiu.NNOPlugin;
import io.github.simplexdevelopment.cl.CommandBase;
import io.github.simplexdevelopment.cl.api.annotations.Info;
import io.github.simplexdevelopment.msgutils.AdvancedColors;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

@Info(name = "phyllis", description = "Phyllis from Denvah!", usage = "/<command>")
public class PhyllisCMD extends CommandBase {
    public NNOPlugin plugin;

    public PhyllisCMD(NNOPlugin instance) {
        super("nno.phyllis", true);
        plugin = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        CBLDR cbldr = new CBLDR();
        cbldr.add("HI IT'S PHYLLIS FROM DENVAH HERE!\n", AdvancedColors.AMETHYST)
                .add("I BOUGHT A SHAMWOW BECAUSE MY CAT MR FLUFFY ", AdvancedColors.AMETHYST)
                .add("BIT THE DUST", AdvancedColors.CRIMSON)
                .add("A FEW DAYS AGO, \n", AdvancedColors.AMETHYST)
                .add("AND I WANTED TO DUST HIM OFF BEFORE I SENT HIM TO THE ", AdvancedColors.AMETHYST)
                .add("TAXIDERMIST", AdvancedColors.PALE_VIOLET_RED)
                .add("!\n", AdvancedColors.AMETHYST)
                .add("NOW HE SITS PROUDLY ON MY MANTLE, ", AdvancedColors.SLATE_BLUE)
                .add("CLEAN ", AdvancedColors.IVORY)
                .add("AS EVAH!!!", AdvancedColors.STEEL_BLUE);

        Bukkit.getServer().broadcast(cbldr.build());
    }
}