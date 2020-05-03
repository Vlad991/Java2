package ua.univer.model.account;

public class Account {
	private int id;
	private int clientId;
	private int sum;
	private AccountStatus status;

	public Account(int id, int clientId, int sum, AccountStatus status) {
		this.id = id;
		this.clientId = clientId;
		this.sum = sum;
		this.status = status;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", clientId=" + clientId + ", sum=" + sum + ", status=" + status + "]";
	}

}
