package ua.univer;

public class ProgramXML {

	public static void main(String[] args) throws Exception {
		Author author = new Author(1, "Pushkin");
		Book book = new Book(2, "loh", true, 100, author);
		
		LibraryMap map = new LibraryMap();
		
		map.loadFromFile("map/map.xml");
		map.addAuthor(author.getCode(), author.getName());
		map.addBook(book.getCode(), book.getName(), book.isNew(), book.getNumberOfPages(), author.getCode());
		map.saveToFile("map/map.xml");
		map.print();
	}

}
