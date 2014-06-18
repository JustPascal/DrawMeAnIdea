package com.mainframe;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import com.ecouteur.PersonnalWindowListener;
import com.internalframe.PersonnalInternalFrame;
import com.menu.Menubar;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Menubar menuBar = new Menubar(this);
	private JDesktopPane desktop = new JDesktopPane();

	public MainFrame() {
		setTitle("Draw me an Idea o_O");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setSize(d.width / 2, d.height / 2);
		PersonnalWindowListener ec = new PersonnalWindowListener();
		addWindowListener(ec);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setJMenuBar(menuBar.getMenubar());
		getContentPane().add(desktop);
		setVisible(true);
	}

	public void addPersonnalIntenalFrameToDeskTop(
			PersonnalInternalFrame internalFrame) {
		desktop.add(internalFrame);
	}
}
