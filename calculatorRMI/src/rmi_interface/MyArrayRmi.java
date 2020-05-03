package rmi_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyArrayRmi extends Remote {
	public void Add(Integer v) throws RemoteException;
    public int Sum() throws RemoteException;
}
