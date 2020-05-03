package ua.univer.component.beverages;

import ua.univer.component.Beverage;

public class Espresso extends Beverage {

	public Espresso() {
		description = "Espresso";
	}

	@Override
	public double cost() {
		return 1.99;
	}

}
