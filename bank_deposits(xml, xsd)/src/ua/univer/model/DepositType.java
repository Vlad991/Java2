package ua.univer.model;

public enum DepositType {
	DEMAND("demand"),
	TIME("time"),
	SETTLEMENT("settlement"),
	SAVINGS("saving"),
	METAL("metal");
	
	private String description;
	
	private DepositType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
	   return description;
	}

}
