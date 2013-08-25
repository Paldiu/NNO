package me.Paldiu.NNO.Commands;

import me.Paldiu.NNO.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class Cuil implements CommandExecutor
{
    public Main plugin;
    public Cuil(Main instance)
    {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("cuil"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.cuil"))
                {
                    if (args.length != 1)
                    {
                        return false;
                    }
                    else
                    {
                        switch (args[0])
                        {
                            case "0":
                                p.sendMessage(ChatColor.WHITE + "0 Cuil: I ask for a hamburger, you give me the epitome of all hamburgers, to the most subjective detail. Observers in a state of Perfect Cuil are often introduced to a phenomenon known as the Cuil Paradox, where the hamburger asked/given ratio is so near 1:1 that the observer begins to doubt the reality, suspecting that the hamburger was an artifact of their manufactured memories.");
                                return true;
                            case "1":
                                p.sendMessage(ChatColor.BLUE + "1 Cuil: if you asked me for a hamburger, and I gave you a raccoon.");
                                return true;
                            case "2":
                                p.sendMessage(ChatColor.GREEN + "2 Cuils: If you asked me for a hamburger, but it turns out I don't really exist. Where I was originally standing, a picture of a hamburger rests on the ground.");
                                return true;
                            case "3":
                                p.sendMessage(ChatColor.DARK_GREEN + "3 Cuils: You awake as a hamburger. You start screaming only to have special sauce fly from your lips. The world is in sepia.");
                                return true;
                            case "4":
                                p.sendMessage(ChatColor.YELLOW + "4 Cuils: Why are we speaking German? A mime cries softly as he cradles a young cow. Your grandfather stares at you as the cow falls apart into patties. You look down only to see me with pickles for eyes, I am singing the song that gives birth to the universe.");
                                return true;
                            case "5":
                                p.sendMessage(ChatColor.GOLD + "5 Cuils: You ask for a hamburger, I give you a hamburger. You raise it to your lips and take a bite. Your eye twitches involuntarily. Across the street a father of three falls down the stairs. You swallow and look down at the hamburger in your hands. I give you a hamburger. You swallow and look down at the hamburger in your hands. You cannot swallow. There are children at the top of the stairs. A pickle shifts uneasily under the bun. I give you a hamburger. You look at my face, and I am pleading with you. The children are crying now. You raise the hamburger to your lips, tears stream down your face as you take a bite. I give you a hamburger. You are on your knees. You plead with me to go across the street. I hear only children's laughter. I give you a hamburger. You are screaming as you fall down the stairs. I am your child. You cannot see anything. You take a bite of the hamburger. The concrete rushes up to meet you. You awake with a start in your own bed. Your eye twitches involuntarily. I give you a hamburger. As you kill me, I do not make a sound. I give you a hamburger.");
                                return true;
                            case "6":
                                p.sendMessage(ChatColor.RED + "6 Cuils: You ask me for a hamburger. My attempt to reciprocate is cut brutally short as my body experiences a sudden lack of electrons. Across a variety of hidden dimensions you are dismayed. John Lennon hands me an apple, but it slips through my fingers. I am reborn as an ocelot. You disapprove. A crack echoes through the universe in defiance of conventional physics as cosmological background noise shifts from randomness to a perfect A Flat. Children everywhere stop what they are doing and hum along in perfect pitch with the background radiation. Birds fall from the sky as the sun engulfs the earth. You hesitate momentarily before allowing yourself to assume the locus of all knowledge. Entropy crumbles as you peruse the information contained within the universe. A small library in Phoenix ceases to exist. You stumble under the weight of everythingness, Your mouth opens up to cry out, and collapses around your body before blinking you out of the spatial plane. You exist only within the fourth dimension. The fountainhead of all knowledge rolls along the ground and collides with a small dog. My head tastes sideways as spacetime is reestablished, you blink back into the corporeal world disoriented, only for me to hand you a hamburger as my body collapses under the strain of reconstitution. The universe has reasserted itself. A particular small dog is fed steak for the rest of its natural life. You die in a freak accident moments later, and you soul works at the returns desk for the Phoenix library. You disapprove. Your disapproval sends ripples through the inter-dimensional void between life and death. A small child begins to cry as he walks toward the stairway where his father stands.");
                                return true;
                            case "7":
                                p.sendMessage(ChatColor.DARK_RED + "7 Cuils: I give you a hamburger. The universe is engulfed within itself. A bus advertising hotdogs drives by a papillon. It disapproves. An unnatural force reverses Earth's gravity. You ask for a hamburger. I reciprocate with a mildly convulsing potato. You disapprove. Your disapproval releases a cosmic shift in the void between birth and life. You ask for a hamburger. A certain small dog feasts on hamburger patties for the rest of its unnatural, eternal endurance. Your constant disapproval sends silence through everything. A contrived beast becomes omnipotent. You ask for a hamburger. I give you a hamburger your body becomes an unsettled blob of nothingness, then divides by three. The papillon barks. The universe realigns itself. You, the papillon, and the hamburger disapprove. This condemnation stops the realignment. Hades freezes over. A pig is launched is launched into the unoccupied existence between space and time with a specific hamburger. You ask for a hamburger. I give you a hamburger. It screams as you lift it to your face. You laugh maniacally as I plead with you. You devour the hamburger as it pleads for mercy. I disapprove and condemn you to an eternity in a certain void where a certain pig and its specific hamburger are located. The Universal Space-time Continuum Committee disapproves of my irrational decision. You are locked away and are fed hamburgers for the rest of your natural existence. A pickle refuses to break down during the process of digestion. You die in a freak accident. A certain pickle lives the rest of its life in a comatose state. Your soul disapproves. Down the street a child cries as a hamburger gets stuck in, and climbs back up, her esophagus. You ask again for a hamburger. I refuse to reciprocate. You demand a lawyer. I remind you harshly that this is the new world order. Lawyers no longer exist. Only papillons. Your name is written on a list of sins. Blasphemy. You ask for a hamburger. The comatose pickle vanquishes your soul from this universe. Realignment occurs. You beg for a hamburger. A certain papillon's name is written on an obelisk in Egypt. Mumble. Peasants worship the obelisk. Your soulless corpse partakes in the festivity. Hamburgers are banned universally. The sun implodes. All planets cease to have ever existed. Mercury. Venus. Earth. Mars. Jupiter. Saturn. Uranus. Neptune. Pluto is the only mass in existence. Conveniently, you are on vacation here. Your need for hamburgers re-establishes space-time. Earth is recreated under your intergalactic rule. Hamburgers are your army. You wake up. Clowns. Clowns everywhere. Your dream rushes to meet you. You are kidnapped. You ask for a hamburger. They hand you a hotdog.");
                                return true;
                            case "info":
                                p.sendMessage(ChatColor.RED + "One Cuil = One level of abstraction away from the reality of a situation.");
                                p.sendMessage(ChatColor.RED + "Example: You ask me for a hamburger.");
                                return true;
                        }
                    }
                }
                else
                {
                    Main.noPermission(p);
                    return true;
                }
            }
            else
            {
                sender.sendMessage(Main.NOT_FROM_CONSOLE);
                return true;
            }
        }
        return false;
    }
}
