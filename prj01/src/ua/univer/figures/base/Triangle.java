package ua.univer.figures.base;

import ua.univer.figures.Figure;

public class Triangle extends Figure {
	private Point apexA;
	private Point apexB;
	private Point apexC;
	private Line sideAB;
	private Line sideBC;
	private Line sideAC;
	public Triangle(Point apexA, Point apexB, Point apexC) {
		super();
		this.apexA = apexA;
		this.apexB = apexB;
		this.apexC = apexC;
		//sideAB = new Line(apexA, apexB);
		//sideAC = new Line(apexA, apexC);
		//sideBC = new Line(apexB, apexC);
	}
//	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
//		this.apexA = new Point(x1, y1);
//		this.apexB = new Point(x2, y2);
//		this.apexC = new Point(x3, y3);
//	}
	public Line getSideAB() {
		if(sideAB==null)sideAB = new Line(apexA, apexB);
		return sideAB;
	}
	public Line getSideBC() {
		if(sideBC==null)sideBC = new Line(apexB, apexC);
		return sideBC;
	}
	public Line getSideAC() {
		if(sideAC==null)sideAC = new Line(apexA, apexC);
		return sideAC;
	}
	@Override
	public String toString() {
		return "Triangle [apexA=" + apexA + ", apexB=" + apexB + ", apexC=" + apexC + "]";
	}
	
	
}
