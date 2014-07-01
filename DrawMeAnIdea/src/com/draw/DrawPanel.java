package com.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Point> pointsToRemove = new ArrayList<Point>();

	private int X = 0;

	private int Y = 0;

	private Color color;

	private int dotLineSize = 1;

	private String dotLineforme = "circle";

	private static final int width = 900;

	private static final int height = 900;

	private int type = BufferedImage.TYPE_INT_ARGB;

	private ArrayList<Point> points = new ArrayList<Point>();

	private BufferedImage originalImage;

	private Graphics gprevGraphics, gnextGraphics;

	public DrawPanel() {
		setBackground(Color.white);
		setSize(width, height);
		newImage();
	}

	public void newImage() {
		originalImage = new BufferedImage(width, height, type);
		init();
		Graphics g = originalImage.createGraphics();
		color = Color.BLACK;
		this.paint(g);
		g.dispose();
	}

	public void init() {
		// graphics
		gprevGraphics = new BufferedImage(width, height, type).getGraphics().create();
		gnextGraphics = new BufferedImage(width, height, type).getGraphics().create();
	}

	// cette fonction est lancer quand on modifie la taille de la fenetre
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (originalImage != null) {
			g.drawImage(originalImage, 0, 0, null);
		}
		for (Point point : points) {
			g.setColor(point.getColor());
			int pointSize = point.getDotLineSize();
			if (point.getDotLineForme().equals("circle")) {
				g.fillOval(point.getX(), point.getY(), pointSize, pointSize);
			} else {
				g.fillRect(point.getX(), point.getY(), pointSize, pointSize);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		setPointsToRemove();
		Graphics g = getGraphics();
		g.setColor(color);
		if (dotLineforme.equals("circle")) {
			g.fillOval(e.getX(), e.getY(), dotLineSize, dotLineSize);
		} else {
			g.fillRect(e.getX(), e.getY(), dotLineSize, dotLineSize);
		}
		X = e.getX();
		Y = e.getY();
		points.add(new Point(X, Y, color, dotLineSize, dotLineforme));
		pointsToRemove.add(new Point(X, Y, color, dotLineSize, dotLineforme));
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
		gprevGraphics = getGraphics().create();
		setPointsToRemove();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

		gnextGraphics = getGraphics().create();
	}

	public void setColor(Color colorToApply) {
		this.color = colorToApply;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		gprevGraphics = getGraphics().create();
		Graphics g = getGraphics();
		g.setColor(color);
		if (dotLineforme.equals("circle")) {
			g.fillOval(e.getX(), e.getY(), dotLineSize, dotLineSize);
		} else {
			g.fillRect(e.getX(), e.getY(), dotLineSize, dotLineSize);
		}
		X = e.getX();
		Y = e.getY();
		points.add(new Point(X, Y, color, dotLineSize, dotLineforme));
		pointsToRemove.add(new Point(X, Y, color, dotLineSize, dotLineforme));
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	public void setImage(BufferedImage image) {
		this.originalImage = image;
	}

	public BufferedImage getImage() {
		return originalImage;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}

	public void setPointsToRemove() {
		this.pointsToRemove = new ArrayList<Point>();
	}

	public ArrayList<Point> getPointsToRemoveorAdd() {
		return pointsToRemove;
	}

	public Graphics getPrevGraphics() {
		return gprevGraphics;
	}

	public Graphics getNextGraphics() {
		return gnextGraphics;
	}

	public int getDotLineSize() {
		return dotLineSize;
	}

	public void setDotLineSize(int dotLineSize) {
		this.dotLineSize = dotLineSize;
	}

	public String getDotLineforme() {
		return dotLineforme;
	}

	public void setDotLineforme(String dotLineforme) {
		this.dotLineforme = dotLineforme;
	}

}
