package ua.univer.vehicles.model;

import ua.univer.vehicles.controller.MoveAble;

public abstract class Vehicle {
	private int x;
	private int y;
	private int price;
	private int speed;
	private int yearOfIssue;
	
	public Vehicle() {
		this.x = 0;
		this.y = 0;
		this.price = 0;
		this.speed = 0;
		this.yearOfIssue = 2000;
	}
	public Vehicle(int x, int y, int price, int speed, int yearOfIssue) {
		this.x = x;
		this.y = y;
		this.price = price;
		this.speed = speed;
		this.yearOfIssue = yearOfIssue;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getYearOfIssue() {
		return yearOfIssue;
	}
	public void setYearOfIssue(int yearOfIssue) {
		this.yearOfIssue = yearOfIssue;
	}
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y + ", price=" + price + ", speed=" + speed + ", yearOfIssue=" + yearOfIssue;
	}
	
	
}
