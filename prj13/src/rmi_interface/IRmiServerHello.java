package rmi_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRmiServerHello extends Remote {
	String print(String str) throws RemoteException;
}
