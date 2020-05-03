package ua.univer.behaviors.quack;

public class MuteQuack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("<< Silence >>");
	}

}
