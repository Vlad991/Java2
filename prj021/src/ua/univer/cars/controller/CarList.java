package ua.univer.cars.controller;

import ua.univer.cars.model.Car;

public class CarList {
	private Car [] cars;
	private int count;
	public CarList() {
		cars= new Car[5];
		count=-1;
	}
	public void add(Car car) {
		cars[++count]= car;
	}
	public Car get(int i) {
		return cars[i];
	}
	public void set(int i, Car c) {
		cars[i]=c;
	}
	public int size() {
		return count+1;
	}
	public void print() {
		for (int i = 0; i < size(); i++) {
			System.out.println(cars[i]);
		}
	}
	public void printCarsByMarka(String marka ){
		for (int i = 0; i < size(); i++) {
			if(cars[i].getMarka().equals(marka)){
				System.out.println(cars[i]);
			}
		}		
	}
	public CarList getCarsByMarka(String marka ){
		CarList carsByMarka = new CarList();
		for (int i = 0; i < size(); i++) {
			if(cars[i].getMarka().equals(marka)){
				carsByMarka.add(cars[i]);
			}
		}	
		return carsByMarka;
	}
}
