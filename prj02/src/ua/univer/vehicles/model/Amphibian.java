package ua.univer.vehicles.model;

import ua.univer.vehicles.controller.SwimAble;

public class Amphibian extends Car implements SwimAble{
	
	public Amphibian() {
		super();
	}

	public Amphibian(int x, int y, int price, int speed, int yearOfIssue) {
		super(x, y, price, speed, yearOfIssue);
	}

	@Override
	public String toString() {
		return "Amphibian [" + super.toString() + "]";
	}

	@Override
	public int swim() {
		return super.getSpeed()/2;
	}
}
