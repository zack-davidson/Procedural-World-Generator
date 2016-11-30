package com.zack.ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.zack.Constants;
import com.zack.world.World;
import com.zack.world.WorldTile;

public class WorldGUI extends JFrame {

	public static final Object key = new Object();
	
	private static final long serialVersionUID = -3484808758895456098L;
	private World world;
	private JPanel panel = new JPanel();
	private Canvas canvas = new Canvas();
	private Thread painter;

	public Canvas getCanvas() {
		synchronized (key) {
			return canvas;
		}
	}

	public WorldGUI() {
		super(Constants.APPLICATION_NAME);
		this.setSize(Constants.APPLICATION_SIZE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setVisible(true);

		panel.setLayout(null);
		panel.add(canvas);
		canvas.setSize(new Dimension(Constants.WORLD_SIZE_X, Constants.WORLD_SIZE_Y));
		canvas.setMaximumSize(new Dimension(Constants.WORLD_SIZE_X, Constants.WORLD_SIZE_Y));
		canvas.setMinimumSize(new Dimension(Constants.WORLD_SIZE_X, Constants.WORLD_SIZE_Y));
		world = new World("test");
		world.build();

		painter = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						synchronized (this) {
							wait(16);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					paintCanvas(getCanvas().getGraphics());
				}
			}
		});

		painter.start();
	}

	public void paintCanvas(Graphics g) {
		for (WorldTile tile : world.getTiles()) {
			if (tile == null)
				continue;
			g.setColor(new Color(tile.colour));
			g.fillRect(tile.x, tile.y, 1, 1);
		}
	}

}
