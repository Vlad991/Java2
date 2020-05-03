package ua.univer.vehicles.controller;

import java.util.Arrays;

import ua.univer.vehicles.model.Vehicle;

public class VehicleList {
	private Vehicle[] vehicles;
	private int count;
	
	public VehicleList() {
		vehicles = new Vehicle[4];
		count = -1;
	}
	
	public void Add(Vehicle cv) {
		if (count == vehicles.length - 1) {
			vehicles = Arrays.copyOf(vehicles, vehicles.length*2);
		}
		vehicles[++count] = cv;
	}
	public Vehicle get(int i) {
		if(i < size())
		return vehicles[i];
		else return null;
	}
	public void set(int i, Vehicle vehic) {
		vehicles[i] = vehic;
	}
	public int size() {
		return count+1;
	}
	public VehicleList GetPriceList (int p) {
		VehicleList vehiclist = new VehicleList();
		for (int i = 0; i < size(); i++) {
			if (vehicles[i].getPrice() == p) {
				vehiclist.Add(vehicles[i]);
			}
		}
		return vehiclist;
	}
	
	public VehicleList GetSpeedYearList (int speed, int year) {
		VehicleList vehiclist = new VehicleList();
		for (int i = 0; i < size(); i++) {
			if (vehicles[i].getSpeed() == speed) {
				if (vehicles[i].getYearOfIssue() >= year) {
					vehiclist.Add(vehicles[i]);
				}
			}
		}
		return vehiclist;
	}
	
	public VehicleList GetPriceYearList (int price, int year) {
		VehicleList vehiclist = new VehicleList();
		for (int i = 0; i < size(); i++) {
			if (vehicles[i].getPrice() == price) {
				if (vehicles[i].getYearOfIssue() >= year) {
					vehiclist.Add(vehicles[i]);
				}
			}
		}
		return vehiclist;
	}
	public void print() {
		for (int i = 0; i < size(); i++) {
			System.out.println(vehicles[i]);
		}
	}
	
}
