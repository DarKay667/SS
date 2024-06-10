package me.darkay.ss.util;

public enum Unit
{
    HOUR("h", 60.0D),
    DAY("d", 1440.0D);
    
    private double multi;
    private String name;
    
    Unit(String name, double multi)
    {
        this.name = name;
        this.multi = multi;
    }
    
    public static long getTicks(String unit1, int time)
    {
        long second;
        
        try
        {
            second = (time * 60);
        }
        
        catch (NumberFormatException ex)
        {
            return 0L;
        }
        
        for (Unit unit : values())
        {
            if (unit1.startsWith(unit.name))
            {
                return (long) (second * unit.multi * 1000.0D);
            }
        }
        
        return 0L;
    }
}