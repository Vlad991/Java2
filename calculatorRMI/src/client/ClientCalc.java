package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi_interface.CalculatorRmi;
import rmi_interface.Operands;

public class ClientCalc {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		String url = "//localhost:1098/Calc";
		CalculatorRmi Q = (CalculatorRmi) Naming.lookup(url);
		System.out.println("RMI object found");
		Operands q = new Operands(20, 10);
		int x = Q.sum(q);
		int y = Q.sub(q);
		System.out.println(x);
		System.out.println(y);
	}

}
