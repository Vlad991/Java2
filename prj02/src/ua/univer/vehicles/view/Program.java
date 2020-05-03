package ua.univer.vehicles.view;

import ua.univer.vehicles.controller.VehicleList;
import ua.univer.vehicles.util.VehicleFactory;
import ua.univer.vehicles.util.Vehicles;

public class Program {

	public static void main(String[] args) {
		
//		CPlane p0 = new CPlane();
//		System.out.println("pl.getPrice=" + p0.getPrice());
//		
//		CPlane p = new CPlane(1, 0, 1000, 100, 2001, 10, 10);
//		p.setSpeed(1);
//				
//		CShip s = new CShip(2, 2, 2000, 200, 2002, "", 20);
//		s.setHomePort("Port1");
//		
//		CCar c = new CCar(3, 3, 3000, 300, 0);
//		c.setYearOfIssue(2003);
//		
//		CVehicle[] masCVhc = new CVehicle[4];
//		masCVhc[0] = p0;
//		masCVhc[1] = p;
//		masCVhc[2] = s;
//		masCVhc[3] = c;
//		
//		for (int i = 0; i < masCVhc.length; i++) {
//			System.out.println(masCVhc[i]);
//		}
//		VehicleList vehic = new VehicleList();
//		vehic.Add(new Plane(1, 0, 1000, 100, 2001, 10, 10));
//		vehic.Add(new Car(3, 3, 3000, 300, 0));
//		vehic.Add(new Ship(2, 2, 2000, 200, 2002, "Port1", 20));
//		vehic.Add(new Car(3, 3, 3000, 300, 0));
//		
////		vehic.ShowPriceList(3000);
////		vehic.ShowListSpeedYear(200, 2002);
////		vehic.ShowListPriceYear(2000, 2000);
//		
//		VehicleList vehicPriceList = new VehicleList();
//		VehicleList vehicSpeedYearList = new VehicleList();
//		VehicleList vehicPriceYearList = new VehicleList();
//		
//		vehicPriceList = vehic.GetPriceList(3000);
//		vehicSpeedYearList = vehic.GetSpeedYearList(200, 2000);
//		vehicPriceYearList = vehic.GetPriceYearList(2000, 2000);
//		
//		vehicPriceList.print();
//		vehicSpeedYearList.print();
//		vehicPriceYearList.print();
		System.out.println("********************************");
		VehicleList vehicList = new VehicleList();
		vehicList = VehicleFactory.getListVehicles(10);
		
		VehicleList masMove = Vehicles.getCars(vehicList);
		VehicleList masSwim = Vehicles.getShips(vehicList);
		VehicleList masFly = Vehicles.getPlanes(vehicList);
		VehicleList masMoveSwim = Vehicles.getAmphibians(vehicList);
		VehicleList masMoveSwimFly = Vehicles.getBatMobiles(vehicList);
		System.out.println("Cars:");
		masMove.print();
		System.out.println("Ships:");
		masSwim.print();
		System.out.println("Planes:");
		masFly.print();
		System.out.println("Amphibians:");
		masMoveSwim.print();
		System.out.println("BatMobiles:");
		masMoveSwimFly.print();
		
	}

}
