package ua.univer.Enum;

enum DayOfWeek {
	Monday("Monday"), Tuesday(), Wednesday();
	String name;
	
	private DayOfWeek() {
	}
	
	private DayOfWeek(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}

public class EnumExample {
	
	public static void main(String[] args) {
		DayOfWeek monday = DayOfWeek.Monday;
		
	}

}
