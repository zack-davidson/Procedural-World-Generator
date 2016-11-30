package com.zack.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.font.GraphicAttribute;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.zack.Constants;
import com.zack.world.World;
import com.zack.world.WorldTile;

public class WorldGUI extends JFrame
{
    private static final long serialVersionUID = -3484808758895456098L;
    private World world;
    
    private JPanel panel = new JPanel();
    private Canvas canvas = new Canvas();
    
    public WorldGUI()
    {
        super(Constants.APPLICATION_NAME);
        this.setSize(Constants.APPLICATION_SIZE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setVisible(true);
        
        panel.setLayout(null);
        panel.add(canvas);
        
        paintCanvas(canvas.getGraphics());
        
        world = new World("test");
        world.build();
        
        this.add(panel);
    }
    
    public void paintCanvas(Graphics g) {
        for (WorldTile tile : world.getTiles())
        {
            g.setColor(Color.);
        }
    }
    
    

}
