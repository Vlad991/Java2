package ua.univer.controller.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.univer.model.client.Client;

public class ClientDAO {
	private static int newClientId;

	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/accountDB", "root", "123root@");
	}

	public List<Integer> getClientIds() throws Exception {
		List<Integer> clientIds = new ArrayList<Integer>();
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("select id_cl from clients");
		while (res.next()) {
			clientIds.add(res.getInt("id_cl"));
		}
		res.close();
		return clientIds;
	}

	public Client getClientById(int id) throws Exception {
		Client client = null;
		Connection con = getConnection();
		PreparedStatement st = con
				.prepareStatement("select name, surname, date_of_birth " + "from clients " + "where id_cl = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			client = new Client(id, rs.getString("name"), rs.getString("surname"), rs.getString("date_of_birth"));
		}
		rs.close();
		return client;
	}

	public Client getClientByName(String name) throws Exception {
		Client client = null;
		Connection con = getConnection();
		PreparedStatement st = con
				.prepareStatement("select id_cl, surname, date_of_birth " + "from clients " + "where name = ?");
		st.setString(1, name);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			client = new Client(rs.getInt("id_cl"), name, rs.getString("surname"), rs.getString("date_of_birth"));
		}
		rs.close();
		return client;
	}

	public void addClient(Client client) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con
				.prepareStatement("insert into clients (id_cl, name, surname, date_of_birth) " + "values (?, ?, ?, ?)");
		st.setInt(1, client.getId());
		st.setString(2, client.getName());
		st.setString(3, client.getSurname());
		st.setString(4, client.getDateOfBirth());

		st.executeUpdate();
	}

	public void setClient(Client client) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con
				.prepareStatement("update clients " + "set name= ?, surname= ?, date_of_birth= ? " + "where id_cl = ?");
		st.setString(1, client.getName());
		st.setString(2, client.getSurname());
		st.setString(3, client.getDateOfBirth());
		st.setInt(4, client.getId());

		st.executeUpdate();
	}

	public void removeClient(int id) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("delete from clients " + "where id_cl = ?");
		st.setInt(1, id);

		st.executeUpdate();
	}

	public String getClientPass(int id) throws Exception {
		String pass = null;
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("select pass " + "from clients " + "where id_cl = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			pass = rs.getString("pass");
		}
		rs.close();
		return pass;
	}

	public void setClientPass(int id, String pass) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("update clients " + "set pass = " + pass + " where id_cl = ?");
		st.setInt(1, id);

		st.executeUpdate();
	}
	
	public boolean clientIsExist(String name, String pass) throws Exception {
		if ((getClientByName(name) != null) && ((getClientPass(getClientByName(name).getId())).equals(pass))) {
			return true;
		} else {
			return false;
		}
	}
	
	public void closeConnection() {
	}
	
}
