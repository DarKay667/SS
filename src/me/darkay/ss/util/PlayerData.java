package me.darkay.ss.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class PlayerData
{
    private FileBuilder fileBuilder;
    public UUID uuid;
    
    public PlayerData(UUID uuid)
    {
        this.fileBuilder = new FileBuilder("plugins/SS", String.valueOf(uuid.toString()) + ".yml");
        this.fileBuilder.saveFile();
        this.uuid = uuid;
    }
    
    public boolean isFileExist()
    {
        return this.fileBuilder.isFileExist();
    }
    
    public void setTempMuted(String mutedBy, String reason, long time)
    {
        this.fileBuilder.setValue("tempMute.mutedBy", mutedBy);
        this.fileBuilder.setValue("tempMute.isTempMuted", Boolean.valueOf(true));
        this.fileBuilder.setValue("tempMute.reason", reason);
        this.fileBuilder.setValue("tempMute.duration", Long.valueOf(time + System.currentTimeMillis()));
        this.fileBuilder.setValue("tempMute.timeStamp", (new SimpleDateFormat("dd.MM.yyyy HH:mm")).format(new Date()));
        this.fileBuilder.saveFile();
    }
    
    public void setUnTempMuted()
    {
        this.fileBuilder.setValue("tempMute", null);
        this.fileBuilder.saveFile();
    }
    
    public String getTempMuteReason()
    {
        return this.fileBuilder.getString("tempMute.reason");
    }
    
    public Long getTempMuteMilliseconds()
    {
        return this.fileBuilder.getLong("tempMute.duration");
    }
    
    public String getTempMuteTimeStamp()
    {
        return this.fileBuilder.getString("tempMute.timeStamp");
    }
    
    public boolean isTempMuted()
    {
        return this.fileBuilder.getBoolean("tempMute.isTempMuted");
    }
}