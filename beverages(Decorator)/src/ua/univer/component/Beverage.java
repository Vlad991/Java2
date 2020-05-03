package ua.univer.component;

public abstract class Beverage {
	
	protected String description = "Unkwon Beverage";

	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
	
}
