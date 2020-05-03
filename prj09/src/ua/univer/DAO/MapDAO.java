package ua.univer.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class MapDAO {
	private static int idCounter = 0;
	private static LinkDAO links = new LinkDAO();
	private static WordDAO words = new WordDAO();

	private static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shekspir", "root", "123root@");
	}

	public static HashMap<String, Integer> getWordFreqInLink(String word) {
		return null;
	}

	public static HashMap<String, HashMap<String, Integer>> getWordsFreqInLinks() {
		return null;
	}
	
//	public void addHashMap(HashMap<String, HashMap<String, Integer>> maps) { //{ word : { link : freq } }
//		Connection con = getConnection();
//		if (maps.get) {
//			
//		}
//		PreparedStatement st = con.prepareStatement( "insert into map " + "(id, id_w, id_li, frequency) " + "values (?, ?, ?, ?)");
//		st.setInt(1, product.getId());
//		st.setString(2, product.getDescription());
//		st.setFloat(3, product.getRate());
//		st.setInt(4, product.getQuantity());
//		
//		st.executeUpdate();
//		con.close();
//	}
	
	public static void addMap(String word, String link, int freq) throws Exception { 
		Connection con = getConnection();
		int idW = words.getWordId(word);
		int idLi = links.getLinkId(link);
		PreparedStatement st = con.prepareStatement( "insert into maps " + "(id, id_w, id_li, frequency) " + "values (?, ?, ?, ?)");
		st.setInt(1, ++idCounter);
		st.setInt(2, idW);
		st.setInt(3, idLi);
		st.setInt(4, freq);
		
		st.executeUpdate();
//		con.close();
	}
	
//	public static boolean mapIsAviable(String word, String link) throws Exception {
//		Connection con = getConnection();
//		boolean bool = false;
//		int idW = words.getWordId(word);
//		int idLi = links.getLinkId(link);
//		PreparedStatement st = con.prepareStatement("select id_li from maps where id_w = ?");
//		st.setInt(1, idW);
//		ResultSet rs = st.executeQuery();
//		while (rs.next()) {
//			if (rs.getInt("id_Li") == id) {
//				if () {
//					bool = true;
//				}
//			}
//		}
//		rs.close();
////		con.close();
//		return bool;
//	}

}
