package com.zack.world;

/**
 * A representation of a world tile
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 *
 */
public class WorldTile
{
    
    public final int x;
    public final int y;
    public final int colour;
    
    public WorldTile(int x, int y, int colour)
    {
        this.x = x;
        this.y = y;
        this.colour = colour;
    }

    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getColour()
    {
        return colour;
    }
    
    
}
