package ua.univer.figures.color;

import ua.univer.figures.base.Point;

public class ColorPoint extends Point implements ColorAble{
	private int color;

	public ColorPoint(int x, int y, int color) {
		super(x,y);
		this.color = color;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "ColorPoint [color=" + color + "," + super.toString() + "]";
	}
	
	
	
}
