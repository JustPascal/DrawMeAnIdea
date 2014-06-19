package com.mainframe;

import java.io.File;
import java.util.ArrayList;

import javax.swing.filechooser.FileFilter;

public class ImageNameFilter extends FileFilter {

	private String description;

	private ArrayList<String> extensions = new ArrayList<String>();

	public ImageNameFilter() {
		this.description = "format de type jpeg, jpg, png";
		extensions.add(".jpeg");
		extensions.add(".jpg");
		extensions.add(".png");
	}

	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}

		final String fileName = file.getName().toLowerCase();

		if (fileName.endsWith(extensions.get(0)) || fileName.endsWith(extensions.get(1)) || fileName.endsWith(extensions.get(2))) {
			return true;
		}
		return false;

	}

	@Override
	public String getDescription() {
		return description;
	}

}
