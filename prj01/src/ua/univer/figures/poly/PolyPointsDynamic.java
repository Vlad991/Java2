package ua.univer.figures.poly;

import java.util.Arrays;

import ua.univer.figures.base.Point;

public class PolyPointsDynamic {
	private Point[] points;//ссылка
	private int count;
	
	public PolyPointsDynamic() {
		points = new Point[3];
		count=-1;
	}
	public void add(Point p) {
		if(count == points.length-1) //для всех динамических колекций
		{
//			Point [] temp = new Point[points.length*2];
			points = Arrays.copyOf(points, points.length*2);
//		 	for (int i = 0; i < points.length; i++) {
//				temp[i] = points[i];
//			}
//			points = temp; //пересвязать ссылку. темп удалился
		}
		points[++count] = p;
	}
	public Point get(int i) {
		if(i < size())
		return points[i];
		else return null;
	}
    public void set(int i, Point p) {
    	if(i < size())
    		points[i] = p;
	}
	public int size() {
		return count+1;
	}
	public void print() {
		for (int i = 0; i < size(); i++) {
			System.out.println(points[i]);
		}
	}
}
