package com.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int X;
	private int Y;
	private Color color = Color.black; // couleur par défaut

	public DrawPanel() {
		setBackground(Color.white);
		setSize(200, 200);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.drawLine(X, Y, 0, 0);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		Graphics g = getGraphics();
		g.setColor(color);
		g.drawLine(X, Y, arg0.getX(), arg0.getY());
		X = arg0.getX();
		Y = arg0.getY();
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
}
