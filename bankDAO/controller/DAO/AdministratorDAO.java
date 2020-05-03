package ua.univer.controller.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.univer.model.administrator.Administrator;

public class AdministratorDAO {
	private static int newAdministratorId;

	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/accountDB", "root", "123root@");
	}

	public List<Integer> getAdministratorIds() throws Exception {
		List<Integer> adminIds = new ArrayList<Integer>();
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("select id_ad from administrators");
		while (res.next()) {
			adminIds.add(res.getInt("id_ad"));
		}
		res.close();
		return adminIds;
	}

	public Administrator getAdministratorById(int id) throws Exception {
		Administrator admin  = null;
		Connection con = getConnection();
		PreparedStatement st = con
				.prepareStatement("select name, surname " + "from administrators " + "where id_ad = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			admin = new Administrator(id, rs.getString("name"), rs.getString("surname"));
		}
		rs.close();
		return admin;
	}

	public Administrator getAdministratorByName(String name) throws Exception {
		Administrator admin = null;
		Connection con = getConnection();
		PreparedStatement st = con
				.prepareStatement("select id_ad, surname " + "from administrators " + "where name = ?");
		st.setString(1, name);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			admin = new Administrator(rs.getInt("id_ad"), name, rs.getString("surname"));
		}
		rs.close();
		return admin;
	}

	public void addAdministrator(Administrator admin) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("insert into administrators (id_ad, name, surname) " + "values (?, ?, ?)");
		st.setInt(1, admin.getId());
		st.setString(2, admin.getName());
		st.setString(3, admin.getSurname());

		st.executeUpdate();
	}

	public void setAdministrator(Administrator admin) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con
				.prepareStatement("update administrators " + "set name= ?, surname= ? " + "where id_ad = ?");
		st.setString(1, admin.getName());
		st.setString(2, admin.getSurname());
		st.setInt(3, admin.getId());

		st.executeUpdate();
	}

	public void removeAdministrator(int id) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("delete from administrators " + "where id_ad = ?");
		st.setInt(1, id);

		st.executeUpdate();
	}
	
	public String getAdministratorPass(int id) throws Exception {
		String pass = null;
		Connection con = getConnection();
		PreparedStatement st = con
				.prepareStatement("select pass " + "from administrators " + "where id_ad = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			pass = rs.getString("pass");
		}
		rs.close();
		return pass;
	}
	
	public void setAdministratorPass(int id, String pass) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con
				.prepareStatement("update administrators " + "set pass = " + pass + " where id_ad = ?");
		st.setInt(1, id);

		st.executeUpdate();
	}
	
	public boolean adminIsExist(String name, String pass) throws Exception {
		if ((getAdministratorByName(name) != null) && ((getAdministratorPass(getAdministratorByName(name).getId())).equals(pass))) {
			return true;
		} else {
			return false;
		}
	}
	
	public void closeConnection() {
	}
}
