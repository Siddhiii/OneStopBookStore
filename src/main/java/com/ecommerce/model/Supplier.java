package com.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Supplier")//to provide tablename
public class Supplier{

	@Id
	@GeneratedValue
	 int supplierId;
     String supplierName;
     String supplierContact;
     String supplierAdress;
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierContact() {
		return supplierContact;
	}
	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}
	public String getSupplierAdress() {
		return supplierAdress;
	}
	public void setSupplierAdress(String supplierAdress) {
		this.supplierAdress = supplierAdress;
	}

	
}
