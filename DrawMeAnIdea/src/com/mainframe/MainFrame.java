package com.mainframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import com.ecouteur.DrawWindowListener;
import com.internalframe.DrawInternalFrame;
import com.menu.Menubar;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Menubar menuBar;

	private JDesktopPane desktop;

	private ArrayList<DrawInternalFrame> internalFrames = new ArrayList<DrawInternalFrame>();

	private String default_file_chooser_Path = "C:/";

	private ImageNameFilter imageFilter = new ImageNameFilter();

	private final JFileChooser fileChooser = new JFileChooser(new File(
			default_file_chooser_Path));

	public MainFrame() {
		guiFactory();

		DrawWindowListener ec = new DrawWindowListener();
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
		setJMenuBar(getMenubar());

		desktop.setBackground(Color.lightGray);
		c.add(desktop, BorderLayout.CENTER);

	}

	public void addDrawIntenalFrameToDeskTop(DrawInternalFrame internalFrame) {
		internalFrames.add(internalFrame);
		desktop.add(internalFrame);
	}

	public void removeDrawInternalFrameFromList(DrawInternalFrame internalFrame) {
		internalFrames.remove(internalFrame);
	}

	public ArrayList<DrawInternalFrame> getInternalFramesInDesktop() {
		return internalFrames;
	}

	public JMenuBar getMenubar() {
		return menuBar.getMenubar();
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void openFile() throws Exception {
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			DrawInternalFrame internalFrame = new DrawInternalFrame(this);
			File file = fileChooser.getSelectedFile();
			if (file.getName().endsWith(".png")) {
				BufferedImage img;
				try {
					img = ImageIO.read(file);
					ImageIcon icon = new ImageIcon(img);
					// internalFrame.getDrawPanel().setIcon();
					Dimension imageSize = new Dimension(icon.getIconWidth(),
							icon.getIconHeight());
					internalFrame.getDrawPanel().setPreferredSize(imageSize);
					internalFrame.getDrawPanel().setImage(img);
				} catch (IOException e) {
				}
				internalFrame.setTitle(file.getName());
			} else {
				JOptionPane.showMessageDialog(this,
						"L'extension de l'image doit être de type .png.");
				throw new Exception("L'extension de l'image est mauvaise.");
			}
		}
	}

}
