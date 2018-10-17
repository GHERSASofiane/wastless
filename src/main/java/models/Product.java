package models;

import java.awt.Image;

public class Product {

	private int productId;
	private String productName;
	private String productDescription;
	private double productPrice;
	private String productPicture;
	private int productStatus;
	private int userId;
	private String productDate;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductPecture() {
		return productPicture;
	}
	public void setProductPicture(String productPecture) {
		this.productPicture = productPecture;
	}
	public int getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProductDate() {
		return productDate;
	}
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	
	
}
