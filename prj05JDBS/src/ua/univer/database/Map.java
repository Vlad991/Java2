package ua.univer.database;

import java.sql.*;
import java.util.ArrayList;

public class Map {
	Connection con;
	Statement stmt;
public Map() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");//???????????????????????????????????????????????????????
	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mapdb", "root", "123root@");
	stmt= con.createStatement();
}
public void show() throws SQLException{
	String sql = "SELECT * FROM countries";
	ResultSet res = stmt.executeQuery(sql);
	while(res.next()){
		int id =res.getInt("ID_CO");
		String name = res.getString("name");
		Country country = new Country(id,name);
		getCountry(id);
		System.out.println(country);
	}
}

//public ArrayList getCountry(int id) {
//	String sql = "SELECT * FROM cities where id_co="+id;
//}

public void addCountry(Country country) throws SQLException{
	String sql = "insert into countries values("+country.getId()+", '"+country.getName()+"')";
	stmt.executeUpdate(sql);
}

public void deleteCountry(String name) throws SQLException{
	String sql = "DELETE FROM countries WHERE name='"+name+"'";
	stmt.executeUpdate(sql);
}
}
