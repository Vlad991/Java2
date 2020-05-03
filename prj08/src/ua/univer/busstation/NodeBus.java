package ua.univer.busstation;

public class NodeBus {
	private Bus data;
	public NodeBus next;
	
	public NodeBus(Bus bus) {
		data = bus;
		next = null;      //ссылка
	}

	public Bus getData() {
		return data;
	}
	
}
