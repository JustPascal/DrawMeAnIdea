package com.doundo.Plugin.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import net.xeoh.plugins.base.annotations.PluginImplementation;

import com.doundo.Plugin.DoUndoPlugin;
import com.internalframe.DrawInternalFrame;
import com.mainframe.MainFrame;
import com.menu.Menubar;

@PluginImplementation
public class DoUndoPluginImpl implements DoUndoPlugin, ActionListener {

	private JMenu test = new JMenu("SomeWhere");
	private JMenuItem testItem = new JMenuItem(" somewhere item");
	private MainFrame mainFrame;
	private JButton reDo = new JButton("Re Do");
	private JButton unDo = new JButton("Un Do");

	@Override
	public void addMenu(Menubar menubar) {
		mainFrame = menubar.getMainFrame();
		test.add(testItem);
		testItem.addActionListener(this);
		JMenuBar newMenuBar = menubar.getMainFrame().getMenubar();
		newMenuBar.add(test);
		mainFrame.setJMenuBar(newMenuBar);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource().equals(testItem)) {
			ArrayList<DrawInternalFrame> dim = mainFrame
					.getInternalFramesInDesktop();
			System.out.println("Starting : " + dim.size());
			for (DrawInternalFrame internalFrame : dim) {
				internalFrame.getImageToolBar().add(reDo);
				internalFrame.getImageToolBar().add(unDo);
			}
			System.out.println("Ending");
		} else {

		}

	}

}
