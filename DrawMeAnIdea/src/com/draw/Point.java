package com.draw;

import java.awt.Color;

public class Point {

	private int X;

	private int Y;

	private Color color;

	private int dotLineSize;

	private String dotLineForme = "circle";

	public Point(final int x, final int y, final Color color, final int dotlineSize, final String dotlineForme) {
		this.X = x;
		this.Y = y;
		this.color = color;
		this.dotLineSize = dotlineSize;
		this.dotLineForme = dotlineForme;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Point))
			return false;
		Point point = (Point) obj;
		if (this.getX() == point.getX())
			if (this.getY() == point.getY())
				if (this.getColor() == point.getColor())
					if (this.getDotLineSize() == point.getDotLineSize())
						if (this.getDotLineForme().equals(point.getDotLineForme()))
							return true;
		return false;

	}

	public int getDotLineSize() {
		return dotLineSize;
	}

	public void setDotLineSize(int dotLineSize) {
		this.dotLineSize = dotLineSize;
	}

	public String getDotLineForme() {
		return dotLineForme;
	}

	public void setDotLineForme(String dotLineForme) {
		this.dotLineForme = dotLineForme;
	}
}
