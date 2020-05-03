package ua.univer;

enum ESquareCondition {
	Opened(0), Closed(1);
	int condition;

	private ESquareCondition(int condition) {
		this.condition = condition;
	}
	
}

public class Square {
	private int x;
	private int y;
	private ESquareCondition condition;
	
	public Square(int x, int y, ESquareCondition condition) {
		this.x = x;
		this.y = y;
		this.condition = condition;
	}

	public ESquareCondition getCondition() {
		return condition;
	}
	
	public void setCondition(ESquareCondition condition) {
		this.condition = condition;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		if (condition == ESquareCondition.Closed) {
			return "0";
		} else {
			return "1";
		}
	}
	
	
}
