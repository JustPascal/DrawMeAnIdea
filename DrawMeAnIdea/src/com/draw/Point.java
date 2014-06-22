package com.draw;

import java.awt.Color;

public class Point {

	private int X;
	private int Y;
	private Color color;

	public Point(int x, int y, Color color) {
		this.X = x;
		this.Y = y;
		this.color = color;
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
					return true;
		return false;

	}
}
