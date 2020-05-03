package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	private Socket sock = null;
	private DataOutputStream out = null;
	private DataInputStream in = null;

	// конструктор
	public Client(String ip, int port) throws IOException {
		// Устанавливаем соединение
		sock = new Socket(ip, port);
		// Получаем потоки ввода-вывода
		in = new DataInputStream(sock.getInputStream());
		out = new DataOutputStream(sock.getOutputStream());
	}

	// отправить запрос серверу и получить ответ
	private int sendQuery(int operation, int value1, int value2) throws IOException {
		// отправляю запрос
		out.writeInt(operation);
		out.writeInt(value1);
		out.writeInt(value2);
		// получаю ответ
		int res = in.readInt();
		return res;
	}

	// посчитать сумму чисел
	public int sum(int value1, int value2) throws IOException {
		return sendQuery(0, value1, value2);
	}

	// посчитать разность чисел
	public int sub(int value1, int value2) throws IOException {
		return sendQuery(1, value1, value2);
	}

	// отсоединиться
	public void disconnect() throws IOException {
		sock.close();
	}

	// главный метод
	public static void main(String[] args) {
		try {
			Client client = new Client("localhost", 12345);
			int a = client.sum(15, 20);
			int b = client.sub(30, 38);
			int c = client.sum(100, 200);
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			client.disconnect();
		} catch (IOException e) {
			System.out.println("Возникла ошибка");
		}
	}

}
