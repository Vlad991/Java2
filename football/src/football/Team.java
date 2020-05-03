package football;

import java.awt.print.Printable;
import java.util.Arrays;

public class Team {
	private int id;
	private String name;
	private Player players[];
	private int count;
	
	public Team() {
		players = new Player[0];
		count = -1;
	}

	public Team(int id, String name) {
		this.id = id;
		this.name = name;
		players = new Player[0];
		count = -1;
	}
	
	public void addPlayer(Player pl) {
		if (count == players.length-1) {
			players = Arrays.copyOf(players, players.length + 1);
		}
		players[++count] = pl;
	}
	
	public Player getPlayer(int i) {
		if(i < size())
			return players[i];
			else return null;
	}
	
	public int size() {
		return count+1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", players=" + Arrays.toString(players) + "]";
	}
	
}
