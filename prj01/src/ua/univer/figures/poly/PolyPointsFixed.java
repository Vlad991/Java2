package ua.univer.figures.poly;

import ua.univer.figures.base.Point;

class PolyPointsException extends Exception {
}
public class PolyPointsFixed {
	private Point[] points;
	private int count;
	public PolyPointsFixed(int n) {
		points = new Point[n];
		count=-1;
	}
	public PolyPointsFixed() {
		points = new Point[3];
		count=-1;
		generate3Point();
	}
	private void generate3Point() {
		points[0] = new Point(1, 1);
		points[0] = new Point(1, 2);
		points[0] = new Point(2, 1);
	}
	public void add(Point p) throws PolyPointsException {
		if(count < points.length-1)
		points[++count] = p;
		else throw new PolyPointsException();
	}
	public Point get(int i) {
		if(i < points.length-1)
		return points[i];
		else return null;
	}
    public void set(int i, Point p) throws PolyPointsException {
    	if(i < points.length-1)
    		points[i] = p;
    	else throw new PolyPointsException();
	}
	public int size() {
		return points.length;
	}
	public void print() {
		for (Point point : points) {
			System.out.println(point);
		}
	}
	

}
