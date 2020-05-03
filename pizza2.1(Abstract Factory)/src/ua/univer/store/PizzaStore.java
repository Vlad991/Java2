package ua.univer.store;

import ua.univer.pizza.Pizza;

public abstract class PizzaStore {
	
	protected abstract Pizza createPizza(String type);//фабричный метод
	
	public Pizza orderPizza(String type) {
		Pizza pizza;
		
		pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}

}
