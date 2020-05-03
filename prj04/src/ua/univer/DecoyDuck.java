package ua.univer;

import ua.univer.fly.FlyNoWay;
import ua.univer.quack.MuteQuack;
import ua.univer.quack.Squeak;

public class DecoyDuck extends Duck{
	
	public DecoyDuck() {
		quackBehavior = new MuteQuack();
		flyBehavior = new FlyNoWay();
	}

	@Override
	public void display() {
		System.out.println("DecoyDuck");
	}

}
