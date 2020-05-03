package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmi_interface.IRmiServerHello;

public class RmiServerHelloImpl extends UnicastRemoteObject implements IRmiServerHello {

	protected RmiServerHelloImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String print(String str) throws RemoteException {
		return "hello from " + str;
	}

}
