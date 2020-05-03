package ua.univer.vehicles.util;

import ua.univer.vehicles.controller.FlyAble;
import ua.univer.vehicles.controller.MoveAble;
import ua.univer.vehicles.controller.SwimAble;
import ua.univer.vehicles.controller.VehicleList;
import ua.univer.vehicles.model.Vehicle;

public class Vehicles {
	public static void SortByYears(VehicleList vehicles){
		for (int i = 0; i < vehicles.size(); i++) {
			for (int j = 0; j < vehicles.size()-1-i; j++) {
				if(vehicles.get(j).getYearOfIssue()>vehicles.get(j+1).getYearOfIssue()){
					Vehicle t = vehicles.get(j);
					vehicles.set();
					vehicles.set(j+1, t);
				}
			}			
		}
	}
	public static VehicleList getCars(VehicleList v) {
		VehicleList masMove = new VehicleList();
		for (int i = 0; i < v.size(); i++) {
			if(v.get(i) instanceof MoveAble){
				masMove.Add(v.get(i)); 
			}
		}
		return masMove;
	}
	public static VehicleList getPlanes(VehicleList v) {
		VehicleList masFly = new VehicleList();
		for (int i = 0; i < v.size(); i++) {
			if(v.get(i) instanceof FlyAble){
				masFly.Add(v.get(i)); 
			}
		}
		return masFly;
	}
	public static VehicleList getShips(VehicleList v) {
		VehicleList masSwim = new VehicleList();
		for (int i = 0; i < v.size(); i++) {
			if(v.get(i) instanceof SwimAble){
				masSwim.Add(v.get(i)); 
			}
		}
		return masSwim;
	}
	public static VehicleList getAmphibians(VehicleList v) {
		VehicleList masMoveAndSwim = new VehicleList();
		for (int i = 0; i < v.size(); i++) {
			if(v.get(i) instanceof MoveAble){
				if (v.get(i) instanceof SwimAble) {
					masMoveAndSwim.Add(v.get(i));
				}
			}
		}
		return masMoveAndSwim;
	}
	public static VehicleList getBatMobiles(VehicleList v) {
		VehicleList masMoveSwimFly = new VehicleList();
		for (int i = 0; i < v.size(); i++) {
			if(v.get(i) instanceof MoveAble){
				if (v.get(i) instanceof SwimAble) {
					if (v.get(i) instanceof FlyAble) {
						masMoveSwimFly.Add(v.get(i));
					}
				}
			}
		}
		return masMoveSwimFly;
	}
}
