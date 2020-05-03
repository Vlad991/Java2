package ua.univer;

import ua.univer.fly.FlyRocketPowered;

public class MiniDuckSimulator {

	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.PerformQuack();
		mallard.PerformFly();
		
		Duck model = new ModelDuck();
		model.PerformFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.PerformFly();
		
	}

}
