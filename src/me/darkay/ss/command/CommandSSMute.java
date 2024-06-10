package me.darkay.ss.command;

import java.text.SimpleDateFormat;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.darkay.ss.util.PlayerData;

public class CommandSSMute implements CommandExecutor
{
    private static String reason;
    private static Long time;
    
    public boolean onCommand(CommandSender sender, Command command, String message, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            
            if ((((args.length == 0) ? 1 : 0) | ((args.length == 1) ? 1 : 0)) != 0)
            {
                player.sendMessage("§6[SS-Mute] §fPrécise un joueur, une durée, une unité (heure (h), jour (d)) et une raison.");
                return true;
            }
            
            String format = args[1].substring(args[1].length() - 1, args[1].length());
            
            long duration = Long.valueOf(args[1].substring(0, args[1].length() - 1)).longValue();
            time = 0L;
            
            String timeFormat;
            
            switch ((timeFormat = format).hashCode())
            {
                case 100:
                    
                    if (timeFormat.equals("d"))
                    {
                        time = duration * 1000L * 60L * 60L * 24L;
                        break;
                    }
                    
                case 104:
                    
                    if (timeFormat.equals("h"))
                    {
                        time = duration * 1000L * 60L * 60L;
                        break;
                    }
                    
                case 109:
                    
                    if (timeFormat.equals("m"))
                    {
                        time = duration * 1000L * 60L;
                        break;
                    }
                    
                default:
                    
                    player.sendMessage("§6[SS-Mute] §fMerci d'entrer un format valide. (m/h/d)");
                    return true;
            }
            
            if (args.length >= 2)
            {
                reason = "";
                
                for (int i = 2; i < args.length; i++)
                {
                    reason = String.valueOf(reason) + args[i] + " ";
                }
                
                reason = reason.trim();
                
                PlayerData playerData = new PlayerData(this.getUUIDFromName(args[0]));
                
                if (!playerData.isFileExist())
                {
                    player.sendMessage("§6[SS-Mute] §fAucune information enregistrée à propos de ce joueur.");
                    return true;
                }
                
                playerData.setTempMuted(player.getName(), reason.isEmpty() ? "poor behaviour" : reason, time);
                player.sendMessage("§6[SS-Mute] §cLe joueur '§6" + args[0] + "§c' à été réduit au silence jusqu'au §6" + (new SimpleDateFormat("dd.MM.yyyy")).format(playerData.getTempMuteMilliseconds()) + " §cà §6" + (new SimpleDateFormat("HH:mm")).format(playerData.getTempMuteMilliseconds()) + " §cpour §6" + reason + "§c.");
            }
        }
        
        return false;
    }
    
    private UUID getUUIDFromName(String playerName)
    {
        Player player = Bukkit.getPlayer(playerName);
        
        if (player != null)
        {
            return player.getUniqueId();
        }
        
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(playerName);
        
        if (offlinePlayer != null)
        {
            return offlinePlayer.getUniqueId();
        }
        
        return null;
    }
}