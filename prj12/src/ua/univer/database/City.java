package ua.univer.database;

public class City {
	private int code;
	private String name;
	private int count;
	private boolean isCapital;
	private Country country;
	public City(int code, String name, int count, boolean isCapital, Country country) {
		super();
		this.code = code;
		this.name = name;
		this.count = count;
		this.isCapital = isCapital;
		this.country = country;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isCapital() {
		return isCapital;
	}
	public void setCapital(boolean isCapital) {
		this.isCapital = isCapital;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "City [code=" + code + ", name=" + name + ", count=" + count + ", isCapital=" + isCapital + ", country="
				+ country + "]";
	}

	

}
