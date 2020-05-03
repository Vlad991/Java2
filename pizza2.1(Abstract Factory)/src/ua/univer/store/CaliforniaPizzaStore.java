package ua.univer.store;

import ua.univer.ingredients.factories.CaliforniaPizzaIngredientFactory;
import ua.univer.ingredients.factories.PizzaIngredientFactory;
import ua.univer.pizza.CheesePizza;
import ua.univer.pizza.ClamPizza;
import ua.univer.pizza.PepperoniPizza;
import ua.univer.pizza.Pizza;
import ua.univer.pizza.VeggiePizza;

public class CaliforniaPizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new CaliforniaPizzaIngredientFactory();
		
		if (item.equals("cheese")) {
			
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("California Style Cheese Pizza");
			
		} else if (item.equals("pepperoni")) {
			
			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("California Style Pepperoni Pizza");
			
		} else if (item.equals("clam")) {
			
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("California Style Clam Pizza");
			
		} else if (item.equals("veggie")) {
			
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("California Style Veggie Pizza");
			
		}
		
		return pizza;
	}

}
