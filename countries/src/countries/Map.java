package countries;

import java.sql.*;

public class Map {
	private Connection con = null;
	private Statement stmt = null;
	
	public Map(String DBName, String ip, int port) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		 String url = "jdbc:mysql://"+ip+":"+port+"/"+DBName; 
		 con = DriverManager.getConnection(url, "root", "123root@"); 
		 stmt = con.createStatement();
	}
	
	public void stop() throws SQLException {
		con.close();
	}
	
	public boolean addCountry(int id, String name) throws SQLException {
	    String sql = "INSERT INTO COUNTRIES (ID_CO, NAME)" + "VALUES ("+id+", '"+name+"')";
	    try {
	    stmt.executeUpdate(sql);
	    System.out.println("Страна "+name+" успешно добавлена!");
	    return true;
	    } catch (SQLException e) {
	    	System.out.println("ОШИБКА! Страна "+name+" не добавлена!");
	    	System.out.println("     >>" + e.getMessage());
	    	return false;
		}
	}
	
	public boolean deleteCountry(int id) throws SQLException {
	    String sql = "DELETE FROM COUNTRIES WHERE ID_CO = "+id;
	    try {
	    int c = stmt.executeUpdate(sql);
	    if (c>0) {
	    	System.out.println("Страна с идентификатором "+ id +" успешно удалена!");
	    	return true;
	    } else {
	    	System.out.println("Страна с идентификатором "+ id +" не найдена!");
	    	return false;
	    }
	    } catch (SQLException e) {
	    	System.out.println("ОШИБКА при удалении страны с идентификатором "+id);
	    	System.out.println("     >> "+e.getMessage());
	    	return false;
		}
	}
	
	public void showCountries() throws SQLException {
		String sql = "SELECT ID_CO, NAME FROM COUNTRIES";
		try {
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("СПИСОК СТРАН:");
	    while (rs.next()) {
	    	int id = rs.getInt("ID_CO");
	    	String name = rs.getString("NAME");
	    	System.out.println(" >> "+ id + " - " + name);
	    }
	    rs.close();
		} catch (SQLException e) {
			System.out.println("ОШИБКА при получении списка стран");
			System.out.println("     >> "+e.getMessage());
		}
	}
	
	
}