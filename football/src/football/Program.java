package football;

public class Program {

	public static void main(String[] args) throws Exception {
		Football f = new Football("football", "localhost", 3306);
		f.show();
//		Team t = new Team(5, "FCSh");
//		t.addPlayer(new Player(8, "Crna", "Daniel", "attack"));
//		t.addPlayer(new Player(7, "Yarmolenko", "Andrey", "attack"));
//		f.addTeam(t);
		f.deleteTeam("FCSh");
		f.show();
	}

}
