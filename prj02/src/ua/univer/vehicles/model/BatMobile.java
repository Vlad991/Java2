package ua.univer.vehicles.model;

import ua.univer.vehicles.controller.FlyAble;

public class BatMobile extends Amphibian implements FlyAble {
	
	public BatMobile() {
		super();
	}

	public BatMobile(int x, int y, int price, int speed, int yearOfIssue) {
		super(x, y, price, speed, yearOfIssue);
	}

	@Override
	public String toString() {
		return "BatMobile [" + super.toString() + "]";
	}

	@Override
	public int fly() {
		return super.getSpeed()*10;
	}
	
}
