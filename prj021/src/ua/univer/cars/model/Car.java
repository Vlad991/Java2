package ua.univer.cars.model;

public class Car {
	private int id;
	private String marka;
	private int year;
	private int price;
	public Car(int id, String marka, int year, int price) {
		super();
		this.id = id;
		this.marka = marka;
		this.year = year;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", marka=" + marka + ", year=" + year + ", price=" + price + "]";
	}
	
}
