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

import com.draw.DrawPanel;
import com.ecouteur.DrawInternalFramelistenner;
import com.mainframe.MainFrame;
import com.menu.ImageToolbar;

public class DrawInternalFrame extends JInternalFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImageToolbar imageToolBar;

	private DrawPanel drawPanel;

	private MainFrame mainFrame;

	public DrawInternalFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		setTitle("Untitled");

		addInternalFrameListener(new DrawInternalFramelistenner(mainFrame));
		setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);

		build();

		mainFrame.addDrawIntenalFrameToDeskTop(this);
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

	public DrawInternalFrame getDrawInternalFrame() {
		return this;
	}

	@Override
	public void run() {
	}

	public ImageToolbar getImageToolBar() {
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
