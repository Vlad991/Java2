package ua.univer.Soccer;

public class Program {

	public static void main(String[] args) {
		SoccerTeam dynamo = new SoccerTeam();
		dynamo.put(11, "Rebrov");
		dynamo.put(0, "Shevchenko");
		dynamo.put(7, "Abramovich");
		dynamo.put(20, "Abramovich");
		dynamo.put(9, "Kaha");
		dynamo.put(30, "Berezovskiy");
		dynamo.put(27, "Milevskiy");
		dynamo.print();
	}

}
