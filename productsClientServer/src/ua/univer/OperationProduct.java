package ua.univer;

import java.io.Serializable;

public class OperationProduct implements Serializable{
	private static final long serialVersionUID = 1L;
	private String operation;
	private Product product;
	
	public OperationProduct() {
		super();
	}
	
	public OperationProduct(String operation, Product product) {
		this.operation = operation;
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	

}
