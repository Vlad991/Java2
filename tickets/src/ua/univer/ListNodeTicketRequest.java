package ua.univer;

import java.util.Iterator;

public class ListNodeTicketRequest implements Iterable<TicketRequest> {
private class NodeTicketRequestIterator implements Iterator<TicketRequest> {
	private NodeTicketRequest current;
	private NodeTicketRequest previous;

	public NodeTicketRequestIterator(NodeTicketRequest head) {
		current = head;
		previous = null;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public TicketRequest next() {
		TicketRequest request = current.getData();
		previous = current;
		current = current.next;
		return request;
	}
	
	@Override
	public void remove() {
//		if (current == head) {
//			head = current.next;
//			previous.next = head;
//			current = head;
//		} else if (current == tail) {
//			previous.next = null;
//			current = null;
//			tail = previous;
//		} else {
//			previous.next = current.next;
//			current = current.next;
//		}
	}
	
	
}
	private NodeTicketRequest head;
	private NodeTicketRequest tail;
	
	public void addTicketRequest(TicketRequest ticketRequest) {
		NodeTicketRequest node = new NodeTicketRequest(ticketRequest);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}
	
	public TicketRequest eraseTicketRequestByPassengerName(String passengerName) {
		NodeTicketRequest current = head;
		NodeTicketRequest prev = null;
		while(current != null) {
			if (current.getData().getPassengerName().equals(passengerName)) { 
				if (current == head) {
					TicketRequest request = head.getData();
					head = head.next;
					return request;
				} else {
					TicketRequest request = current.getData();
				    prev.next = current.next;
				    if (current == tail) { tail = prev;}
			        current = null;
				    return request;	
				}
			}
			prev = current;
			current = current.next;
		}
		return null;
	}
	
	public ListNodeTicketRequest findTicketRequestByNumberAndDate (int flightNumber, String departureDate) {
		ListNodeTicketRequest list = new ListNodeTicketRequest();
		Iterator<TicketRequest> iterator = this.iterator();
		while (iterator.hasNext()) {
			TicketRequest request = iterator.next();
			if (request.getFlightNumber() == flightNumber && request.getDepartureDate().equals(departureDate)) {
				list.addTicketRequest(request);
			}
		}
		return list;
	}
	
	public void showTicketRequestByNumberAndDate (int flightNumber, String departureDate) {
		ListNodeTicketRequest requests = this.findTicketRequestByNumberAndDate(flightNumber, departureDate);
		requests.showAllTicketRequests("Requests by flight number " + flightNumber + " and departure date " + departureDate + " :");
	}
	
	public void showAllTicketRequests(String s) {
		System.out.println(s);
		Iterator<TicketRequest> iterator = this.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	@Override
	public Iterator<TicketRequest> iterator() {
		return new NodeTicketRequestIterator(head);
	}
	
}
