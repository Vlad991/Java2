package ua.univer.vehicles.model;

import ua.univer.vehicles.controller.MoveAble;

public class Car extends Vehicle implements MoveAble {

	public Car() {
		super();
	}

	public Car(int x, int y, int price, int speed, int yearOfIssue) {
		super(x, y, price, speed, yearOfIssue);
	}

	@Override
	public String toString() {
		return "Car [" + super.toString() + "]";
	}

	@Override
	public int move() {
		return super.getSpeed();
	}
}
