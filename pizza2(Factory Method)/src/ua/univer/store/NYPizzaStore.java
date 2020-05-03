package ua.univer.store;

import ua.univer.pizza.Pizza;
import ua.univer.pizza.NYstyle.NYStyleCheesePizza;
import ua.univer.pizza.NYstyle.NYStyleClamPizza;
import ua.univer.pizza.NYstyle.NYStylePepperoniPizza;
import ua.univer.pizza.NYstyle.NYStyleVeggiePizza;

public class NYPizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String item) {//фабричный метод
		if (item.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (item.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else if (item.equals("clam")) {
			return new NYStyleClamPizza();
		} else if (item.equals("veggie")) {
			return new NYStyleVeggiePizza();
		} else return null;
	}

}
