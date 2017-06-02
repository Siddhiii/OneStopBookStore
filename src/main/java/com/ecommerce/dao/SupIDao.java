package com.ecommerce.dao;

import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.Supplier;

public interface SupIDao {

	
	void SaveSupplier(Supplier supobj);
	String retrievesupplier();
	
	void deletesup(int id);
	Supplier supfetchproductbyid(int id);
	void updatesup(Supplier sup);
}
