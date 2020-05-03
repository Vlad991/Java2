package prj0311;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
interface FlyAble{
	int fly();
	default void foo(int i) {
		System.out.println("out Foo1");
	}
}
interface MoveAble{
	//String COLOR="RED";
	int move();
	default void foo(int i) {
		System.out.println("out Foo2");
	}
}
class Car implements MoveAble, Comparable<Car>, Cloneable, FlyAble{//маркерный интерфейс, дает что мы использовали переопределение Object.clone()
	private int year;
	private String name;
	private int speed;
	private Address address;
	
	public Car(int year, String name, int speed) {
		this.year = year;
		this.name = name;
		this.speed = speed;
	}
	public Car cloneCar() {
		return new Car(year, name, speed);//не удобно когда много полей
	}
	public Car clone() throws CloneNotSupportedException{
		return (Car) super.clone();//удобно когда много полей, нужен Cloneable
	}
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public int move() {
		return speed;
	}
//	@Override
//	public int compareTo(Object o) {
//		Car c = (Car)o;
//		return 0;
//	}
	@Override
	public int compareTo(Car c) {
//		if(this.speed>c.speed)return 1; 
//		if(this.speed==c.speed)return 0;
//		if(this.speed<c.speed)return -1;
		return this.speed-c.speed;
	}
	@Override
	public String toString() {
		return "Car [year=" + year + ", name=" + name + ", speed=" + speed + "]";
	}
	@Override
	public int fly() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void foo(int i) {
		// TODO Auto-generated method stub
		FlyAble.super.foo(i);
		MoveAble.super.foo(i);
	}
		
}

class CompareByYear implements Comparator<Car> {
	@Override
	public int compare(Car c1, Car c2) {
		return c1.getYear()-c2.getYear();
	}
}
class CompareByName implements Comparator<Car> {
	@Override
	public int compare(Car c1, Car c2) {
		return c1.getName().compareTo(c2.getName());
	}
}

public class Programm {

	public static void main(String[] args) throws CloneNotSupportedException{
		int mas [] = {1,3,5,6,856,4};
		Arrays.sort(mas);
		System.out.println(Arrays.toString(mas));
		String strMas [] = {"Petya", "Vasya", "Alla"};
		Arrays.sort(strMas);
//		System.out.println(Arrays.toString(strMas));
		Car carMas [] = new Car[3];
		carMas[0] = new Car(12, "F", 30);
		carMas[1] = new Car(9, "A", 10);
		carMas[2] = new Car(4, "N", 20);
		Arrays.sort(carMas, new Comparator<Car>() { //анонимный класс
			@Override
			public int compare(Car c1, Car c2) {
				if (c1.getSpeed() == c2.getSpeed())
				return c1.getYear() - c2.getYear();
				else
				return c1.getSpeed() - c2.getSpeed();
			}
			
		});
		
//		System.out.println(Arrays.toString(carMas));
		
		Arrays.sort(carMas, (c1, c2)-> c1.getYear() - c2.getYear());//анонимный класс
		Array.sort(carMas);//сортировка по методу comparable
		System.out.println(Arrays.toString(carMas));
		Car c = new Car(11, "BMW", 10);
		Car c2 = c.clone();
		System.out.println(c.hashCode());
		System.out.println(c);
		System.out.println(c2.hashCode());
		System.out.println(c2);
		c2.setName("Ford");
		System.out.println(c);
		System.out.println(c2);
		c.foo(1);
		
	}

}
