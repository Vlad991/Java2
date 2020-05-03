package ua.univer.duck;

import ua.univer.behaviors.fly.FlyNoWay;
import ua.univer.behaviors.quack.Quack;

public class ModelDuck extends Duck{
	
	public ModelDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyNoWay();
	}

	@Override
	public void display() {
		System.out.println("I'm a model duck!");
	}

}
