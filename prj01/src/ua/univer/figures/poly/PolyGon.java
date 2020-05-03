package ua.univer.figures.poly;

import java.util.Arrays;

import ua.univer.figures.Figure;
import ua.univer.figures.base.Line;
import ua.univer.figures.base.Point;

public class PolyGon extends Figure {
	private Point[] points;
	private Line[] lines;
	public PolyGon(Point[] points) {
		this.points = points;
//		for (int i = 0; i < this.points.length; i++) {
//			Line line;
//			line = new Line(points[i], points[i+1]);
//			this.lines[i] = line;
		}
//	}
//	public Line getLines(int index) {
//		return lines[index];
//	}
	@Override
	public String toString() {
		return "PolyGon [points=" + Arrays.toString(points) + "]";
	}
	
}
