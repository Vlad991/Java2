package ua.univer.figures.color;

import ua.univer.figures.base.Point;
import ua.univer.figures.poly.PolyGon;

public class ColorPolyGon extends PolyGon {
	private int color;

	public ColorPolyGon(Point[] points, int color) {
		super(points);
		this.color = color;
	}
	@Override
	public String toString() {
		return "ColorPolyGon [color=" + color + ", " + super.toString() + "]";
	}
	
}
