package ua.univer;

import ua.univer.behaviors.fly.FlyRocketPowered;
import ua.univer.duck.Duck;
import ua.univer.duck.MallardDuck;
import ua.univer.duck.ModelDuck;

public class MiniDuckSimulator {

	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}

}
