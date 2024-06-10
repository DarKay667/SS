package me.darkay.ss;

import org.bukkit.plugin.java.JavaPlugin;

import me.darkay.ss.command.CommandSS;
import me.darkay.ss.command.CommandSSBan;
import me.darkay.ss.command.CommandSSMute;
import me.darkay.ss.event.EventRegister;

public class SS extends JavaPlugin
{
    public void onEnable()
    {       
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.getCommand("ss").setExecutor(new CommandSS());
        this.getCommand("ss-ban").setExecutor(new CommandSSBan());
        this.getCommand("ss-mute").setExecutor(new CommandSSMute());
        this.getServer().getPluginManager().registerEvents(new EventRegister(), this);
    }
}