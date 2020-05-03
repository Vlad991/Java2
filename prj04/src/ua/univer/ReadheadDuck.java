package ua.univer;

import ua.univer.fly.FlyNoWay;
import ua.univer.fly.FlyWithWings;
import ua.univer.quack.MuteQuack;
import ua.univer.quack.Quack;
import ua.univer.quack.Squeak;

public class ReadheadDuck extends Duck{
	
	public ReadheadDuck() {
		quackBehavior = new MuteQuack();
		flyBehavior = new FlyNoWay();
	}

	@Override
	public void display() {
		System.out.println("ReadheadDuck");
		
	}

}
