package ua.univer.busstation;

import java.util.LinkedList;

public class Program {

	public static void main(String[] args) {
		ListNodeBus autopark = new ListNodeBus();
		ListNodeBus autoroute = new ListNodeBus();
		autopark.addFirst(new Bus(1, "Vasya", 11));
		autopark.addFirst(new Bus(2, "Basya", 11));
		autopark.addLast(new Bus(3, "Tasya", 11));
		autopark.addFirst(new Bus(4, "Masya", 11));
		autopark.addFirst(new Bus(5, "Dasya", 11));
		autopark.print();
		autoroute.addFirst(autopark.eraseBusByNumber(5));
		autopark.print();
		autoroute.addFirst(autopark.eraseBusByNumber(3));
		autopark.print();
		autoroute.addFirst(autopark.eraseBusByNumber(2));
		autopark.print();
		autopark.addLast(new Bus(6, "Gasya", 11));
		autopark.print();
		autoroute.print();
		
//		System.out.println("*****************************");
//		for (int i = 0; i < 4; i++) {
//			System.out.println(autopark.getBus(i));
//		}
//		System.out.println("*****************************");
//		for (Bus bus : autopark) {
//			System.out.println(bus);
//		}
		
		LinkedList<Bus> list = new LinkedList<>();
		//list.
		
	}

}
