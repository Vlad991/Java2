package countries;

public class Programm {

	public static void main(String[] args) throws Exception {
		Map m = new Map("map","localhost",3306);
		m.showCountries();
		m.addCountry(1, "RUS");
		m.addCountry(5, "JP");
		m.addCountry(6, "UKR");
		m.deleteCountry(3);
		m.deleteCountry(7);
		m.showCountries();
		m.stop();
	}

}
