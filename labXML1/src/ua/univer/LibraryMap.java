package ua.univer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.print.attribute.standard.MediaSize.NA;
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

class SimpleErrorHandler implements ErrorHandler {

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		System.out.println("Строка " + exception.getLineNumber() + ":");
		System.out.println(exception.getMessage());
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		System.out.println("Строка " + exception.getLineNumber() + ":");
		System.out.println(exception.getMessage());
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("Строка " + exception.getLineNumber() + ":");
		System.out.println(exception.getMessage());
	}

}

public class LibraryMap {
	private ArrayList<Author> authors;
	private ArrayList<Book> books;

	public LibraryMap() {
		authors = new ArrayList<>();
		books = new ArrayList<>();
	}

	public void validate(String fileName, String xsd) throws Exception {
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		Schema s = sf.newSchema(new File(xsd));

		DocumentBuilderFactory dbf;
		DocumentBuilder db;
		Document doc;
		dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(true);

		dbf.setSchema(s);
		db = dbf.newDocumentBuilder();
		db.setErrorHandler(new SimpleErrorHandler());
		doc = db.parse(new File(fileName));
	}

	public void saveToFile(String filename) throws Exception {
		DocumentBuilderFactory dbf = null;
		DocumentBuilder db = null;
		Document doc = null;

		dbf = DocumentBuilderFactory.newInstance();
		db = dbf.newDocumentBuilder();

		doc = db.newDocument();

		Element root = doc.createElement("map");
		doc.appendChild(root);

		for (Author author : authors) {
			Element elemAuthor = doc.createElement("author");
			elemAuthor.setAttribute("code", Integer.toString(author.getCode()));
			elemAuthor.setAttribute("name", author.getName());
			root.appendChild(elemAuthor);
			for (Book book : books) {
				if (book.getAuthor() == author) {
					Element elemBook = doc.createElement("book");
					elemBook.setAttribute("code", Integer.toString(book.getCode()));
					elemBook.setAttribute("name", book.getName());
					elemBook.setAttribute("isnew", book.isNew() == true ? "1" : "0");
					elemBook.setAttribute("numberofpages", Integer.toString(book.getNumberOfPages()));
					elemAuthor.appendChild(elemBook);
				}
			}
		}

		Source domSource = new DOMSource(doc);
		Result fileResult = new StreamResult(new File(filename));
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.transform(domSource, fileResult);

	}

	public void loadFromFile(String filename) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = null;
		DocumentBuilder db = null;
		dbf = DocumentBuilderFactory.newInstance();
		db = dbf.newDocumentBuilder();

		Document doc = db.parse(new File(filename));

		Element root = doc.getDocumentElement();
		if (root.getTagName().equals("map")) {
			NodeList listAuthor = root.getElementsByTagName("author");
			for (int i = 0; i < listAuthor.getLength(); i++) {
				if (listAuthor.item(i) instanceof Element) {
					Element elemAuthor = (Element) listAuthor.item(i);
					int code = Integer.parseInt(elemAuthor.getAttribute("code"));
					String name = elemAuthor.getAttribute("name");
					Author curAuthor = new Author(code, name);
					authors.add(curAuthor);
					NodeList listBook = elemAuthor.getElementsByTagName("book");
					for (int j = 0; j < listBook.getLength(); j++) {
						if (listBook.item(j) instanceof Element) {
							Element elemBook = (Element) listBook.item(j);
							int code_b = Integer.parseInt(elemBook.getAttribute("code"));
							String name_b = elemBook.getAttribute("name");
							boolean isNew = elemBook.getAttribute("isnew").equals("1");
							int numberOfPages = Integer.parseInt(elemBook.getAttribute("numberofpages"));
							Book curBook = new Book(code_b, name_b, isNew, numberOfPages, curAuthor);
							books.add(curBook);
						}
					}
				}
			}
		}

	}

	public void addAuthor(int code, String name) {
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).getCode() == code) {
				authors.remove(i);
			}
		}
		authors.add(new Author(code, name));
	}

	public Author getAuthor(int code) {
		for (Author author : authors) {
			if (author.getCode() == code)
				return author;
		}
		return null;
	}

	public void addBook(int code, String name, boolean isNew, int numberOfPages, int authorCode) {
		books.add(new Book(code, name, isNew, numberOfPages, getAuthor(authorCode)));
	}

	public void print() {
		for (Author author : authors) {
			System.out.println(author.getCode() + " " + author.getName() + ":");
			for (Book book : books) {
				if (book.getAuthor().getCode() == book.getAuthor().getCode()) {
				System.out.println(book);
				}
			}
		}
	}

}
