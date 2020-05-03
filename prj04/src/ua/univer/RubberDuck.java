package ua.univer;

import ua.univer.fly.FlyNoWay;
import ua.univer.quack.Squeak;

public class RubberDuck extends Duck {
	
	public RubberDuck() {
		quackBehavior = new Squeak();
		flyBehavior = new FlyNoWay();
	}

	@Override
	public void display() {
		System.out.println("RubberDuck");
	}

}
