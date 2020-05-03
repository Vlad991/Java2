package ua.univer.railway;

import java.util.Stack;

public class StackVagon3 extends Stack<Vagon> implements IStackVagon {

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void print() {
		System.out.println("-------------------------------");
		for (Vagon vagon : this) {
			System.out.println(vagon);
		}
	}

}
