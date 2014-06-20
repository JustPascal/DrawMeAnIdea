package com.internalframe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
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

	private MainFrame mainFrame;

	public PersonnalInternalFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		setTitle("Untitled");
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

		addInternalFrameListener(this);
		build();

		mainFrame.addPersonnalIntenalFrameToDeskTop(this);
	}

	public void build() {

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setSize(d.width / 2, d.height / 2);
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
		drawPanel.addMouseMotionListener(drawPanel);
		c.add(drawPanel, BorderLayout.CENTER);
	}

	public PersonnalInternalFrame getPersonnalInternalFrame() {
		return this;
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

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void save(boolean newImage) {
		if (newImage) {
			BufferedImage image = new BufferedImage(drawPanel.getSize().width,
					drawPanel.getSize().height, BufferedImage.TYPE_INT_ARGB);
			Graphics g = image.createGraphics();
			drawPanel.paint(g);
			g.dispose();

			JFileChooser jfc = mainFrame.getFileChooser();
			if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();
				try {
					String extension = checkName(file.getName());
					ImageIO.write(image, extension, file);
				} catch (Exception e) {
				}
				setTitle(file.getName());
			}
		}
	}

	public String checkName(String name) throws Exception {
		if (name.endsWith(".png"))
			return "png";
		else {
			JOptionPane.showMessageDialog(this,
					"L'extension de l'image doit être de type .png.");
			throw new Exception("L'extension de l'image est mauvaise.");
		}
	}

}
