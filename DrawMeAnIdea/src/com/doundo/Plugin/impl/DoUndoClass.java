package com.doundo.Plugin.impl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JButton;

import com.draw.DrawPanel;
import com.draw.Point;
import com.internalframe.DrawInternalFrame;
import com.menu.DrawToolbar;

public class DoUndoClass implements ActionListener {

	private static Logger logger = Logger.getLogger(DoUndoPluginImpl.class.getName());

	private DrawToolbar drawToolbar;

	private JButton redo;

	private JButton undo;

	private DrawPanel drawPanel;

	BufferedImage image;

	ArrayList<Point> points;

	ArrayList<Point> pointstoAddorRemove;

	public DoUndoClass(DrawInternalFrame dim) {
		logger.info("Do Undo class Charging");
		this.drawToolbar = dim.getDrawToolBar();
		this.drawPanel = dim.getDrawPanel();
		init();
	}

	private void init() {
		redo = new JButton("re-do");
		undo = new JButton("un-do");

		redo.addActionListener(this);
		undo.addActionListener(this);
		drawToolbar.addSeparator(new Dimension(24, 30));
		drawToolbar.add(undo);
		drawToolbar.add(redo);
		points = new ArrayList<Point>();
		pointstoAddorRemove = new ArrayList<Point>();
		image = drawPanel.getImage();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		/* Redo listenner */
		if (event.getSource().equals(redo)) {
			points = drawPanel.getPoints();
			for (Point point : pointstoAddorRemove) {
				points.add(point);
			}
			drawPanel.setPoints(points);
			drawPanel.paintComponent(drawPanel.getNextGraphics());
		}
		/* Undo listenner */
		if (event.getSource().equals(undo)) {
			points = drawPanel.getPoints();
			if (!(drawPanel.getPointsToRemoveorAdd().size() == 0))
				pointstoAddorRemove = drawPanel.getPointsToRemoveorAdd();
			for (Point removeThisPoint : pointstoAddorRemove) {
				for (int i = 0; i < points.size(); i++) {
					if (points.get(i).equals(removeThisPoint)) {
						points.remove(i);
					}
				}
			}
			drawPanel.setPointsToRemove();
			drawPanel.setPoints(points);
			drawPanel.paintComponent(drawPanel.getPrevGraphics());
		}
	}
}
