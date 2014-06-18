package com.internalframe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import com.draw.DrawPanel;
import com.mainframe.MainFrame;
import com.menu.ImageToolbar;

public class PersonnalInternalFrame extends JInternalFrame implements Runnable,
		InternalFrameListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImageToolbar imageToolBar;

	private DrawPanel drawPanel;

	public PersonnalInternalFrame(MainFrame mainFrame) {
		setTitle(nameInternalFrame());
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

		addInternalFrameListener(this);
		build();

		mainFrame.addPersonnalIntenalFrameToDeskTop(this);
	}

	public void build() {

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setSize(d.width / 4, d.height / 4);
		setMaximizable(true);
		setIconifiable(true);
		setResizable(true);
		setClosable(true);
		setVisible(true);

		Container c = getContentPane();

		imageToolBar = new ImageToolbar(this);
		c.add(imageToolBar.getImageToolbar(), BorderLayout.NORTH);
		drawPanel = new DrawPanel();
		drawPanel.addMouseListener(drawPanel);
		c.add(drawPanel, BorderLayout.CENTER);
	}

	public PersonnalInternalFrame getPersonnalInternalFrame() {
		return this;
	}

	private String nameInternalFrame() {
		String name = JOptionPane
				.showInputDialog("Donnez un nom à votre image.");
		return name.length() < 1 ? "Untitled" : name;
	}

	@Override
	public void run() {
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub

	}

	public ImageToolbar getColorToolBar() {
		return imageToolBar;
	}

	public DrawPanel getDrawPanel() {
		return drawPanel;
	}
}
