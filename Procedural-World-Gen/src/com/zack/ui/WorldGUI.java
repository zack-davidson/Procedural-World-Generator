package com.zack.ui;

import javax.swing.JFrame;

import com.zack.Constants;
import com.zack.world.World;

public class WorldGUI extends JFrame
{
    private static final long serialVersionUID = -3484808758895456098L;
    private World world;
    
    public WorldGUI()
    {
        super(Constants.APPLICATION_NAME);
        this.setSize(Constants.APPLICATION_SIZE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
