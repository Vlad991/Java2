package ua.univer;

import java.util.List;
import java.util.ArrayList;

public class TestPurchase {

	public static void main(String[] args) throws Exception {
		PurchaseDAO p = new PurchaseDAO();
		List<Integer> l = new ArrayList<Integer>();
		List<Purchase> pl = new ArrayList<Purchase>();
		System.out.println(l);
		System.out.println(pl);
		l = p.getPurchaseIds();
		pl = p.getPurchaseById(1);
		System.out.println(l);
		System.out.println(pl);
		p.addPurchase(new Purchase(4, "Sky", pl.get(0).getProduct(), 5));
		pl = p.getPurchaseById(3);
		System.out.println(pl);
	}

}
