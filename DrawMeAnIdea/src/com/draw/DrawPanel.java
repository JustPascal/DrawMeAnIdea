package com.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener,
		MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int X;
	private int Y;
	private ArrayList<Point> points = new ArrayList<Point>();
	private Color color = Color.black; // couleur par défaut
	BufferedImage image = null;

	public DrawPanel() {
		setBackground(Color.white);
		setSize(200, 200);
	}

	// cette fonction est lancé quand on modifie la taille de la fenetre
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, null);
		}
		for (Point point : points) {
			g.setColor(point.getColor());
			g.drawOval(point.getX(), point.getY(), 1, 1);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		Graphics g = getGraphics();
		g.setColor(color);
		g.drawOval(arg0.getX(), arg0.getY(), 1, 1);
		X = arg0.getX();
		Y = arg0.getY();
		points.add(new Point(X, Y, color));
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void setColor(Color colorToApply) {
		this.color = colorToApply;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics g = getGraphics();
		g.setColor(color);
		g.drawOval(e.getX(), e.getY(), 1, 1);
		X = e.getX();
		Y = e.getY();
		points.add(new Point(X, Y, color));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void setImage(BufferedImage image) {
		this.image = image;

	}
}
