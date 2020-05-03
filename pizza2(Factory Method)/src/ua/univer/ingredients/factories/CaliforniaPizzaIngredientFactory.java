package ua.univer.ingredients.factories;

import ua.univer.ingredients.cheese.Cheese;
import ua.univer.ingredients.cheese.GoatCheese;
import ua.univer.ingredients.clams.Calamari;
import ua.univer.ingredients.clams.Clams;
import ua.univer.ingredients.dough.Dough;
import ua.univer.ingredients.dough.VeryThinCrustDough;
import ua.univer.ingredients.pepperoni.Pepperoni;
import ua.univer.ingredients.pepperoni.SlicedPepperoni;
import ua.univer.ingredients.sauce.BruschettaSauce;
import ua.univer.ingredients.sauce.Sauce;
import ua.univer.ingredients.veggies.Garlic;
import ua.univer.ingredients.veggies.Mushroom;
import ua.univer.ingredients.veggies.Onion;
import ua.univer.ingredients.veggies.RedPepper;
import ua.univer.ingredients.veggies.Veggies;

public class CaliforniaPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new VeryThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new BruschettaSauce();
	}

	@Override
	public Cheese createCheese() {
		return new GoatCheese();
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
		return new Calamari();
	}

}
