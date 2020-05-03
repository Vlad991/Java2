package ua.univer.ingredients.factories;

import ua.univer.ingredients.cheese.Cheese;
import ua.univer.ingredients.cheese.Mozzarella;
import ua.univer.ingredients.clams.Clams;
import ua.univer.ingredients.clams.FrozenClams;
import ua.univer.ingredients.dough.Dough;
import ua.univer.ingredients.dough.ThickCrustDough;
import ua.univer.ingredients.pepperoni.Pepperoni;
import ua.univer.ingredients.pepperoni.SlicedPepperoni;
import ua.univer.ingredients.sauce.PlumTomatoSauce;
import ua.univer.ingredients.sauce.Sauce;
import ua.univer.ingredients.veggies.BlackOlives;
import ua.univer.ingredients.veggies.EggPlant;
import ua.univer.ingredients.veggies.Spinach;
import ua.univer.ingredients.veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThickCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		return new Mozzarella();
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Spinach(), new BlackOlives(), new EggPlant() };
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FrozenClams();
	}

}
