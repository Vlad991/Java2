package ua.univer.database;

public class Program {
	public static void main(String[] args) {
		try {
			Map map = new Map();
			map.show();
			map.addCountry(new Country(3, "RUS"));
			map.deleteCountry("UK");
			map.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
