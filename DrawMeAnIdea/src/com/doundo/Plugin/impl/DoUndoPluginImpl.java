package com.doundo.Plugin.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.doundo.Plugin.DoUndoPlugin;
import com.internalframe.DrawInternalFrame;
import com.mainframe.MainFrame;
import com.menu.Menubar;

public class DoUndoPluginImpl implements DoUndoPlugin, ActionListener {

	private static Logger logger = Logger.getLogger(DoUndoPluginImpl.class.getName());

	private JMenu test = new JMenu("Frame Plugin");

	private JMenuItem testItem = new JMenuItem("Add Undo Redo Button");

	private MainFrame mainFrame;

	@Override
	public void addMenu(Menubar menubar) {
		logger.info("Charging plugins for Internal Frame.");
		mainFrame = menubar.getMainFrame();
		test.add(testItem);
		testItem.addActionListener(this);
		JMenuBar newMenuBar = menubar.getMainFrame().getMenubar();
		newMenuBar.add(test);
		if (newMenuBar.getMenu(3).equals(test))
			mainFrame.setJMenuBar(newMenuBar);
		else
			newMenuBar.remove(test);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource().equals(testItem)) {
			ArrayList<DrawInternalFrame> dim = mainFrame.getInternalFramesInDesktop();
			for (DrawInternalFrame internalFrame : dim) {
				new DoUndoClass(internalFrame);
			}
		}

	}

}
