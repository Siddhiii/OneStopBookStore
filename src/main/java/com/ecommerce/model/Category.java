package com.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")

public class Category {

	@Id
	@GeneratedValue
	int categoryid;
	String categoryname;
	String categorydescription;
	String categorystatus;
	
	
	public String getCategorystatus() {
		return categorystatus;
	}
	public void setCategorystatus(String categorystatus) {
		this.categorystatus = categorystatus;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getCategorydescription() {
		return categorydescription;
	}
	public void setCategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}
}
