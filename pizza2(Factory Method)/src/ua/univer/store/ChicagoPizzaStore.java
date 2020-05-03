package ua.univer.store;

import ua.univer.pizza.Pizza;
import ua.univer.pizza.Chicagostyle.ChicagoStyleCheesePizza;
import ua.univer.pizza.Chicagostyle.ChicagoStyleClamPizza;
import ua.univer.pizza.Chicagostyle.ChicagoStylePepperoniPizza;
import ua.univer.pizza.Chicagostyle.ChicagoStyleVeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String item) {//фабричный метод
		if (item.equals("cheese")) {
			return new ChicagoStyleCheesePizza();
		} else if (item.equals("pepperoni")) {
			return new ChicagoStylePepperoniPizza();
		} else if (item.equals("clam")) {
			return new ChicagoStyleClamPizza();
		} else if (item.equals("veggie")) {
			return new ChicagoStyleVeggiePizza();
		} else return null;
	}

}
