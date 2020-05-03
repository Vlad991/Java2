package ua.univer.thread_test.threads_example;

public class Program {

	public static void main(String[] args) throws Exception {
		MyThread myThread = new MyThread();
		myThread.start();
		System.out.println(Thread.currentThread().getName());
		
		MyRunnable myRunnable = new MyRunnable();
		Thread thread2 = new Thread(myRunnable);
		thread2.start();

	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
//		System.out.println("this is new thread");
//		someMethod();
	}

//	private void someMethod() {
//		throw new RuntimeException();
//	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}
