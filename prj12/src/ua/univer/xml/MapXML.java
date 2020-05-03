package ua.univer.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import ua.univer.database.City;
import ua.univer.database.Country;

class SimpleErrorHandler implements ErrorHandler {
	public void warning(SAXParseException e) throws SAXException {
		System.out.println(e.getMessage());
	}

	public void error(SAXParseException e) throws SAXException {
		System.out.println(e.getMessage());
	}

	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println(e.getMessage());
	}
}

public class MapXML {
	List<Country> countries;
	List<City> cities;

	public MapXML() {
		countries = new ArrayList<>();
		cities = new ArrayList<>();
	}

	public void printCountry() {
		for (Country country : countries) {
			System.out.println(country);
		}
	}

	public void printCity() {
		for (City city : cities) {
			System.out.println(city);
		}
	}

	public void printMap() {
		for (Country country : countries) {
			System.out.println(country);
			for (City city : cities) {
				if (city.getCountry() == country)
					System.out.println(">>>>" + city);
			}
		}
	}

	public void validate(String fileName, String xsd) throws Exception {

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		// Создаю схему из xsd файла
		Schema s = sf.newSchema(new File(xsd));

		DocumentBuilderFactory dbf;
		DocumentBuilder db;
		Document doc;
		dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(true);
		// Привязываю схему к фабрике парсеров

		dbf.setSchema(s);
		db = dbf.newDocumentBuilder();
		db.setErrorHandler(new SimpleErrorHandler());
		doc = db.parse(new File(fileName));

	}

	public void loadFromFile(String fileName) throws Exception {

		DocumentBuilderFactory dbf;
		DocumentBuilder db;
		Document doc;

		dbf = DocumentBuilderFactory.newInstance();
		db = dbf.newDocumentBuilder();
		doc = db.parse(new File(fileName));

		Element root = doc.getDocumentElement();
		if (root.getTagName().equals("map")) {
			NodeList listCountry = root.getElementsByTagName("country");
			for (int i = 0; i < listCountry.getLength(); i++) {
				if (listCountry.item(i) instanceof Element) {
					Element elemCountry = (Element) listCountry.item(i);
					int id = Integer.parseInt(elemCountry.getAttribute("id"));
					String name = elemCountry.getAttribute("name");
					Country curCountry = new Country(id, name);
					countries.add(curCountry);
					NodeList listCity = elemCountry.getElementsByTagName("city");
					for (int j = 0; j < listCity.getLength(); j++) {
						if (listCity.item(j) instanceof Element) {
							Element elemCity = (Element) listCity.item(j);
							int id_ci = Integer.parseInt(elemCity.getAttribute("id"));
							String name_ci = elemCity.getAttribute("name");
							boolean isCap = elemCity.getAttribute("iscap").equals("1");
							int count = Integer.parseInt(elemCity.getAttribute("count"));
							City curCity = new City(id_ci, name_ci, count, isCap, curCountry);
							cities.add(curCity);
						}
					}
				}
			}
		}
	}

	public void saveToFile(String fileName) throws Exception {
		DocumentBuilderFactory dbf = null;
		DocumentBuilder db = null;
		Document doc = null;
		dbf = DocumentBuilderFactory.newInstance();
		db = dbf.newDocumentBuilder();
		// Создаем "чистый" документ XML
		doc = db.newDocument();

		// Создаем корневой элемент
		Element root = doc.createElement("map");
		doc.appendChild(root);

		for (Country country : countries) {
			// Создаем объект "страна"
			Element elemCountry = doc.createElement("country");
			elemCountry.setAttribute("id", Integer.toString(country.getId()));
			elemCountry.setAttribute("name", country.getName());
			root.appendChild(elemCountry);
			for (City city : cities) {
				if (city.getCountry() == country) {
					Element elemCity = doc.createElement("city");
					elemCity.setAttribute("id", Integer.toString(city.getCode()));
					elemCity.setAttribute("name", city.getName());
					elemCity.setAttribute("count", Integer.toString(city.getCount()));
					elemCity.setAttribute("iscap", city.isCapital() == true ? "1" : "0");
					elemCountry.appendChild(elemCity);
				}
			}
		}

		Source domSource = new DOMSource(doc);
		Result fileResult = new StreamResult(new File(fileName));
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "WINDOWS-1251");
		transformer.transform(domSource, fileResult);

	}
}
