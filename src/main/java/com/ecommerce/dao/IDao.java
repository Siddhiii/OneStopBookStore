package com.ecommerce.dao;

import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.Supplier;

public interface IDao {
  
	void addproduct(ProductInfo prodinfo);
	String retrieveproduct();
	void deleteProduct(int id);
	ProductInfo fetchProductbyid(int id);
	void updateproduct(ProductInfo proobj);
	void productstatus(int id,String status);
	String fetchAllproduct();
	
	
	
}
