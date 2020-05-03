package ua.univer.xml;

import java.io.File;

import ua.univer.database.City;
import ua.univer.database.Country;
import ua.univer.database.Map;

public class ProgramXML {

	public static void main(String[] args) {
		Country country = new Country(1, "UA");
		City city = new City(1, "Kiev", 1, true, country);
		
		MapXML map = new MapXML();
		try {
			map.loadFromFile("source" + File.separator + "map.xml");
			map.printMap();
			map.saveToFile("source" + File.separator + "map2.xml");
			
			Map mapDB = new Map();
			for (Country c : map.countries) {
				mapDB.addCountry(c);
			}
			
			mapDB.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
