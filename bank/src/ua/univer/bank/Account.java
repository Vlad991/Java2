package ua.univer.bank;

public class Account {
	private int sum;
	private static Bank bank;
	
	public Account(int sum, Bank bank) {
		this.sum = sum;
		this.bank = bank;
	}
	
	public int getSum() {
		return sum;
	}

	public synchronized int getCash(int cash) {
		sum -= cash;
		bank.notify();
		return cash;
	}
	
	public synchronized void addCash(int cash) {
		sum += cash;
	}
	
	public synchronized void transferCashToClient(Client recipient, int cash) {
//		sum -= cash;
//		recipient.acount.setcash += cash;
	}
	
	public synchronized void payAmount(int amount) {
		sum -= amount;
		//send amound
	}
	
	public synchronized int exchangeAmount(int amount) {
		return 0;
	}
}
