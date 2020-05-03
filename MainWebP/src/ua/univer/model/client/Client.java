package ua.univer.model.client;

public class Client {
	private int id;
	private String name;
	private String surname;
	private String dateOfBirth;

	public Client() {
		super();
	}

	public Client(String name, String surname, String dateOfBirth) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
	}

	public Client(int id, String name, String surname, String dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
