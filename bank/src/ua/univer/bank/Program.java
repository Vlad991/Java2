package ua.univer.bank;

public class Program {

	public static void main(String[] args) {
		Bank bank = new Bank(1000000);
		bank.setDaemon(true);
		
		Cashier cashier = new Cashier("Vasya", bank);
		cashier.setDaemon(true);
		
		bank.start();
		cashier.start();
/////////////////////////////////////////////////////////////////////////////////////////////////		
		
		Client c1 = new Client("Vasya", 1000, bank);
		Client c2 = new Client("Vova", 2000, bank);
		new Thread(c1).start();
		new Thread(c2).start();
//		new Thread(()-> {
//		c1.withdrawCash(100);
//		}).start();
		
		
	}
	
	
	
	

}
