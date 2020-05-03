package ua.univer;

import java.util.Arrays;

public class StackSquare {
	private Square[] masSquare;
	private int top;
	
	public StackSquare() {
		masSquare = new Square[10];
		top = -1;
	}
	
	public Square peek() {
		return masSquare[top];
	}
	
	private void eraseCapacity() {
		masSquare = Arrays.copyOf(masSquare, masSquare.length*2);
	}
	
	public Square push(Square sq) {
		if (isFull()) eraseCapacity();
		masSquare[++top] = sq;
		return sq;
	}
	
	private boolean isFull() {
		return top == masSquare.length - 1;
	}

	public Square pop() {
		if (!isEmpty()) {
			Square sq = masSquare[top];
			masSquare[top] = null;
			top--;
			return sq;
		} else return null;
	}

	public boolean isEmpty() {
		return top == -1;
	}
	
	public int size() {
		return top + 1;
	}
	
	public void print() {
		System.out.println("**********************");
		for (int i = 0; i < size(); i++) {
			System.out.println(masSquare[i]);
		}
	}
	
}
