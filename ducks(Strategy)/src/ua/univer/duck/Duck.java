package ua.univer.duck;

import ua.univer.behaviors.fly.FlyBehavior;
import ua.univer.behaviors.quack.QuackBehavior;

public abstract class Duck {
	
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public Duck() {
	}

	public abstract void display();
	
	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}
	
	public void performQuack() {
		quackBehavior.quack();
	}
	
	public void performFly() {
		flyBehavior.fly();
	}
	
	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}
	
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
	
}
