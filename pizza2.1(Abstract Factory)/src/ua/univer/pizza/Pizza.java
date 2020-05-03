package ua.univer.pizza;

import java.util.ArrayList;

import ua.univer.ingredients.cheese.Cheese;
import ua.univer.ingredients.clams.Clams;
import ua.univer.ingredients.dough.Dough;
import ua.univer.ingredients.pepperoni.Pepperoni;
import ua.univer.ingredients.sauce.Sauce;
import ua.univer.ingredients.veggies.Veggies;

public abstract class Pizza {
	
	protected String name;
	protected Dough dough;
	protected Sauce sauce;
	protected Veggies veggies[];
	protected Cheese cheese;
	protected Pepperoni pepperoni;
	protected Clams clam;

	public abstract void prepare();

	public void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}

	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	public void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pizza [name=" + name + ", dough=" + dough + ", sauce=" + sauce + ", veggies=" + veggies + ", cheese="
				+ cheese + ", pepperoni=" + pepperoni + ", clam=" + clam + "]";
	}
	

}
