package ua.univer;

import java.util.Arrays;

import ua.univer.figures.Figure;
import ua.univer.figures.base.Line;
import ua.univer.figures.base.Point;
import ua.univer.figures.base.Triangle;
import ua.univer.figures.color.ColorAble;
import ua.univer.figures.color.ColorLine;
import ua.univer.figures.color.ColorPoint;
import ua.univer.figures.color.ColorPointAgr;
import ua.univer.figures.color.ColorPolyGon;
import ua.univer.figures.color.ColorTriangle;
import ua.univer.figures.poly.PolyGon;
import ua.univer.figures.poly.PolyPointsDynamic;
import ua.univer.figures.util.FigureFactory;
//import ua.univer.figures.poly.PolyPointsException;
class Flower implements ColorAble{

	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return 777;
	}
	
}
public class Program {

	public static void main(String[] args) {
		System.out.println("-> "+new Object()+1+2+" x "+3*(4+5));
		Point p = new Point(1,2);
		Point p1 = new Point(1,1);
		System.out.println(p);
		System.out.println(p1);
		ColorPoint cp1 = new ColorPoint(2, 3, 333333);
     	ColorPointAgr cp2 = new ColorPointAgr(p, 444444);
		System.out.println(cp1);
		System.out.println(cp2);
		Line l1= new Line(p, p1);
		System.out.println(l1);
		Line l2= new Line(6,6,7,7);
		System.out.println(l2);
		Line l3= new Line(new Point(8,8),new Point(9,9));
		System.out.println(l3);
		Line l4= new Line(l2.getBegin(),l3.getEnd());
		ColorLine cl1= new ColorLine(p, p1, 555555)	;
		System.out.println(cl1);
		Triangle t = new Triangle(p, p1, new Point(3,3));
		ColorTriangle ct = new ColorTriangle(p, p1, new Point(3,3), 66666);
		System.out.println(t);
		System.out.println(ct);
		Point[] pnts = {p, p1, new Point(5,5), new Point(7,7)};
		PolyGon pg = new PolyGon(pnts);
		System.out.println(pg);
		ColorPolyGon cpg = new ColorPolyGon(pnts, 999999);
		System.out.println("****************************");
		Figure[] masObj = FigureFactory.getListFigures(100);
		System.out.println(Arrays.toString(masObj));
		System.out.println("****************************");
//		masObj[0] = p;
//		masObj[1] = cp1;
//		masObj[2] = l1;
//		masObj[3] = cl1;
//		masObj[4] = new Figure();
//		masObj[4] = t;
//		masObj[5] = ct;
//		masObj[6] = pg;
//    	masObj[7] = cpg;
		Point [] masPoint =  new Point[masObj.length];
		int ipoint =0;
		ColorAble [] masColor = new ColorAble[masObj.length];		
		int iColor=0;
		masColor[iColor++]=new Flower();
		masColor[iColor++]=() -> 42;
		
		for (int i = 0; i < masObj.length; i++) {
			if(masObj[i] instanceof ColorAble){
				masColor[iColor++]= (ColorAble) masObj[i];
			}
			if(masObj[i] instanceof Point){
			Point tp =((Point)masObj[i]);
			masPoint[ipoint]=tp;
			ipoint++;
			System.out.println(tp.getX());}
		}
//		System.out.println("*********************************");
//		for (int i = 0; i < masColor.length; i++) {
//			System.out.println(masColor[i].getColor());
//		}
		System.out.println("********************Color");
		for (int i = 0; i < masColor.length; i++) {
		if(masColor[i]!=null)	System.out.println(masColor[i].getColor());
		}
		System.out.println("**********************************");
		PolyPointsDynamic poly = new PolyPointsDynamic();
		
		poly.add(new Point(1,5));
		poly.add(new Point(5,9));
		poly.add(new Point(1,5));
		poly.add(new Point(6,5));
		poly.add(new Point(1,5));
		poly.add(new Point(1,6));
//		catch (PolyPointsException e) {
//			System.err.println("Лишняя точка сохранена не будет");
//		}
//		catch (Exception e) {
//			System.err.println("Все плохо");
//			throw e;
//		}
//		for (int i = 0; i < poly.size(); i++) {
//		System.out.println(poly.get(i));
//		}
		
//		poly.print();
		
	}

}
