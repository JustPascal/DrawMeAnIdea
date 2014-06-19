package com.mainframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.ecouteur.PersonnalWindowListener;
import com.internalframe.PersonnalInternalFrame;
import com.menu.Menubar;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Menubar menuBar;

	private JDesktopPane desktop;

	private String default_file_chooser_Path = "C:/";

	private ImageNameFilter imageFilter = new ImageNameFilter();

	private final JFileChooser fileChooser = new JFileChooser(new File(default_file_chooser_Path));

	public MainFrame() {
		guiFactory();

		PersonnalWindowListener ec = new PersonnalWindowListener();
		addWindowListener(ec);

		setVisible(true);
	}

	private void guiFactory() {
		setTitle("Draw me an Idea o_O");

		fileChooser.addChoosableFileFilter(imageFilter);
		Container c = getContentPane();

		desktop = new JDesktopPane();
		menuBar = new Menubar(this);
		setResizable(true);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setSize(d.width / 2, d.height / 2);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setJMenuBar(menuBar.getMenubar());

		desktop.setBackground(Color.lightGray);
		c.add(desktop, BorderLayout.CENTER);

	}

	public void addPersonnalIntenalFrameToDeskTop(PersonnalInternalFrame internalFrame) {
		desktop.add(internalFrame);
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}
}
