package com.ecommerce.service;

import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.Supplier;

public interface IService {
	void addproduct(ProductInfo prodinfo);
	String retrieveproduct();
	void deleteProduct(int id);
	
	ProductInfo fetchProductbyid(int id);
	void updateproduct(ProductInfo proobj);
	void setProductstatus(int id,String status);
	String fetchAllproduct();
}
