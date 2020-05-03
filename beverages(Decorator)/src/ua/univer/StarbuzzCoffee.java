package ua.univer;

import ua.univer.component.Beverage;
import ua.univer.component.beverages.DarkRoast;
import ua.univer.component.beverages.Espresso;
import ua.univer.component.beverages.HouseBlend;
import ua.univer.decorator.condiments.Mocha;
import ua.univer.decorator.condiments.Soy;
import ua.univer.decorator.condiments.Whip;

public class StarbuzzCoffee {

	public static void main(String[] args) {
		
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());
		
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
		
		Beverage beverage3 = new HouseBlend();
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
		
	}

}
