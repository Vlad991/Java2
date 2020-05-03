package ua.univer.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WordDAO {
	private int idCounter = 0;

	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shekspir", "root", "123root@");
	}

	public List<Integer> getWordIds() {
		return null;
	}
	
	public int getWordId(String word) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("select id_w from words where word = ?");
		st.setString(1, word);
		ResultSet rs = st.executeQuery();
		int id = 0;
		if (rs.next()) 
			id = rs.getInt("id_w");
		return id;
		
	}

	public String getWordById(int id) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("select word from words where id_w = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		String word = null;
		if (rs.next()) {
			word = rs.getString("word");
		}
		rs.close();
//		con.close();
		return word;
	}

	public void addWord(String word) throws Exception {
		Connection con = getConnection();
		if (!wordIsAviable(word)) {
			PreparedStatement st = con.prepareStatement("insert into words values (?, ?)");
			st.setInt(1, ++idCounter);
			st.setString(2, word);
			st.executeUpdate();
		}

//		con.close();
	}

	public boolean wordIsAviable(String word) throws Exception {
		Connection con = getConnection();
		boolean bool = false;
		PreparedStatement st = con.prepareStatement("select word from words");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			if (rs.getString("word").equals(word)) {
				bool = true;
			}
		}
		rs.close();
//		con.close();
		return bool;
	}

}
