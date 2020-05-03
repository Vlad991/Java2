package rmi_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorRmi extends Remote {
	public int sum(Operands o) throws RemoteException;
    public int sub(Operands o) throws RemoteException;
}
