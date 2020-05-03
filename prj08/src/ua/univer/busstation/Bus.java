package ua.univer.busstation;

public class Bus {
	private int number;
	private String name;
	private int route;
	
	public Bus(int number, String name, int route) {
		super();
		this.number = number;
		this.name = name;
		this.route = route;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoute() {
		return route;
	}

	public void setRoute(int route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "Bus [number=" + number + ", name=" + name + ", route=" + route + "]";
	}
	
	
}
