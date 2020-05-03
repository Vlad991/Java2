package ua.univer.busstation;

import java.util.Iterator;

public class ListNodeBus implements Iterable<Bus> {
private class NodeBusIterator implements Iterator<Bus> {
	private NodeBus current;
	
	public NodeBusIterator(NodeBus head) {
		current = head;
	}
		
	@Override
	public boolean hasNext() {
		return current != null;      //почему не (current.next != null) ?????????????????????????????????????????????????????????????????
	}
	
	@Override
	public Bus next() {
		Bus bus = current.getData();
		current = current.next;
		return bus;
	}
		
}

	private NodeBus head;
	private NodeBus tail;
	
	public void addFirst(Bus bus) {
		NodeBus node = new NodeBus(bus);
		if(head == null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
		}
	}
	
	public void addLast(Bus bus) {
		NodeBus node = new NodeBus(bus);
		if(head == null) {
			head = node;
			tail = node;
		} else {
//			NodeBus current = head;
//			while (current.next != null) {
//			current = current.next;	
//		}
//			current.next = node;
			tail.next = node;
			tail = node;
		}
		
	}
	
	public Bus findBusByNumber(int number) {
		NodeBus current = head;
		while(current != null) {
			if (current.getData().getNumber() == number) return current.getData();
			current = current.next;
		}
		return null;
	}
	
	public Bus eraseBusByNumber(int number) {
		NodeBus current = head;
		NodeBus prev = null;
		while(current != null) {
			if (current.getData().getNumber() == number) { 
				if (current == head) {
					Bus bus = head.getData();
					head = head.next;
					return bus;
				} else {
					Bus bus = current.getData();
				    prev.next = current.next;
				    if (current == tail) { tail = prev;}
			        current = null;
				    return bus;	
				}
			}
			prev = current;
			current = current.next;
		}
		return null;
	}
	
	public Bus getBus(int i) {
		NodeBus current = head;
		int count = 0;
		while(current != null) {
			if (i == count) return current.getData();
			count++;
			current = current.next;
		}
		return null;
	}
	
	public void print() {
		System.out.println("***************************");
		NodeBus current = head;
		while(current != null) {
			System.out.println(current.getData());
			current = current.next;
		}
	}
	
	public void printMyIterator() {
		Iterator<Bus> iterator = this.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	@Override
	public Iterator<Bus> iterator() {
		return new NodeBusIterator(head);
	}
	
	
}
