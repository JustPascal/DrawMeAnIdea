package com.pluginloader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.menu.Menubar;

public class PluginLoader {

	public PluginLoader(Menubar menubar) {
		init(menubar);
	}

	private void init(Menubar menubar) {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("c:/"));
		fc.setDialogTitle("Choisir plugin");
		fc.setFileFilter(new FileNameExtensionFilter("JAR", "jar"));
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("Yolo");
			File file = fc.getSelectedFile();
			String path = file.getAbsolutePath();

			JarFile jarFile = null;
			try {
				jarFile = new JarFile(path);
				Enumeration<?> e = jarFile.entries();
				URL[] urls = { new URL("jar:file:" + path + "!/") };
				URLClassLoader cl = URLClassLoader.newInstance(urls);
				while (e.hasMoreElements()) {
					JarEntry je = (JarEntry) e.nextElement();
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
								Object obj = c.newInstance();
								uneMethode.invoke(obj, menubar);
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
				e1.printStackTrace();
			}

		}
	}

}
