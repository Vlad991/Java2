package ua.univer.thread_test.notify_wait_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Program {
	
	static List<String> strings = Collections.synchronizedList(new ArrayList<>());

	public static void main(String[] args) {
		new Operator().start();
		new Machine().start();
	}
	
	static class Operator extends Thread {
		@Override
		public void run() {
			Scanner scanner = new Scanner(System.in);
			while (true) {
				synchronized (strings) {
					strings.add(scanner.nextLine());
					strings.notify();
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	static class Machine extends Thread {
		@Override
		public void run() {
			while (strings.isEmpty()) {
				synchronized (strings) {
					try {
						strings.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(strings.remove(0));
				}
			}
		}
	}

}
