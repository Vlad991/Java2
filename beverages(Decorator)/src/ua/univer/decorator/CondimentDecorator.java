package ua.univer.decorator;

import ua.univer.component.Beverage;

public  abstract class CondimentDecorator extends Beverage {

	@Override
	public abstract String getDescription();
	
}
