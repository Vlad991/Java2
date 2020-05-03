package ua.univer.decorator.condiments;

import ua.univer.component.Beverage;
import ua.univer.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator {
	
	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
//	public int getSize() {
//		return beverage.getSize();
//	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double cost() {
		return .15 + beverage.cost();
//		double cost = beverage.cost();
//		if (getSize() == Beverage.TALL) {
//			cost += .10;
//		} else if (getSize() == Beverage.GRANDE) {
//			cost += .15;
//		} else if (getSize() == Beverage.VENTI) {
//			cost += .20;
//		}
//		return cost;
	}
	
}
