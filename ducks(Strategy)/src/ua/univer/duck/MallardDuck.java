package ua.univer.duck;

import ua.univer.behaviors.fly.FlyWithWings;
import ua.univer.behaviors.quack.Quack;

public class MallardDuck extends Duck {
	
	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	@Override
	public void display() {
		System.out.println("I'm a real Mallard duck");
	}

}
