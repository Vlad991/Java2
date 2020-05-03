package ua.univer.component.beverages;

import ua.univer.component.Beverage;

public class DarkRoast extends Beverage {
	
	public DarkRoast() {
		description = "Dark Roast Coffee";
	}

	@Override
	public double cost() {
		return .99;
	}
	
}
