package com.drawpanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	private BufferedImage paintImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);

	public DrawPanel() {
		setBackground(Color.DARK_GRAY);
		setSize(100, 100);
	}

	public void paintComonent(Graphics g) {
		super.paintComponent(g);

	}
}
