package ua.univer;

public class Program {
	int x;

	class Inner {
		int y;
	}

	public static void main(String[] args) {
		new Program().x = 1;
		Program p = new Program();
		Inner in = p.new Inner();
		new Program().new Inner().y = 2;
		in.y = 2;
		System.out.println("main");
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {

				System.out.print("x");
			}
		});
		t1.setDaemon(true);      //компилятор не дожидается их полного выполнения
		t1.start();
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.print("y");
			}
		});
		t2.setDaemon(true);
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main end");
	}

}
