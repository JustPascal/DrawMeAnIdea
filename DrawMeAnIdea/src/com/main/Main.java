package com.main;

import javax.swing.SwingUtilities;

import com.mainframe.MainFrame;

public class Main {

	public static void main(String[] args) {

		Runnable r = new Runnable() {
			public void run() {
				new MainFrame();
			}
		};
		SwingUtilities.invokeLater(r);
	}

}
