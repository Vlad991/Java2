package ua.univer.bank;

import java.util.LinkedList;

public class Bank extends Thread {
	private int cash;
	private LinkedList<Client> clients;

	public Bank(int cash) {
		this.cash = cash;
		clients = new LinkedList<>();
	}
	
	@Override
	public void run() {
		while (true) {
			if 
		}
		
	}

	public int getCash() {
		return cash;
	}

	public void increaseCashOn(int cash) {
		this.cash += cash;
	}
	
	public void reduseCashOn(int cash) {
		this.cash -= cash;
	}

	public void addClient(Client client) {
		clients.add(client);
	}
	
}
