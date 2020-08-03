package com.inventory.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="product_inventory")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	private String productName;
	private String productType;
	private Integer productQuantity;
	private Double productPrice;
	private Integer productsSold;
	public Product() {
		super();
	}
	
	public Product(Integer productId, String productName, String productType, Integer productQuantity,
			Double productPrice, Integer productsSold) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productsSold = productsSold;
	}

	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	
	public Integer getProductsSold() {
		return productsSold;
	}
	public void setProductsSold(Integer productsSold) {
		this.productsSold = productsSold;
	}
	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", productQuantity=" + productQuantity + ", productsSold=" + productsSold + ", productPrice=" + productPrice + "]";
	}
	
	
}
