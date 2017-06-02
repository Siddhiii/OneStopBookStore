package com.ecommerce.service;

import com.ecommerce.model.Supplier;

public interface SupIService {

	
	void SaveSupplier(Supplier supobj);
	String retrievesupplier();
	void deletesup(int id);
    
	void updatesup(Supplier sup);
	Supplier supfetchproductbyid(int id);
}
