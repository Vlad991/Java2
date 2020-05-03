package ua.univer.vehicles.model;

import ua.univer.vehicles.controller.FlyAble;

public class Plane extends Vehicle implements FlyAble{
	private int height;
	private int numberOfPassengers;
	
	
	public Plane() {
		this.height = 0;
		this.numberOfPassengers = 0;
	}
	
	public Plane(int x, int y, int price, int speed, int yeraOfIssue, int height, int numberOfPassengers) {
		super(x, y, price, speed, yeraOfIssue);
		this.height = height;
		this.numberOfPassengers = numberOfPassengers;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int h) {
		this.height = h;
	}
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(int np) {
		this.numberOfPassengers = np;
	}
	@Override
	public String toString() {
		return "Plane [" + super.toString() + ", height=" + height + ", numberOfPassengers=" + numberOfPassengers + "]";
	}

	@Override
	public int fly() {
		return super.getSpeed()*10;
	}
	
	
}
