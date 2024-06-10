package me.darkay.ss.util;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class FileBuilder
{
    private File file;
    private YamlConfiguration configuration;
    
    public FileBuilder(String filePath, String fileName)
    {
        this.file = new File(filePath, fileName);
        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }
    
    public FileBuilder setValue(String valuePath, Object value)
    {
        this.configuration.set(valuePath, value);
        return this;
    }
    
    public boolean isFileExist()
    {
        return this.file.exists();
    }
    
    public String getString(String valuePath)
    {
        return this.configuration.getString(valuePath);
    }
    
    public boolean getBoolean(String valuePath)
    {
        return this.configuration.getBoolean(valuePath);
    }
    
    public Long getLong(String valuePath)
    {
        return Long.valueOf(this.configuration.getLong(valuePath));
    }
    
    public FileBuilder saveFile()
    {
        try
        {
            this.configuration.save(this.file);
        }
        
        catch (IOException e) {}
        
        return this;
    }
}