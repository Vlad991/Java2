package ua.univer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO {
	
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/productDB", "root", "123root@");
	}
	
	public List<Integer> getPurchaseIds() throws Exception {
		List<Integer> purchaseIds = new ArrayList<Integer>();
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("select id_pu from purchases");
		while (res.next()) {
			purchaseIds.add(res.getInt("id_pu"));
		}
		res.close();
 //    	con.close();
		return purchaseIds;
	}
	
	public List<Purchase> getPurchaseById(int id) throws Exception {
		List<Purchase> purchases = new ArrayList<Purchase>();
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("select id, client_name, product_quantity " + "from purchases " + "where id_pu = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		ProductDAO productDAO = new ProductDAO();
		Purchase purchase = null;
		while (rs.next()) {
			purchase = new Purchase(id, rs.getString("client_name"), new Product(rs.getInt("id"), null, 0, 0), rs.getInt("product_quantity"));
			purchases.add(purchase);
		}
		rs.close();
		for (Purchase p : purchases) {
			p.setProduct(productDAO.getProductById(p.getProduct().getId()).get(0));
		}
//		con.close();
		return purchases;
	}
	
	public void addPurchase(Purchase purchase) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement( "insert into purchases " + "(id_pu, id, client_name, product_quantity) " + "values (?, ?, ?, ?)");
		st.setInt(1, purchase.getId());
		st.setInt(2, purchase.getProduct().getId());
		st.setString(3, purchase.getClientName());
		st.setInt(4, purchase.getProductQuantity());
		
		st.executeUpdate();
//		con.close();
	}
	
	public void setPurchase(Purchase purchase) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement( "update purchases " + "set id = ?, client_name = ?, product_quantity = ? " + "where id_pu = ?");
		st.setInt(1, purchase.getProduct().getId());
		st.setString(2, purchase.getClientName());
		st.setInt(3, purchase.getProductQuantity());
		st.setInt(4, purchase.getId());
		
		st.executeUpdate();
//		con.close();
	}
	
	public void removePurchase(int id) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("delete from purchases " + "where id_pu = ?");
		st.setInt(1, id);

		st.executeUpdate();
//		con.close();
	}
	
}
