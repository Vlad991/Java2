package ua.univer.bank;

public class Cashier extends Thread {
	private String name;
	private Bank bank;

	public Cashier(String name, Bank bank) {
		this.name = name;
		this.bank = bank;
	}

	@Override
	public void run() {
		super.run();
	}
	
	
}
