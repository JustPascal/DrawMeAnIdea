package com.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Locale;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.swing.JFileChooser;
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

	public MainFrame getMainFrame() {
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
			// PluginManager pluginManager = PluginManagerFactory
			// .createPluginManager();
			// pluginManager.addPluginsFrom(new File("plugins/").toURI());

			// DoUndoPlugin duPluging = pluginManager
			// .getPlugin(DoUndoPlugin.class);
			// duPluging.addMenu(this);
			// System.out.println(DoUndoPlugin.class);

			String pathToJar = "/Users/pascal/Desktop/plugins/doRedo.jar";
			JarFile jarFile = null;
			try {
				jarFile = new JarFile(pathToJar);
				Enumeration e = jarFile.entries();
				URL[] urls = { new URL("jar:file:" + pathToJar + "!/") };
				URLClassLoader cl = URLClassLoader.newInstance(urls);
				while (e.hasMoreElements()) {
					JarEntry je = (JarEntry) e.nextElement();
					System.out.println("___" + je.getName());
					if (je.isDirectory() || !je.getName().endsWith(".class")) {
						continue;
					}
					String className = je.getName().substring(0,
							je.getName().length() - 6);
					className = className.replace('/', '.');
					if (className.contains("Impl")) {
						System.out.println("Class ends with impl ==>"
								+ className);
						Class<?> c = cl.loadClass(className);
						for (Method uneMethode : c.getDeclaredMethods()) {
							if (uneMethode.getName().equals("addMenu")) {
								System.out.println(" Methode Name : "
										+ uneMethode.getName());
								uneMethode.setAccessible(true);
								Object t = c.newInstance();
								uneMethode.invoke(t, this);
							}
						}
					}
				}
			} catch (IOException e) {
				System.out.println(" Error found : " + e.getMessage());
			} catch (ClassNotFoundException e1) {
				System.out.println(" Class not found : " + e1.getMessage());
			} catch (SecurityException e1) {
				System.out.println("Error Security" + e1.getMessage());
			} catch (InstantiationException e1) {
				System.out.println(" Error Instanciation : " + e1.getMessage());
			} catch (IllegalAccessException e1) {
				System.out
						.println(" Error Illegal Access : " + e1.getMessage());
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
}
