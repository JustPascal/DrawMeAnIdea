package com.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import com.internalframe.DrawInternalFrame;

public class DrawToolbar extends JToolBar implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DrawInternalFrame internalFrame;

	private JButton saveImage;

	private JButton blackColor;

	private JButton whiteColor;

	private JButton greenColor;

	private JButton redColor;

	private JButton blueColor;

	private JButton yellowColor;

	private JButton grayColor;

	private JButton orangeColor;

	private JComboBox dotLineSize;

	private JButton squareForme;

	private JButton circleForme;

	public DrawToolbar(DrawInternalFrame internalFrame) {

		super();

		Dimension dimension = new Dimension(24, 30);

		this.internalFrame = internalFrame;
		// save button
		saveImage = new JButton(new ImageIcon(Images.save));
		saveImage.setPreferredSize(dimension);
		saveImage.addActionListener(this);

		// size of the depth of the dot or line
		dotLineSize = new JComboBox();
		dotLineSize.setPreferredSize(new Dimension(50, 30));
		dotLineSize.setMaximumSize(dotLineSize.getPreferredSize());
		fillDotLineSize();
		dotLineSize.addActionListener(this);

		// forme
		squareForme = new JButton(new ImageIcon(Images.square_forme));
		circleForme = new JButton(new ImageIcon(Images.circle_forme));
		squareForme.setPreferredSize(dimension);
		circleForme.setPreferredSize(dimension);
		squareForme.addActionListener(this);
		circleForme.addActionListener(this);

		// colors
		blackColor = new JButton(new ImageIcon(Images.black));
		whiteColor = new JButton(new ImageIcon(Images.white));
		greenColor = new JButton(new ImageIcon(Images.green));
		redColor = new JButton(new ImageIcon(Images.red));
		blueColor = new JButton(new ImageIcon(Images.blue));
		yellowColor = new JButton(new ImageIcon(Images.yellow));
		grayColor = new JButton(new ImageIcon(Images.gray));
		orangeColor = new JButton(new ImageIcon(Images.orange));

		blackColor.setPreferredSize(dimension);
		whiteColor.setPreferredSize(dimension);
		greenColor.setPreferredSize(dimension);
		redColor.setPreferredSize(dimension);
		blueColor.setPreferredSize(dimension);
		yellowColor.setPreferredSize(dimension);
		grayColor.setPreferredSize(dimension);
		orangeColor.setPreferredSize(dimension);

		blackColor.addActionListener(this);
		whiteColor.addActionListener(this);
		greenColor.addActionListener(this);
		redColor.addActionListener(this);
		blueColor.addActionListener(this);
		yellowColor.addActionListener(this);
		grayColor.addActionListener(this);
		orangeColor.addActionListener(this);

		add(saveImage);
		addSeparator(dimension);
		add(squareForme);
		add(circleForme);
		addSeparator(dimension);
		add(dotLineSize);
		addSeparator(dimension);
		add(blackColor);
		add(whiteColor);
		add(greenColor);
		add(redColor);
		add(blueColor);
		add(yellowColor);
		add(grayColor);
		add(orangeColor);

	}

	private void fillDotLineSize() {
		for (int i = 1; i <= 50; i++) {
			dotLineSize.addItem(i);
		}
	}

	public JToolBar getDrawToolbar() {
		return this;
	}

	public DrawInternalFrame getDrawInternalFrame() {
		return internalFrame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		/* Saving image */
		if (event.getSource().equals(saveImage)) {
			internalFrame.save();
		}
		/* Changing forme of dot or line */
		if (event.getSource().equals(squareForme)) {
			internalFrame.getDrawPanel().setDotLineforme("square");
		}
		if (event.getSource().equals(circleForme)) {
			internalFrame.getDrawPanel().setDotLineforme("circle");
		}
		/* Changing dot or line size */
		if (event.getSource().equals(dotLineSize)) {
			internalFrame.getDrawPanel().setDotLineSize((Integer) dotLineSize.getSelectedItem());
		}
		/* Changing colors */
		if (event.getSource().equals(blackColor)) {
			internalFrame.getDrawPanel().setColor(Color.black);
		}
		if (event.getSource().equals(whiteColor)) {
			internalFrame.getDrawPanel().setColor(Color.white);
		}
		if (event.getSource().equals(greenColor)) {
			internalFrame.getDrawPanel().setColor(Color.green);
		}
		if (event.getSource().equals(redColor)) {
			internalFrame.getDrawPanel().setColor(Color.red);
		}
		if (event.getSource().equals(blueColor)) {
			internalFrame.getDrawPanel().setColor(Color.blue);
		}
		if (event.getSource().equals(yellowColor)) {
			internalFrame.getDrawPanel().setColor(Color.yellow);
		}
		if (event.getSource().equals(grayColor)) {
			internalFrame.getDrawPanel().setColor(Color.gray);
		}
		if (event.getSource().equals(orangeColor)) {
			internalFrame.getDrawPanel().setColor(Color.orange);
		}

	}

}
