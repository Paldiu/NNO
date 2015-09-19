package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.Achievement;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandParameters(name = "achgiv", usage = "/achgiv", description = "Gives you all achievements", aliases = "blubbernuggets", permission = "achgiv");
public class Command_achgiv
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args, boolean isConsole)
    {
        if (isConsole = true)
        {
            sender.sendMessage("You cannot perform this command from the console!");
            return true;
        }
        
        p.awardAchievement(Achievement.OPEN_INVENTORY);
        p.awardAchievement(Achievement.MINE_WOOD);
        p.awardAchievement(Achievement.BUILD_WORKBENCH);
        p.awardAchievement(Achievement.BUILD_HOE);
        p.awardAchievement(Achievement.BUILD_PICKAXE);
        p.awardAchievement(Achievement.BUILD_SWORD);
        p.awardAchievement(Achievement.BUILD_FURNACE);
        p.awardAchievement(Achievement.COOK_FISH);
        p.awardAchievement(Achievement.ACQUIRE_IRON);
        p.awardAchievement(Achievement.ON_A_RAIL);
        p.awardAchievement(Achievement.GET_DIAMONDS);
        p.awardAchievement(Achievement.ENCHANTMENTS);
        p.awardAchievement(Achievement.OVERKILL);
        p.awardAchievement(Achievement.BOOKCASE);
        p.awardAchievement(Achievement.NETHER_PORTAL);
        p.awardAchievement(Achievement.GHAST_RETURN);
        p.awardAchievement(Achievement.GET_BLAZE_ROD);
        p.awardAchievement(Achievement.BREW_POTION);
        p.awardAchievement(Achievement.END_PORTAL);
        p.awardAchievement(Achievement.THE_END);
        p.awardAchievement(Achievement.BUILD_BETTER_PICKAXE);
        p.awardAchievement(Achievement.KILL_ENEMY);
        p.awardAchievement(Achievement.SNIPE_SKELETON);
        p.awardAchievement(Achievement.KILL_COW);
        p.awardAchievement(Achievement.FLY_PIG);
        p.awardAchievement(Achievement.BAKE_CAKE);
        p.awardAchievement(Achievement.MAKE_BREAD);

        return true;
    }
}
