package ua.univer.vehicles.model;

import ua.univer.vehicles.controller.SwimAble;

public class Ship extends Vehicle implements SwimAble {
	private String homePort;
	private int numberOfPassengers;
	
	public Ship() {
		super();
	}
	
	public Ship(int x, int y, int price, int speed, int yeraOfIssue, String homePort, int numberOfPassengers) {
		super(x, y, price, speed, yeraOfIssue);
		this.homePort = homePort;
		this.numberOfPassengers = numberOfPassengers;
	}
	
	public String getHomePort() {
		return homePort;
	}
	public void setHomePort(String hp) {
		this.homePort = hp;
	}
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(int np) {
		this.numberOfPassengers = np;
	}
	@Override
	public String toString() {
		return "Ship [" + super.toString() + ", homePort=" + homePort + ", numberOfPassengers=" + numberOfPassengers + "]";
	}

	@Override
	public int swim() {
		return super.getSpeed()/2;
	}
	
}
