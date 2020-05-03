package ua.univer;

public class Book {
	private int code;
	private String name;
	private boolean isNew;
	private int numberOfPages;
	private Author author;
	
	public Book(int code, String name, boolean isNew, int numberOfPages, Author author) {
		super();
		this.code = code;
		this.name = name;
		this.isNew = isNew;
		this.numberOfPages = numberOfPages;
		this.author = author;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [code=" + code + ", name=" + name + ", isNew=" + isNew + ", numberOfPages=" + numberOfPages
				+ ", author=" + author + "]";
	}
	
}
