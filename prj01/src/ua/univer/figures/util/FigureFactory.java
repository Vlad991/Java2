package ua.univer.figures.util;

import ua.univer.figures.Figure;
import ua.univer.figures.base.*;
import ua.univer.figures.color.*;

public class FigureFactory {
	public static Figure getFigure(int i){
		switch (i) {
		case 0: return new Point(1, 2);
		case 1: return new ColorPoint(4,5,777);
		case 2: return new Line(new Point(1,1),new Point(2,2));
		case 3: return new ColorLine(new Point(1,1),new Point(2,2),888);
		default: return null;
		}		
	}
	public static Figure randFigure(){
		return getFigure((int) (Math.random()*4));
	}
	public static Figure[] getListFigures(int n){
		Figure[] masFig = new Figure[n];
		for (int i = 0; i < masFig.length; i++) {
			masFig[i]=randFigure();
		}
		return masFig;
	}
}
