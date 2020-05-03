package ua.univer.bank;

public class Client implements Runnable {
	private String name;
	private Account account;
	private Bank bank;

	public Client(String name, int sum, Bank bank) {
		this.name = name;
		this.account = new Account(sum, bank);
		this.bank = bank;
		bank.addClient(this);
	}

	@Override
	public void run() {
		new InfoClient(this);
//		while (true) {
//			
//		}
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

//	public synchronized void withdrawCash(int amount) {
//		account -= amount;
//		//bank.setCash();
//		System.out.println("I'm withdrawing $" + amount);
//		notify();
//	}
//	
//    public void topUpAccount(int amount) {
//		
//	}
//    
//    public void transferAmountToRecipient(Client recipient) {
//		
//	}
//    
//	public void payTheAmount(int amount) {
//		
//	}
//	
//	public void exchangeTheAmount(int amount) {
//		
//	}

}
