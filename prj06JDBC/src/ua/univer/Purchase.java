package ua.univer;

import java.util.ArrayList;

public class Purchase {
	private int id;
	private String clientName;
	private Product product; //название продукта, который куплен
	private int productQuantity; //количество этого продукта
	private float sum;
	
	public Purchase(int id, String clientName, Product product, int productQuantity) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.product = product;
		this.productQuantity = productQuantity;
		this.countTheSum();
	}
	
	public void countTheSum() {
		sum = productQuantity * product.getRate();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public float getSum() {
		this.countTheSum();
		return sum;
	}
	

	@Override
	public String toString() {
		countTheSum();
		return "Purchase [id=" + id + ", clientName=" + clientName + ", product=" + product + ", productQuantity="
				+ productQuantity + ", sum=" + sum + "]";
	}
	
	
}
