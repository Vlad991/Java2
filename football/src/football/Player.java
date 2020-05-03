package football;

public class Player {
	private int id;
	private String firstName;
	private String lastName;
	private String gamePosition;
	
	public Player(int id, String firstName, String lastName, String gamePosition) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gamePosition = gamePosition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGamePosition() {
		return gamePosition;
	}

	public void setGamePosition(String gamePosition) {
		this.gamePosition = gamePosition;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gamePosition="
				+ gamePosition + "]";
	}
	
}
