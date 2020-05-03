package ua.univer.component.beverages;

import ua.univer.component.Beverage;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		description = "House Blend Coffee";
	}

	@Override
	public double cost() {
		return .89;
	}

}
