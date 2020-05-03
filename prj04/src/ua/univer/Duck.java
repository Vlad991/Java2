package ua.univer;

import ua.univer.fly.FlyBehavior;
import ua.univer.quack.QuackBehavior;

public abstract class Duck {
	
	public Duck() {
	}
	public abstract void display();
	
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public void PerformFly() {
		flyBehavior.fly();
	}
	
	public void PerformQuack() {
		quackBehavior.quack();
	}
	
	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}
	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
	
	
}
