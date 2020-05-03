package ua.univer;

public class Program {

	public static void main(String[] args) {
		ListNodeTicketRequest tickets = new ListNodeTicketRequest();
		tickets.addTicketRequest(new TicketRequest("USA", 1, "Ivanov V.V.", "21.02.2019"));
		tickets.addTicketRequest(new TicketRequest("UK", 2, "Petrov P.P.", "22.02.2019"));
		tickets.addTicketRequest(new TicketRequest("RUS", 3, "Smirnov S.S.", "23.02.2019"));
		tickets.addTicketRequest(new TicketRequest("UKR", 4, "Popov P.P.", "24.02.2019"));
		tickets.addTicketRequest(new TicketRequest("MEX", 5, "Krivov K.K.", "25.02.2019"));
		tickets.showAllTicketRequests("All ticket requests: ");
		System.out.println("Erase: ");
		System.out.println(tickets.eraseTicketRequestByPassengerName("Popov P.P."));
		tickets.showAllTicketRequests("All ticket requests: ");
		tickets.showTicketRequestByNumberAndDate(2, "22.02.2019");
		
	}

}
