package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import rmi_interface.MyArrayRmi;

public class MyArrayImpl extends UnicastRemoteObject implements MyArrayRmi {
	private ArrayList<Integer> x;

	protected MyArrayImpl() throws RemoteException {
		x = new ArrayList<Integer>();
	}

	@Override
	public void Add(Integer v) throws RemoteException {
		synchronized (x) {
			x.add(v);
		}
	}

	@Override
	public int Sum() throws RemoteException {
		int sum = 0;
		synchronized (x) {
			for (Object i : x) {
				sum += (Integer) i;
			}
			return sum;
		}
	}

}
