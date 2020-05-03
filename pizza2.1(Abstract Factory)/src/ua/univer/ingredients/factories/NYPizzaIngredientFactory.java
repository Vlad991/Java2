package ua.univer.ingredients.factories;

import ua.univer.ingredients.cheese.Cheese;
import ua.univer.ingredients.cheese.ReggianoCheese;
import ua.univer.ingredients.clams.Clams;
import ua.univer.ingredients.clams.FreshClams;
import ua.univer.ingredients.dough.Dough;
import ua.univer.ingredients.dough.ThinCrustDough;
import ua.univer.ingredients.pepperoni.Pepperoni;
import ua.univer.ingredients.pepperoni.SlicedPepperoni;
import ua.univer.ingredients.sauce.MarinaraSauce;
import ua.univer.ingredients.sauce.Sauce;
import ua.univer.ingredients.veggies.Garlic;
import ua.univer.ingredients.veggies.Mushroom;
import ua.univer.ingredients.veggies.Onion;
import ua.univer.ingredients.veggies.RedPepper;
import ua.univer.ingredients.veggies.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FreshClams();
	}

}
