package ua.univer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.source.tree.WhileLoopTree;

public class ProductDAO {
	
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/productDB", "root", "123root@");
	}
	
	public List<Integer> getProductIds() throws Exception {
		List<Integer> productIds = new ArrayList<Integer>();
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("select id from products");
		while (res.next()) {
			productIds.add(res.getInt("id"));
		}
		res.close();
//		con.close();
		return productIds;
	}
	
	public List<Product> getProductById(int id) throws Exception {
		List<Product> products = new ArrayList<Product>();
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("select description, rate, quantity " + "from products " + "where id = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		Product product = null;
		while (rs.next()) {
			product = new Product(id, rs.getString("description"), rs.getFloat("rate"), rs.getInt("quantity"));
			products.add(product);
		}
		rs.close();
//		con.close();
		return products;
	}
	
	public void addProduct(Product product) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement( "insert into products " + "(id, description, rate, quantity) " + "values (?, ?, ?, ?)");
		st.setInt(1, product.getId());
		st.setString(2, product.getDescription());
		st.setFloat(3, product.getRate());
		st.setInt(4, product.getQuantity());
		
		st.executeUpdate();
//		con.close();
	}
	
	public void setProduct(Product product) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement( "update products " + "set description = ?, rate= ?, quantity= ? " + "where id = ?");
		st.setString(1, product.getDescription());
		st.setFloat(2, product.getRate());
		st.setInt(3, product.getQuantity());
		st.setInt(4, product.getId());
		
		st.executeUpdate();
//		con.close();
	}
	
	public void removeProduct(int id) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("delete from products " + "where id = ?");
		st.setInt(1, id);

		st.executeUpdate();
//		con.close();
	}	
	
	
}
