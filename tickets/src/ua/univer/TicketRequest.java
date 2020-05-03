package ua.univer;

public class TicketRequest {
	private String destination;
	private int flightNumber;
	private String passengerName;
	private String departureDate;
	
	public TicketRequest(String destination, int flightNumber, String passengerName, String departureDate) {
		super();
		this.destination = destination;
		this.flightNumber = flightNumber;
		this.passengerName = passengerName;
		this.departureDate = departureDate;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	

	@Override
	public String toString() {
		return "TicketRequest [destination=" + destination + ", flightNumber=" + flightNumber + ", passengerName="
				+ passengerName + ", departureDate=" + departureDate + "]";
	}
	
	
}
