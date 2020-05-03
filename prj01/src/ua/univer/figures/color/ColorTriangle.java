package ua.univer.figures.color;

import ua.univer.figures.base.Point;
import ua.univer.figures.base.Triangle;

public class ColorTriangle extends Triangle {
	private int color;
	public ColorTriangle(Point apexA, Point apexB, Point apexC, int color) {
		super(apexA,apexB,apexC);
		this.color = color;
	}
	@Override
	public String toString() {
		return "ColorTriangle [color=" + color + ", " + super.toString() + "]";
	}
	
}
