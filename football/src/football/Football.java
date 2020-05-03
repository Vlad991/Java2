package football;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Football {
	private Connection con = null;
	private Statement stmt = null;
	
	
	public Football(String DBName, String ip, int port) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 String url = "jdbc:mysql://"+ip+":"+port+"/"+DBName; 
		 con = DriverManager.getConnection(url, "root", "123root@"); 
		 stmt = con.createStatement();
	}
	
	public void stop() throws SQLException {
		con.close();
	}
	
	public void show() throws SQLException {
		String sql = "select * from teams";
		ResultSet res = stmt.executeQuery(sql);
		ArrayList<Team> teams = new ArrayList<Team>();
		
		while (res.next()) {
			Team team = new Team(res.getInt("id_te"), res.getString("name"));
			teams.add(team);
		}
		
		for (Team team : teams) {
			ArrayList players = this.getPlayers(team.getId());
			for (int i = 0; i < players.size(); i++) {
				team.addPlayer((Player)players.get(i));;
			}
			team.print();
		}
	}
	
	private ArrayList getPlayers(int id) throws SQLException {
		ArrayList players = new ArrayList();
		String sql = "select * from players where id_te = " + id;
		ResultSet res = stmt.executeQuery(sql);
		while (res.next()) {
			players.add(new Player(res.getInt("id_pl"), res.getString("first_name"), res.getString("last_name"), res.getString("game_position")));
		}
		return players;
	}
	
	public void addTeam(Team team) throws SQLException {
		String sql = "insert into teams values("+team.getId()+", '"+team.getName()+"')";
		stmt.executeUpdate(sql);
		for (int i = 0; i < team.size(); i++) {
			sql = "insert into players values("+team.getPlayer(i).getId()+", "+team.getId()+", '"+team.getPlayer(i).getFirstName()+"', '"+team.getPlayer(i).getLastName()+"', '"+team.getPlayer(i).getGamePosition()+"')";
			stmt.executeUpdate(sql);
		}
	}
	
	public void deleteTeam(String name) throws SQLException {
		String sql = "delete from teams where name='"+name+"'";
		stmt.executeUpdate(sql);
		this.deletePlayersWhereTeam(name);
	}

	private void deletePlayersWhereTeam(String name) throws SQLException {
		String sql = "select id_te from teams where name = '" + name + "'" ;
		ResultSet res = stmt.executeQuery(sql);
		
		res.next();
		String sql1 = "delete from players where id_te = " + res.getInt("id_te");
		stmt.executeUpdate(sql1);
	}

}
