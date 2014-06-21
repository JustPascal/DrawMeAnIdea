package com.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import net.xeoh.plugins.base.PluginConfiguration;
import net.xeoh.plugins.base.PluginManager;
import net.xeoh.plugins.base.diagnosis.channels.tracing.PluginManagerTracer;
import net.xeoh.plugins.base.impl.PluginConfigurationImpl;
import net.xeoh.plugins.base.impl.PluginManagerFactory;
import net.xeoh.plugins.base.impl.PluginManagerImpl;
import net.xeoh.plugins.base.impl.registry.PluginClassMetaInformation;
import net.xeoh.plugins.base.util.PluginConfigurationUtil;
import net.xeoh.plugins.base.util.PluginManagerUtil;
import net.xeoh.plugins.base.util.PluginUtil;

import com.doundo.Plugin.DoUndoPlugin;
import com.internalframe.DrawInternalFrame;
import com.mainframe.MainFrame;

public class Menubar extends JMenuBar implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainFrame mainFrame;

	private JMenuBar menuBar;

	private JMenu file = new JMenu("File");

	private JMenu plugins = new JMenu("Plugins");

	private JMenu help = new JMenu("Help");

	private JMenuItem newFile = new JMenuItem("New File");

	private JMenuItem openFile = new JMenuItem("Open File");

	private JMenuItem exitFile = new JMenuItem("Exit File");

	private JMenuItem loadPlugin = new JMenuItem("Load Plugin");

	public Menubar(MainFrame mainframe) {
		this.mainFrame = mainframe;
		menuBar = new JMenuBar();

		newFile.addActionListener(this);
		exitFile.addActionListener(this);
		openFile.addActionListener(this);

		loadPlugin.addActionListener(this);

		file.add(newFile);
		file.add(openFile);
		file.add(exitFile);

		plugins.add(loadPlugin);

		menuBar.add(file);
		menuBar.add(help);
		menuBar.add(plugins);

	}

	public JMenuBar getMenubar() {
		return menuBar;
	}
	
	public MainFrame getMainFrame(){
		return mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource().equals(newFile)) {
			Thread t = new Thread(new DrawInternalFrame(mainFrame));
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

		if (event.getSource().equals(loadPlugin)) {
			System.out.println("Load Plugin");
			PluginManager pluginManager = PluginManagerFactory.createPluginManager();
			pluginManager.addPluginsFrom(new File("bin/").toURI());
			

			DoUndoPlugin duPluging = pluginManager.getPlugin(DoUndoPlugin.class);
			duPluging.addMenu(this);
		}

	}
	
}
