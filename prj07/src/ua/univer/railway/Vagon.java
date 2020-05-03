package ua.univer.railway;

enum EVagonType {
	Cargo, Pass;
}

public class Vagon {
	private EVagonType vagonType;

	public EVagonType getVagonType() {
		return vagonType;
	}

	public void setVagonType(EVagonType vagonType) {
		this.vagonType = vagonType;
	}

	public Vagon(EVagonType vagonType) {
		this.vagonType = vagonType;
	}
	
	public Vagon(String vagonStr) {
		this.vagonType = EVagonType.valueOf(vagonStr);
	}

	@Override
	public String toString() {
		return "Vagon [vagonType=" + vagonType + "]";
	}
	
	
}
