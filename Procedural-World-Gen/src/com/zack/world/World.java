package com.zack.world;

import java.util.Random;

import com.zack.Constants;

/**
 * World class contains the building process and tiles of a world
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 *
 */
public class World
{
    /**
     * Every possible tile
     */
    private WorldTile[] tiles = new WorldTile[Constants.WORLD_SIZE_FINAL];

    /**
     * The worlds seed to generate randoms
     */
    private final String seed;

    /**
     * The random object for procedural generation
     */
    private final Random random;

    /**
     * Gets a world by a random string
     * 
     * @param seed
     *            - the worlds seed
     */
    public World(String seed)
    {
        this.seed = seed;
        this.random = new Random(seed.hashCode());
    }

    /**
     * Gets {@link #tiles}
     * 
     * @return - {@link #tiles}
     */
    public WorldTile[] getTiles()
    {
        return tiles;
    }

    /**
     * Completely builds the world
     */
    public void build()
    {
        buildStaticNoise();
    }

    /**
     * Builds the static noise
     */
    private void buildStaticNoise()
    {
        int currentIndex = 0;
        for (int x = 0; x < Constants.WORLD_SIZE_X; x++)
        {
            for (int y = 0; y < Constants.WORLD_SIZE_Y; y++)
            {
                currentIndex = x + y;
                tiles[currentIndex] = new WorldTile(x, y, getBlackOrWhite());
            }
        }
    }

    /**
     * Gets a black colour or white colour
     * 
     * @return - either <code>0x000000</code> or <code>0xFFFFFF</code>
     */
    private int getBlackOrWhite()
    {
        return random.nextBoolean() == true ? 0xFFFFFF : 0x000000;
    }
    
    /**
     * Gets a seed
     * @return - the {@link #seed}
     */
    public String getSeed() {
        return seed;
    }
}
