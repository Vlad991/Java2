package ua.univer.vehicles.util;

import ua.univer.vehicles.controller.*;
import ua.univer.vehicles.model.*;

public class VehicleFactory {
	public static Vehicle getVehicle(int i) {
		switch(i) {
		case 0: return new Car(1, 1, 1000, 100, 2001);
		case 1: return new Plane(2, 2, 2000, 200, 2002, 20, 20);
		case 2: return new Ship(3, 3, 3000, 300, 2003, "Port3", 30);
		case 3: return new Amphibian(4, 4, 4000, 400, 2004);
		case 4: return new BatMobile(5, 5, 5000, 500, 2005);
		default: return null;
		}
	}
	public static Vehicle randVehicle() {
		return getVehicle((int) (Math.random()*5));
	}
	public static VehicleList getListVehicles(int n){
		VehicleList masVehic = new VehicleList();
		for (int i = 0; i < n; i++) {
			masVehic.Add(randVehicle());
		}
		return masVehic;
	}
}
