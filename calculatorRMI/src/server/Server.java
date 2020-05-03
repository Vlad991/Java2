package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) throws RemoteException {
		MyArrayImpl helloMyArrayImpl = new MyArrayImpl();
        Registry registry1 = LocateRegistry.createRegistry(1099);
        registry1.rebind("Array", helloMyArrayImpl);
        System.out.println("Server Array started!");
        
        CalculatorImpl helloCalculatorImpl = new CalculatorImpl();
        Registry registry2 = LocateRegistry.createRegistry(1098);
        registry2.rebind("Calc", helloCalculatorImpl);
        System.out.println("Server Calc started!");
	}

}
