package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerProgram {

	public static void main(String[] args) throws RemoteException {
		System.out.println("Server start");
		RmiServerHelloImpl serviceHello = new RmiServerHelloImpl();
		Registry reg = LocateRegistry.createRegistry(1099);
		reg.rebind("HelloService", serviceHello);
		System.out.println("Server stop");
	}

}
