package com.menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import com.internalframe.PersonnalInternalFrame;

public class ImageToolbar extends JToolBar implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton greenColor;

	private JButton redColor;

	private JButton blueColor;

	private JButton yellowColor;

	private JButton grayColor;

	private JButton orangeColor;

	private Color color;

	public ImageToolbar(PersonnalInternalFrame internalFrame) {
		// colors
		greenColor = new JButton("green");
		redColor = new JButton("red");
		blueColor = new JButton("blue");
		yellowColor = new JButton("yellow");
		grayColor = new JButton("gray");
		orangeColor = new JButton("orange");

		greenColor.addActionListener(this);
		redColor.addActionListener(this);
		blueColor.addActionListener(this);
		yellowColor.addActionListener(this);
		grayColor.addActionListener(this);
		orangeColor.addActionListener(this);

		add(greenColor);
		add(redColor);
		add(blueColor);
		add(yellowColor);
		add(grayColor);
		add(orangeColor);
	}

	public JToolBar getImageToolbar() {
		return this;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource().equals(greenColor)) {
			color = Color.green;
		}
		if (event.getSource().equals(redColor)) {
			color = Color.red;
		}
		if (event.getSource().equals(blueColor)) {
			color = Color.blue;
		}
		if (event.getSource().equals(yellowColor)) {
			color = Color.yellow;
		}
		if (event.getSource().equals(grayColor)) {
			color = Color.GRAY;
		}
		if (event.getSource().equals(orangeColor)) {
			color = Color.orange;
		}

	}

	public Color getColorForBackGround() {
		return color;

	}

}
