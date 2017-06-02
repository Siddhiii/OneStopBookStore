package com.ecommerce.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table (name="productlist")//to provide tablename
public class ProductInfo{

	@Id
	@GeneratedValue
	
	int productid;
	String productname;
	double productprice;
	String description;
	String productstatus;
	 int supplierId;
	 int categoryid;
     
	 @Transient
	MultipartFile product_img;
	 
	
	public MultipartFile getProduct_img() {
		return product_img;
	}
	public void setProduct_img(MultipartFile product_img) {
		this.product_img = product_img;
	}
	public String getProductstatus() {
		return productstatus;
	}
	public void setProductstatus(String productstatus) {
		this.productstatus = productstatus;
	}
	public ProductInfo() {
	
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	
	
}
