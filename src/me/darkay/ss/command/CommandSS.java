package me.darkay.ss.command;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.darkay.ss.Constants;

public class CommandSS implements CommandExecutor
{    
    public static final Inventory INVENTORY_SS = Bukkit.createInventory(null, 54, Constants.INVENTORY_SS);
    public static String offlinePlayer;
    
    public boolean onCommand(CommandSender sender, Command command, String message, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            
            if (args.length == 0)
            {
                player.sendMessage("§6[SS] §fPrécise un joueur.");
                return true;
            }
            
            else if (args.length == 1)
            {                
                offlinePlayer = args[0];
                
                if (Bukkit.getOfflinePlayer(offlinePlayer) != null)
                {                    
                    ItemStack playerSkull = new ItemStack(397, 1, (byte) 3), paper = new ItemStack(Material.PAPER), ironSword = new ItemStack(Material.IRON_SWORD), goldenApple = new ItemStack(Material.GOLDEN_APPLE), woodDoor = new ItemStack(Material.WOOD_DOOR);
                    ItemMeta playerSkullMetadata = playerSkull.getItemMeta(), paperMetadata = paper.getItemMeta(), ironSwordMetadata = ironSword.getItemMeta(), goldenAppleMetadata = goldenApple.getItemMeta(), woodDoorMetadata = woodDoor.getItemMeta();
                    
                    String[] paperLore = new String [] {"§fSanction lié au §bcontenu §fd'un", "§fmessage.", "", "§2>§f Clic gauche pour ouvrir."}, ironSwordLore = new String[] {"§fSanction lié au §bcomportement", "in-game §f(triche, anti-jeu, ...)", "", "§2>§f Clic gauche pour ouvrir."}, goldenAppleLore = new String[] {"§fSanction lié à l'utilisation d'un", "§bmode de triche.", "", "§2>§f Clic gauche pour ouvrir."};
                    
                    playerSkullMetadata.setDisplayName("§b" + offlinePlayer);
                    playerSkull.setItemMeta(playerSkullMetadata);
                    
                    paperMetadata.setDisplayName("§6Messages");
                    paperMetadata.setLore(Arrays.asList(paperLore));
                    paper.setItemMeta(paperMetadata);
                    
                    ironSwordMetadata.setDisplayName("§6Gameplay");
                    ironSwordMetadata.setLore(Arrays.asList(ironSwordLore));
                    ironSword.setItemMeta(ironSwordMetadata);
                    
                    goldenAppleMetadata.setDisplayName("§6Triche");
                    goldenAppleMetadata.setLore(Arrays.asList(goldenAppleLore));
                    goldenApple.setItemMeta(goldenAppleMetadata);
                    
                    woodDoorMetadata.setDisplayName("§cFermer");
                    woodDoor.setItemMeta(woodDoorMetadata);
                    
                    INVENTORY_SS.setItem(0, playerSkull);
                    INVENTORY_SS.setItem(1, paper);
                    INVENTORY_SS.setItem(2, ironSword);
                    INVENTORY_SS.setItem(3, goldenApple);
                    INVENTORY_SS.setItem(53, woodDoor);
                    
                    player.openInventory(INVENTORY_SS);
                    return true;
                }
            }
        }
        
        else
        {
            sender.sendMessage("§cErreur : Vous n'avez pas accès à cette commande ! (<ADMINISTRATOR)");
        }
        
        return false;
    }
}