package ua.univer;

import ua.univer.fly.FlyWithWings;
import ua.univer.quack.Quack;
import ua.univer.quack.Squeak;

public class MallardDuck extends Duck {
	
	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	@Override
	public void display() {
		System.out.println("MallardDuck");
	}

}
