package com.mainframe;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ImageNameFilter extends FileFilter {

	private String description;

	private String extension;

	public ImageNameFilter() {
		this.description = "image de type .png";
		this.extension = ".png";
	}

	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}

		final String fileName = file.getName().toLowerCase();

		if (fileName.endsWith(extension)) {
			return true;
		}
		return false;

	}

	@Override
	public String getDescription() {
		return description;
	}

}
