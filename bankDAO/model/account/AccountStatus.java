package ua.univer.model.account;

public enum AccountStatus {
	OPEN("open"),
	BLOCKED("blocked");
	
	private String description;
	
	private AccountStatus(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
