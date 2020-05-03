package ua.univer.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LinkDAO {
	private int idCounter = 0;
	
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shekspir", "root", "123root@");
	}
	
	public List<Integer> getLinkIds() {
		return null;
	}
	
	public int getLinkId(String link) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("select id_li from links where link = ?");
		st.setString(1, link);
		ResultSet rs = st.executeQuery();
		int id = 0;
		if (rs.next()) 
			id = rs.getInt("id_li");
		return id;
		
	}

	public String getLinkById(int id) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("select link from links where id_li = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		String link = null;
		if (rs.next()) {
			link = rs.getString("link");
		}
		rs.close();
//		con.close();
		return link;
	}

	public void addLink(String link) throws Exception {
		Connection con = getConnection();
		if (!linkIsAviable(link)) {
			PreparedStatement st = con.prepareStatement("insert into links values (?, ?)");
			st.setInt(1, ++idCounter);
			st.setString(2, link);
			st.executeUpdate();
		}
//		con.close();
	}

	public boolean linkIsAviable(String link) throws Exception {
		Connection con = getConnection();
		boolean bool = false;
		PreparedStatement st = con.prepareStatement("select link from links");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			if (rs.getString("link").equals(link)) {
				bool = true;
			}
		}
		rs.close();
//		con.close();
		return bool;
	}
	
	
}
