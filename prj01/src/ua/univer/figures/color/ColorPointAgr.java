package ua.univer.figures.color;

import ua.univer.figures.base.Point;

public class ColorPointAgr {
	private Point point;
	private int color;
	public ColorPointAgr(Point p, int c) {
		point = p;
		color = c;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "ColorPointAgr [point=" + point + ", color=" + color + ", " + hashCode() + "]";
	}
	

}
