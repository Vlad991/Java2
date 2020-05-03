package ua.univer.railway;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.Vector;

public class Program {

	public static void main(String[] args) {
		Calendar.getInstance().getTimeInMillis();
		IStackVagon train = new StackVagon2();
		IStackVagon pass = new StackVagon3();
		IStackVagon cargo = new StackVagon();
		
		for (int i = 0; i < 13; i++) {
			if (i % 2 == 0) 
				train.push(new Vagon(EVagonType.Cargo));
			else
				train.push(new Vagon("Pass"));
		}
		
		train.print();
		
		while (!train.isEmpty()) {
			if(train.peek().getVagonType() == EVagonType.Cargo)
				cargo.push(train.pop());
		    else 
				pass.push(train.pop());
		}
		
		train.print();
		cargo.print();
		pass.print();
		
		Stack<Vagon> stack = new Stack<>();
		
		stack.push(new Vagon(EVagonType.Cargo));
		
		Vector vector;
		
		HashSet map;
	}

}
