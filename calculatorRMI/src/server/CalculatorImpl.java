package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmi_interface.CalculatorRmi;
import rmi_interface.Operands;

public class CalculatorImpl extends UnicastRemoteObject implements CalculatorRmi {

	protected CalculatorImpl() throws RemoteException {
		super();
	}

	@Override
	public int sum(Operands o) throws RemoteException {
		return o.x + o.y;
	}

	@Override
	public int sub(Operands o) throws RemoteException {
		return o.x - o.y;
	}

}
