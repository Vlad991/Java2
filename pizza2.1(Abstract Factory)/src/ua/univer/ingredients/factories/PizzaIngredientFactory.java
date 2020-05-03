package ua.univer.ingredients.factories;

import ua.univer.ingredients.cheese.Cheese;
import ua.univer.ingredients.clams.Clams;
import ua.univer.ingredients.dough.Dough;
import ua.univer.ingredients.pepperoni.Pepperoni;
import ua.univer.ingredients.sauce.Sauce;
import ua.univer.ingredients.veggies.Veggies;

public interface PizzaIngredientFactory {
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
	
}
