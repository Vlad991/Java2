package ua.univer.store;

import ua.univer.ingredients.factories.ChicagoPizzaIngredientFactory;
import ua.univer.ingredients.factories.PizzaIngredientFactory;
import ua.univer.pizza.CheesePizza;
import ua.univer.pizza.ClamPizza;
import ua.univer.pizza.PepperoniPizza;
import ua.univer.pizza.Pizza;
import ua.univer.pizza.VeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
		
		if (item.equals("cheese")) {
			
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");
			
		} else if (item.equals("pepperoni")) {
			
			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Chicago Style Pepperoni Pizza");
			
		} else if (item.equals("clam")) {
			
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("Chicago Style Clam Pizza");
			
		} else if (item.equals("veggie")) {
			
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("Chicago Style Veggie Pizza");
			
		}
		
		return pizza;
	}

}
