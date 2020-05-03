package student;

public class Student {
	private int id;
	private String surName;
	private String name;
	private String patronymic;
	private int dateOfBirth;
	private String adress;
	private int phoneNumber;
	private String faculty;
	private int year;
	private int group;
	

	public Student(int id, String surName, String name, String patronymic, int dateOfBirth, String adress,
			int phoneNumber, String faculty, int year, int group) {
		super();
		this.id = id;
		this.surName = surName;
		this.name = name;
		this.patronymic = patronymic;
		this.dateOfBirth = dateOfBirth;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.faculty = faculty;
		this.year = year;
		this.group = group;
	}

	public Student() {
		id = 0;
	    surName = "";
		name = "";
		patronymic = "";
		dateOfBirth = 0;
		adress = "";
		phoneNumber = 0;
		faculty = "";
		year = 0;
		group = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public int getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", surName=" + surName + ", name=" + name + ", patronymic=" + patronymic
				+ ", dateOfBirth=" + dateOfBirth + ", adress=" + adress + ", phoneNumber=" + phoneNumber + ", faculty="
				+ faculty + ", year=" + year + ", group=" + group + "]";
	}
	
}
