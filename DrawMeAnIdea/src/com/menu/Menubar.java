package com.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.internalframe.PersonnalInternalFrame;
import com.mainframe.MainFrame;

public class Menubar extends JMenuBar implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainFrame mainFrame;

	private JMenuBar menuBar;

	private JMenu file = new JMenu("File");

	private JMenu help = new JMenu("Help");

	private JMenuItem newFile = new JMenuItem("New File");

	private JMenuItem openFile = new JMenuItem("Open File");

	private JMenuItem exitFile = new JMenuItem("Exit File");

	public Menubar(MainFrame mainframe) {
		this.mainFrame = mainframe;
		menuBar = new JMenuBar();

		newFile.addActionListener(this);
		exitFile.addActionListener(this);
		openFile.addActionListener(this);

		file.add(newFile);
		file.add(openFile);
		file.add(exitFile);

		menuBar.add(file);
		menuBar.add(help);

	}

	public JMenuBar getMenubar() {
		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource().equals(newFile)) {
			Thread t = new Thread(new PersonnalInternalFrame(mainFrame));
			t.start();
		}

		if (event.getSource().equals(openFile)) {
			try {
				mainFrame.openFile();
			} catch (Exception e) {
			}
		}

		if (event.getSource().equals(exitFile)) {
			System.out.println("Exit File");
		}

	}

}
