package com.ecouteur;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import com.internalframe.DrawInternalFrame;
import com.mainframe.MainFrame;

public class DrawInternalFramelistenner implements InternalFrameListener {

	private MainFrame mainFrame;

	public DrawInternalFramelistenner(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		int rep = JOptionPane.showConfirmDialog(null,
				"Veux tu quitter l'application ?");
		if (rep == 0) {
			arg0.getInternalFrame().dispose();
			DrawInternalFrame dim = (DrawInternalFrame) arg0.getInternalFrame();
			mainFrame.removeDrawInternalFrameFromList(dim);
		}
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
	}

}
