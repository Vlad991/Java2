package ua.univer;

import java.io.Serializable;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	private float rate;
	private int quantity;
	
	public Product(int id, String description, float rate, int quantity) {
		super();
		this.id = id;
		this.description = description;
		this.rate = rate;
		this.quantity = quantity;
	}
	
	
	
	public Product() {
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", rate=" + rate + ", quantity=" + quantity + "]";
	}
	
	
}
