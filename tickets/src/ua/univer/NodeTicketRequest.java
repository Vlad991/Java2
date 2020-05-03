package ua.univer;

public class NodeTicketRequest {
	private TicketRequest data;
	public NodeTicketRequest next;
	
	public NodeTicketRequest(TicketRequest ticketRequest) {
		this.data = ticketRequest;
	}

	public TicketRequest getData() {
		return data;
	}
	
	
}
