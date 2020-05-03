package ua.univer;

import ua.univer.fly.FlyNoWay;
import ua.univer.quack.MuteQuack;
import ua.univer.quack.Quack;

public class ModelDuck extends Duck{
	
	
	public ModelDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyNoWay();
	}

	@Override
	public void display() {
		System.out.println("ModelDuck");
	}

}
