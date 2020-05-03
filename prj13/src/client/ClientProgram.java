package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi_interface.IRmiServerHello;

public class ClientProgram {

	public static void main(String[] args) throws NotBoundException, IOException {
		IRmiServerHello service = (IRmiServerHello) Naming.lookup("//localhost:1099/HelloService");
		while (true) {
			System.out.println("Enter ");
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			String word = console.readLine();
			if (word.equals("end"))
				break;
			String str = service.print(word);
			System.out.println(str);
		}
	}

}
