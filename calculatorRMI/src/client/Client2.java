package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi_interface.MyArrayRmi;

public class Client2 {

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		String url = "//localhost:1099/Array";
		MyArrayRmi Q = (MyArrayRmi) Naming.lookup(url);
		System.out.println("RMI object found");
		while (true)
		    Q.Add(Integer.valueOf(1));
	}

}
