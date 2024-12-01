package com;

public class Product {
	
	private int productId;
	private String name ;
	private double price;
	private int quantity;
//	private static int id =1;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	
//	public Product(int productId, String name, double price, int quantity) {
//		super();
//		this.productId = productId;
//		this.name = name;
//		this.price = price;
//		this.quantity = quantity;
//	}


	
	
	
	
	
	

}
