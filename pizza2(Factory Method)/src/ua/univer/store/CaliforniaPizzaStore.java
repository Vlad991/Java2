package ua.univer.store;

import ua.univer.pizza.Pizza;
import ua.univer.pizza.Californiastyle.CaliforniaStyleCheesePizza;
import ua.univer.pizza.Californiastyle.CaliforniaStyleClamPizza;
import ua.univer.pizza.Californiastyle.CaliforniaStylePepperoniPizza;
import ua.univer.pizza.Californiastyle.CaliforniaStyleVeggiePizza;

public class CaliforniaPizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String item) {//фабричный метод
		if (item.equals("cheese")) {
			return new CaliforniaStyleCheesePizza();
		} else if (item.equals("pepperoni")) {
			return new CaliforniaStylePepperoniPizza();
		} else if (item.equals("clam")) {
			return new CaliforniaStyleClamPizza();
		} else if (item.equals("veggie")) {
			return new CaliforniaStyleVeggiePizza();
		} else return null;
	}

}
