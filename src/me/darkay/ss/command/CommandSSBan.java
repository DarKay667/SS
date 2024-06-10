package me.darkay.ss.command;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.bukkit.BanEntry;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.darkay.ss.util.Unit;

public class CommandSSBan implements CommandExecutor
{   
    public boolean onCommand(CommandSender sender, Command command, String message, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            
            if (args.length <= 3)
            {
                player.sendMessage("§6[SS-Ban] §fPrécise un joueur, une durée, une unité (heure (h), jour (d)) et une raison.");
                return true;
            }
            
            String reason = (args.length > 3) ? StringUtils.join((Object[]) args, ' ', 3, args.length) : null;
            
            long now = System.currentTimeMillis();
            long endOfBan = now + Unit.getTicks(args[2], Integer.parseInt(args[1]));
            
            String remainingTime = getMessage(endOfBan);
            
            Date endOfBanDate = new Date(endOfBan);
            BanEntry banEntry = Bukkit.getBanList(Type.NAME).addBan(args[0], reason, endOfBanDate, player.getName());
            
            if (banEntry == null)
            {
                player.sendMessage("§6[SS-Ban] §cErreur: le joueur '§6" + args[0] + "§c' n'a pas été trouvé.");
                return true;
            }
            
            CommandSS.offlinePlayer = banEntry.getTarget();
            
            player.sendMessage("§6[SS-Ban] §cLe joueur '§6" + CommandSS.offlinePlayer + "§c' à été banni pendant §6" + remainingTime + "§cpour §6" + reason + "§c.");
            
            Player player1 = Bukkit.getPlayer(args[0]);
            
            if (player1 != null)
            {
                String secondLine = (reason != null) ? ("\n§cRaison : §6" + reason) : "";
                player1.kickPlayer("§6[SS-Ban] §cVous êtes désormais banni du serveur pendant §6" + remainingTime + secondLine);
            }
        }
        
        else
        {
            sender.sendMessage("§cErreur : Vous n'avez pas accès à cette commande ! (<ADMINISTRATOR)");
        }
        
        return true;
    }
    
    public static String getMessage(long endOfBan)
    {
        String message = "";
        
        long now = System.currentTimeMillis();
        long diff = endOfBan - now;
        int seconds = (int) (diff / 1000L);
        
        if (seconds >= 86400)
        {
            int days = seconds / 86400;
            
            seconds %= 86400;
            message = message + days + " Jour(s) ";
        }
        
        if (seconds >= 3600)
        {
            int hours = seconds / 3600;
            
            seconds %= 3600;
            message = message + hours + " Heure(s) ";
        }
        
        return message;
    }
}