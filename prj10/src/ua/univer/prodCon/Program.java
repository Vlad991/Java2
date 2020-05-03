package ua.univer.prodCon;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Buffer {
	int n;
	boolean emptyBuf = true;

	public synchronized void put(int n) {
		while (!emptyBuf) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.n = n;
		System.out.println("put = " + n);
		emptyBuf = false;
		notifyAll();
	}

	public synchronized int get() {
		while (emptyBuf) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("get = " + n);
		emptyBuf = true;
		notifyAll();
		return n;
	}

}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Producer {
	public Producer(Buffer buf) {
		new Thread(() -> {
			int i = 0;
			while (true)
				buf.put(i++);
		}).start();
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Consumer {
	public Consumer(Buffer buf) {
		new Thread(() -> {
			while (true)
				buf.get();
		}).start();
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Program {

	public static void main(String[] args) {
		Buffer buf = new Buffer();
		new Consumer(buf);
		new Producer(buf);
		new Consumer(buf);
		new Producer(buf);
		new Consumer(buf);
		new Producer(buf);

	}

}
