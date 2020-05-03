package ua.univer.cars.view;

import ua.univer.cars.controller.CarList;
import ua.univer.cars.model.Car;
import ua.univer.cars.util.Cars;

public class CarProgram {
	public static void main(String[] args) {
		CarList carlist = new CarList();
		carlist.add(new Car(111, "Ford", 2010, 15000));
		carlist.add(new Car(112, "BMW", 2015, 25000));
		carlist.add(new Car(113, "AUDI", 2013, 35000));
		carlist.add(new Car(114, "Ford", 2014, 5000));
		carlist.add(new Car(115, "BMW", 2017, 45000));
		
		CarList carsBMW = carlist.getCarsByMarka("BMW");
		//carsBMW.print();
		Cars.SortByYears(carlist);
		carlist.print();
	}
}
